/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.test.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import com.tugas_trias.test.service.TestProcedureExecutorService;

@RestController(value = "Test.ProcedureExecutionController")
@RequestMapping("/test/procedureExecutor")
@Api(value = "ProcedureExecutionController", description = "controller class for procedure execution")
public class ProcedureExecutionController {


    @Autowired
    private TestProcedureExecutorService procedureService;


}