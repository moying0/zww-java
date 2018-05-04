package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.ServiceRequest;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/26
 * Description: 工单（问题反馈和求助）DAO层.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface ServiceRequestDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceRequest record);

    int insertSelective(ServiceRequest record);

    ServiceRequest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceRequest record);

    int updateByPrimaryKey(ServiceRequest record);
}