/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.test.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;
import com.wavemaker.runtime.data.dao.query.types.wmql.WMQLTypeHelper;

import com.tugas_trias.test.Cart;

/**
 * Specifies methods used to obtain and modify Cart related information
 * which is stored in the database.
 */
@Repository("test.CartDao")
public class CartDao extends WMGenericDaoImpl<Cart, Integer> {

    @Autowired
    @Qualifier("testTemplate")
    private HibernateTemplate template;

    @Autowired
    @Qualifier("testWMQLTypeHelper")
    private WMQLTypeHelper wmqlTypeHelper;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }

    @Override
    public WMQLTypeHelper getWMQLTypeHelper() {
        return this.wmqlTypeHelper;
    }

}