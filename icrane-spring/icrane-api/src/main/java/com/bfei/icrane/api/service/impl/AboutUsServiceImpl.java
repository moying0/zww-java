package com.bfei.icrane.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.controller.AboutUsController;
import com.bfei.icrane.api.service.AboutUsService;
import com.bfei.icrane.core.dao.SystemPrefDao;
import com.bfei.icrane.core.models.SystemPref;

import java.util.List;

/**
 * 
 * @author lgq Version: 1.0 Date: 2017年9月19日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("AboutUsService")
public class AboutUsServiceImpl implements AboutUsService {
	private static final Logger logger = LoggerFactory.getLogger(AboutUsServiceImpl.class);
	@Autowired
	private SystemPrefDao systemPrefDao;
	
	@Override
	public SystemPref selectByPrimaryKey(String code) {
		// TODO Auto-generated method stub
		//logger.info("获取关于我们参数code:{}",code);
		SystemPref s = systemPrefDao.selectByPrimaryKey(code);
		//logger.info("服务器返回s:{}",s);
		return s;
	}

	@Override
	public List<SystemPref> selectAll() {
		return systemPrefDao.selectAll();
	}

}
