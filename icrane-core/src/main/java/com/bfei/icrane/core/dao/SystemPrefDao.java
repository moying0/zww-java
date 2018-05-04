package com.bfei.icrane.core.dao;

import java.util.List;

import com.bfei.icrane.core.models.SystemPref;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/26
 * Description: 系统参数表DAO层.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface SystemPrefDao {
    int deleteByPrimaryKey(String code);

    int insert(SystemPref record);

    int insertSelective(SystemPref record);

    SystemPref selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SystemPref record);

    int updateByPrimaryKey(SystemPref record);
    
    List<SystemPref> selectAll();

    List<SystemPref> selectChannel();
}