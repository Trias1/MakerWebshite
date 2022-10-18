/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.wavemaker.commons.InvalidInputException;
import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.annotations.EntityService;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;

import com.tugas_trias.salesdb.Tasks;


/**
 * ServiceImpl object for domain model class Tasks.
 *
 * @see Tasks
 */
@Service("salesdb.TasksService")
@Validated
@EntityService(entityClass = Tasks.class, serviceId = "salesdb")
public class TasksServiceImpl implements TasksService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TasksServiceImpl.class);


    @Autowired
    @Qualifier("salesdb.TasksDao")
    private WMGenericDao<Tasks, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Tasks, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public Tasks create(Tasks tasks) {
        LOGGER.debug("Creating a new Tasks with information: {}", tasks);

        Tasks tasksCreated = this.wmGenericDao.create(tasks);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tasksCreated);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Tasks getById(Integer tasksId) {
        LOGGER.debug("Finding Tasks by id: {}", tasksId);
        return this.wmGenericDao.findById(tasksId);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Tasks findById(Integer tasksId) {
        LOGGER.debug("Finding Tasks by id: {}", tasksId);
        try {
            return this.wmGenericDao.findById(tasksId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Tasks found with id: {}", tasksId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public List<Tasks> findByMultipleIds(List<Integer> tasksIds, boolean orderedReturn) {
        LOGGER.debug("Finding Tasks by ids: {}", tasksIds);

        return this.wmGenericDao.findByMultipleIds(tasksIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public Tasks update(Tasks tasks) {
        LOGGER.debug("Updating Tasks with information: {}", tasks);

        this.wmGenericDao.update(tasks);
        this.wmGenericDao.refresh(tasks);

        return tasks;
    }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public Tasks partialUpdate(Integer tasksId, Map<String, Object>tasksPatch) {
        LOGGER.debug("Partially Updating the Tasks with id: {}", tasksId);

        Tasks tasks = getById(tasksId);

        try {
            ObjectReader tasksReader = this.objectMapper.reader().forType(Tasks.class).withValueToUpdate(tasks);
            tasks = tasksReader.readValue(this.objectMapper.writeValueAsString(tasksPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", tasksPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        tasks = update(tasks);

        return tasks;
    }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public Tasks delete(Integer tasksId) {
        LOGGER.debug("Deleting Tasks with id: {}", tasksId);
        Tasks deleted = this.wmGenericDao.findById(tasksId);
        if (deleted == null) {
            LOGGER.debug("No Tasks found with id: {}", tasksId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Tasks.class.getSimpleName(), tasksId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public void delete(Tasks tasks) {
        LOGGER.debug("Deleting Tasks with {}", tasks);
        this.wmGenericDao.delete(tasks);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Tasks> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Tasks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Tasks> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Tasks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service salesdb for table Tasks to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service salesdb for table Tasks to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}