package com.bfei.icrane.core.service;

import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.Vip;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SUN on 2018/3/2.
 * 用户vip相关服务类接口
 */
public interface VipService {

    Vip selectVipByGrowthValue(BigDecimal growthValue);

    Vip selectVipByMemberId(Integer memberId);

    List<Vip> getAll();

    void lowerLevel(Account payingUser);

    Vip selectVipByLevel(int i);

    Vip getNext(Integer memberId);

    Vip getMax();

}