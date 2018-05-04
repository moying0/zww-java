package com.bfei.icrane.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.SystemPrefService;
import com.bfei.icrane.core.dao.SystemPrefDao;
import com.bfei.icrane.core.models.SystemPref;
/**
 * 系统参数服务
 * @author lcc
 *
 */
@Service("systemPrefService")
public class SystemPrefServiceImpl implements SystemPrefService {
	
	@Autowired
	private SystemPrefDao systemPrefDao;

	@Override
	public SystemPref selectByPrimaryKey(String code) {
		return systemPrefDao.selectByPrimaryKey(code);
	}

}
