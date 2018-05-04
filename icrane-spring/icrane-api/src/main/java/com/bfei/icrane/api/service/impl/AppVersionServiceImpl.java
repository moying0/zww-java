package com.bfei.icrane.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.AppVersionService;
import com.bfei.icrane.core.dao.TAppVersionDao;
import com.bfei.icrane.core.models.TAppVersion;

/**
 * 
 * @author lgq Version: 1.0 Date: 2017年9月19日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("AppVersionService")
public class AppVersionServiceImpl implements AppVersionService {
	private static final Logger logger = LoggerFactory.getLogger(AppVersionServiceImpl.class);
	@Autowired
	private TAppVersionDao appVersionDao;
	@Override
	public TAppVersion selectByPrimaryKey(String appKey) {
		// TODO Auto-generated method stub
		logger.info("获取版本号参数appKey{}",appKey);
		return appVersionDao.selectByPrimaryKey(appKey);
	}
	@Override
	public TAppVersion selectVersionHide(String appKey, String version) {
		// TODO Auto-generated method stub
		return appVersionDao.selectVersionHide(appKey, version);
	}
	

}
