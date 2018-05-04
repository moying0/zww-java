package com.bfei.icrane.api.service;

import com.bfei.icrane.core.models.SystemPref;

public interface SystemPrefService {
	//获取系统参数服务
	SystemPref selectByPrimaryKey(String code);
}
