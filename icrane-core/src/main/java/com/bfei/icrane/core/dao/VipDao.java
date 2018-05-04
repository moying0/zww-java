package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.Vip;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SUN on 2018/3/27.
 */
public interface VipDao {

    /**
     * 根据成长值查询会员
     *
     * @param growthValue
     * @return
     */
    Vip selectVipByGrowthValue(BigDecimal growthValue);

    Vip selectVipByMemberId(Integer memberId);

    List<Vip> getAll();

    void lowerLevel();

    Vip selectVipByLevel(int level);

    Vip getNext(Integer memberId);

    Vip getMax();

}