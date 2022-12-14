/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.test.service;

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

import com.tugas_trias.test.Product;


/**
 * ServiceImpl object for domain model class Product.
 *
 * @see Product
 */
@Service("test.ProductService")
@Validated
@EntityService(entityClass = Product.class, serviceId = "test")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    @Qualifier("test.ProductDao")
    private WMGenericDao<Product, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Product, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "testTransactionManager")
    @Override
    public Product create(Product product) {
        LOGGER.debug("Creating a new Product with information: {}", product);

        Product productCreated = this.wmGenericDao.create(product);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(productCreated);
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public Product getById(Integer productId) {
        LOGGER.debug("Finding Product by id: {}", productId);
        return this.wmGenericDao.findById(productId);
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public Product findById(Integer productId) {
        LOGGER.debug("Finding Product by id: {}", productId);
        try {
            return this.wmGenericDao.findById(productId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Product found with id: {}", productId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public List<Product> findByMultipleIds(List<Integer> productIds, boolean orderedReturn) {
        LOGGER.debug("Finding Products by ids: {}", productIds);

        return this.wmGenericDao.findByMultipleIds(productIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "testTransactionManager")
    @Override
    public Product update(Product product) {
        LOGGER.debug("Updating Product with information: {}", product);

        this.wmGenericDao.update(product);
        this.wmGenericDao.refresh(product);

        return product;
    }

    @Transactional(value = "testTransactionManager")
    @Override
    public Product partialUpdate(Integer productId, Map<String, Object>productPatch) {
        LOGGER.debug("Partially Updating the Product with id: {}", productId);

        Product product = getById(productId);

        try {
            ObjectReader productReader = this.objectMapper.reader().forType(Product.class).withValueToUpdate(product);
            product = productReader.readValue(this.objectMapper.writeValueAsString(productPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", productPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        product = update(product);

        return product;
    }

    @Transactional(value = "testTransactionManager")
    @Override
    public Product delete(Integer productId) {
        LOGGER.debug("Deleting Product with id: {}", productId);
        Product deleted = this.wmGenericDao.findById(productId);
        if (deleted == null) {
            LOGGER.debug("No Product found with id: {}", productId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Product.class.getSimpleName(), productId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "testTransactionManager")
    @Override
    public void delete(Product product) {
        LOGGER.debug("Deleting Product with {}", product);
        this.wmGenericDao.delete(product);
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public Page<Product> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public Page<Product> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "testTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service test for table Product to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "testTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service test for table Product to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "testTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}