package com.bfei.icrane.backend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.core.models.ChargeRules;

public interface PayManageService {
	public List<ChargeRules> selectChargeRules();
	public int updateByPrimaryKeySelective(ChargeRules chargeRules,HttpServletRequest request);
	public ChargeRules selectByPrimaryKey(Integer id);
	public int insertSelective(ChargeRules chargeRules,HttpServletRequest request);
	public int deleteByPrimaryKey(Integer id);
}
