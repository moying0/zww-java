package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.ChargeRulesService;
import com.bfei.icrane.core.dao.ChargeRulesDao;
import com.bfei.icrane.core.models.ChargeRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 
 * @author lgq Version: 1.0 Date: 2017年9月19日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("ChargeRulesService")
public class ChargeRulesServiceImpl implements ChargeRulesService {
	private static final Logger logger = LoggerFactory.getLogger(ChargeRulesServiceImpl.class);
	@Autowired
	private ChargeRulesDao chargeRulesDao;

	@Override
	public List<ChargeRules> selectChargeRules() {
		// TODO Auto-generated method stub
		List<ChargeRules> cr = chargeRulesDao.selectChargeRules();
		//logger.info("返回 cr:{}",cr);
		return cr;
	}

	@Override
	public ChargeRules getChargeRulesByWhere(ChargeRules chargeRules) {
		ChargeRules crs = chargeRulesDao.selectByWhere(chargeRules);
		//logger.info("返回 cr:{}",crs);
		return crs;
	}

	@Override
	public ChargeRules selectByPrimaryKey(Integer id) {
		ChargeRules crs = chargeRulesDao.selectByPrimaryKey(id);
		//logger.info("返回 cr:{}",crs);
		return crs;
	}
}
