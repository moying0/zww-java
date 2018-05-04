package com.bfei.icrane.api.service;

import com.bfei.icrane.core.models.SystemPref;

import java.util.List;

/**
 * @author mwan Version: 1.0 Date: 2017/4/23 Description: 用户Service接口类.
 *         Copyright (c) 2017 mwan. All rights reserved.
 */
public interface AboutUsService {
	
	SystemPref selectByPrimaryKey(String code);

    List<SystemPref> selectAll();
}








