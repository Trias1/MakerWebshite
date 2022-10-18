/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.commons.file.manager.ExportedFileManager;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.tugas_trias.salesdb.Products;
import com.tugas_trias.salesdb.Sales;
import com.tugas_trias.salesdb.service.ProductsService;


/**
 * Controller object for domain model class Products.
 * @see Products
 */
@RestController("salesdb.ProductsController")
@Api(value = "ProductsController", description = "Exposes APIs to work with Products resource.")
@RequestMapping("/salesdb/Products")
public class ProductsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
	@Qualifier("salesdb.ProductsService")
	private ProductsService productsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Products instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Products createProducts(@RequestBody Products products) {
		LOGGER.debug("Create Products with information: {}" , products);

		products = productsService.create(products);
		LOGGER.debug("Created Products with information: {}" , products);

	    return products;
	}

    @ApiOperation(value = "Returns the Products instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Products getProducts(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Products with id: {}" , id);

        Products foundProducts = productsService.getById(id);
        LOGGER.debug("Products details with id: {}" , foundProducts);

        return foundProducts;
    }

    @ApiOperation(value = "Updates the Products instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Products editProducts(@PathVariable("id") Integer id, @RequestBody Products products) {
        LOGGER.debug("Editing Products with id: {}" , products.getId());

        products.setId(id);
        products = productsService.update(products);
        LOGGER.debug("Products details with id: {}" , products);

        return products;
    }
    
    @ApiOperation(value = "Partially updates the Products instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Products patchProducts(@PathVariable("id") Integer id, @RequestBody @MapTo(Products.class) Map<String, Object> productsPatch) {
        LOGGER.debug("Partially updating Products with id: {}" , id);

        Products products = productsService.partialUpdate(id, productsPatch);
        LOGGER.debug("Products details after partial update: {}" , products);

        return products;
    }

    @ApiOperation(value = "Deletes the Products instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProducts(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Products with id: {}" , id);

        Products deletedProducts = productsService.delete(id);

        return deletedProducts != null;
    }

    /**
     * @deprecated Use {@link #findProducts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Products instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Products> searchProductsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Products list by query filter:{}", (Object) queryFilters);
        return productsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Products instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Products> findProducts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Products list by filter:", query);
        return productsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Products instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Products> filterProducts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Products list by filter", query);
        return productsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProducts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return productsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportProductsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Products.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> productsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Products instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProducts( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Products");
		return productsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getProductsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return productsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/saleses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the saleses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Sales> findAssociatedSaleses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated saleses");
        return productsService.findAssociatedSaleses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProductsService instance
	 */
	protected void setProductsService(ProductsService service) {
		this.productsService = service;
	}

}