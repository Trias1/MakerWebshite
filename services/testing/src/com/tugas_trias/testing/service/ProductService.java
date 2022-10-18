/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.testing.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;

import com.tugas_trias.testing.Product;

/**
 * Service object for domain model class {@link Product}.
 */
public interface ProductService {

    /**
     * Creates a new Product. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Product if any.
     *
     * @param product Details of the Product to be created; value cannot be null.
     * @return The newly created Product.
     */
    Product create(@Valid Product product);


	/**
     * Returns Product by given id if exists.
     *
     * @param productId The id of the Product to get; value cannot be null.
     * @return Product associated with the given productId.
	 * @throws EntityNotFoundException If no Product is found.
     */
    Product getById(Integer productId);

    /**
     * Find and return the Product by given id if exists, returns null otherwise.
     *
     * @param productId The id of the Product to get; value cannot be null.
     * @return Product associated with the given productId.
     */
    Product findById(Integer productId);

	/**
     * Find and return the list of Products by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param productIds The id's of the Product to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Products associated with the given productIds.
     */
    List<Product> findByMultipleIds(List<Integer> productIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Product. It replaces all fields of the existing Product with the given product.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Product if any.
     *
     * @param product The details of the Product to be updated; value cannot be null.
     * @return The updated Product.
     * @throws EntityNotFoundException if no Product is found with given input.
     */
    Product update(@Valid Product product);


    /**
     * Partially updates the details of an existing Product. It updates only the
     * fields of the existing Product which are passed in the productPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Product if any.
     *
     * @param productId The id of the Product to be deleted; value cannot be null.
     * @param productPatch The partial data of Product which is supposed to be updated; value cannot be null.
     * @return The updated Product.
     * @throws EntityNotFoundException if no Product is found with given input.
     */
    Product partialUpdate(Integer productId, Map<String, Object> productPatch);

    /**
     * Deletes an existing Product with the given id.
     *
     * @param productId The id of the Product to be deleted; value cannot be null.
     * @return The deleted Product.
     * @throws EntityNotFoundException if no Product found with the given id.
     */
    Product delete(Integer productId);

    /**
     * Deletes an existing Product with the given object.
     *
     * @param product The instance of the Product to be deleted; value cannot be null.
     */
    void delete(Product product);

    /**
     * Find all Products matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Products.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Product> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Products matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Products.
     *
     * @see Pageable
     * @see Page
     */
    Page<Product> findAll(String query, Pageable pageable);

    /**
     * Exports all Products matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Products matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Products in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Product.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}