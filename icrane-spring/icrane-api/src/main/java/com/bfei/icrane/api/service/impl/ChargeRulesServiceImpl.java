package com.bfei.icrane.api.service.impl;

import java.math.BigDecimal;
import java.util.*;

import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.Vip;
import com.bfei.icrane.core.service.AccountService;
import com.bfei.icrane.core.service.VipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.ChargeRulesService;
import com.bfei.icrane.core.dao.ChargeRulesDao;
import com.bfei.icrane.core.models.ChargeRules;


/**
 * @author lgq Version: 1.0 Date: 2017年9月19日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("ChargeRulesService")
public class ChargeRulesServiceImpl implements ChargeRulesService {
    private static final Logger logger = LoggerFactory.getLogger(ChargeRulesServiceImpl.class);
    @Autowired
    private ChargeRulesDao chargeRulesDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private VipService vipService;

    @Override
    public List<ChargeRules> getChargeRules() {
        // TODO Auto-generated method stub
        List<ChargeRules> cr = chargeRulesDao.getChargeRules();
        //logger.info("返回 cr:{}",cr);
        return cr;
    }

    @Override
    public List<ChargeRules> getChargeRulesByType(Integer rulesType) {
        if (rulesType == null) {
            return getChargeRules();
        } else {
            return chargeRulesDao.getChargeRulesByType(rulesType);
        }
    }

    @Override
    public Map getChargeRulesBymemberId(Integer memberId) {
        HashMap<String, Object> map = new HashMap<>();
        Set firstCharge = new HashSet();
        Set weeksMonthly = new HashSet();
        Set superTicket = new HashSet();
        Set coins = new HashSet();
        Set mixture = new HashSet();
        Set nextDiscount = new HashSet();
        map.put("firstCharge", firstCharge);
        map.put("weeksMonthly", weeksMonthly);
        map.put("superTicket", superTicket);
        map.put("coins", coins);
        map.put("mixture", mixture);
        if (vipService.getNext(memberId) != null) {
            map.put("nextDiscount", vipService.getNext(memberId).getDiscount());
        } else {
            map.put("nextDiscount", vipService.getMax().getDiscount());
        }
        List<ChargeRules> chargeRules = getChargeRules();
        for (ChargeRules chargeRule : chargeRules) {
            Integer chargeType = chargeRule.getChargeType();
            if (chargeType == 0) {
                if (chargeRule.getCoinsCharge() + chargeRule.getCoinsCharge() == 0) {
                    superTicket.add(chargeRule);
                } else if (chargeRule.getSuperTicketCharge() + chargeRule.getSuperTicketOffer() == 0) {
                    coins.add(chargeRule);
                } else {
                    mixture.add(chargeRule);
                }
            } else if (chargeType == 1) {

            } else if (chargeType == 2 || chargeType == 3) {
                weeksMonthly.add(chargeRule);
            } else if (chargeType == 4 && !accountService.select(memberId).getCoinFirstCharge()) {
                firstCharge.add(chargeRule);
            }
        }
        List<Vip> allVip = vipService.getAll();
        Account account = accountService.selectById(memberId);
        Vip basevip = account.getVip();
        map.put("next", -1);
        for (Vip vip : allVip) {
            if (vip.getLevel() == basevip.getLevel() + 1) {
                BigDecimal nextGrowthValue = allVip.get(basevip.getLevel() + 1).getLeastAllowed();
                map.put("next", nextGrowthValue.subtract(account.getGrowthValue()));
            }
        }
        return map;
    }


}
