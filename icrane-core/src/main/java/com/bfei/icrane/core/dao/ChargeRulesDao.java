package com.bfei.icrane.core.dao;

import java.util.List;

import com.bfei.icrane.core.models.ChargeRules;

/**
 * @author lgq Version: 1.0 Date: 2017/10/11 Description: 用户Dao接口类. Copyright (c)
 *         2017 伴飞网络. All rights reserved.
 */
public interface ChargeRulesDao {

    public List<ChargeRules> getChargeRules();

    int updateByPrimaryKeySelective(ChargeRules chargeRules);

    ChargeRules selectByPrimaryKey(Integer id);

    ChargeRules selectByWhere(ChargeRules chargeRules);

    int insertSelective(ChargeRules chargeRules);

    int deleteByPrimaryKey(Integer id);

    //后台
    public List<ChargeRules> selectChargeRules();

    List<ChargeRules> getChargeRulesByType(Integer rulesType);
}
