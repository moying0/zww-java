package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.core.dao.AccountDao;
import com.bfei.icrane.core.dao.MemberDao;
import com.bfei.icrane.core.dao.VipDao;
import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.Vip;
import com.bfei.icrane.core.service.AccountService;
import com.bfei.icrane.core.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SUN on 2018/1/10.
 */
@Service("VipService")
@Transactional
public class VipServiceImpl implements VipService {

    @Autowired
    private VipDao vipDao;

    @Override
    public Vip selectVipByGrowthValue(BigDecimal growthValue) {
        return vipDao.selectVipByGrowthValue(growthValue);
    }

    @Override
    public Vip selectVipByMemberId(Integer memberId) {
        return vipDao.selectVipByMemberId(memberId);
    }

    @Override
    public List<Vip> getAll() {
        return vipDao.getAll();
    }

    @Override
    public void lowerLevel(Account payingUser) {
        vipDao.lowerLevel();
    }

    @Override
    public Vip selectVipByLevel(int level) {
        return vipDao.selectVipByLevel(level);
    }

    @Override
    public Vip getNext(Integer memberId) {
        return vipDao.getNext(memberId);
    }

    @Override
    public Vip getMax() {
        return vipDao.getMax();
    }

}
