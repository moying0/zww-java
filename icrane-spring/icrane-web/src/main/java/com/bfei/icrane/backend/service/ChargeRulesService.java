package com.bfei.icrane.backend.service;

import com.bfei.icrane.core.models.ChargeRules;

import java.util.List;

/**
 * @author lgq Version: 1.0 Date: 2017/9/23 Description: 用户Service接口类.
 *         Copyright (c) 2017 mwan. All rights reserved.
 */
public interface ChargeRulesService {
	
	/**
	 * 获取消息
	 */
	public List<ChargeRules> selectChargeRules();
	public ChargeRules getChargeRulesByWhere(ChargeRules chargeRules);
	public ChargeRules selectByPrimaryKey(Integer id);

	
}








