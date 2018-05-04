package com.bfei.icrane.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.PrefSetService;
import com.bfei.icrane.core.dao.PrefSetDao;
import com.bfei.icrane.core.dao.SystemPrefDao;
import com.bfei.icrane.core.models.PrefSet;
import com.bfei.icrane.core.models.SystemPref;

/**
 * 
 * @author lgq Version: 1.0 Date: 2017年9月19日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("PrefSetService")
public class PrefSetServiceImpl implements PrefSetService {
	private static final Logger logger = LoggerFactory.getLogger(PrefSetServiceImpl.class);
	@Autowired
	private PrefSetDao prefSetDao;
	
	@Autowired
	private SystemPrefDao systemPrefDao;

	public Integer updateByPrimaryKeySelective(PrefSet prefSet) {
		logger.info("updateByPrimaryKeySelective 参数prefSet:{}",prefSet);
		return prefSetDao.updateByPrimaryKeySelective(prefSet);
	}
	
	@Override
	public SystemPref selectByPrimaryKey(String code) {
		return systemPrefDao.selectByPrimaryKey(code);
	}

}
