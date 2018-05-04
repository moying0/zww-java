package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.RiskManagement;

/**
 * Created by SUN on 2018/3/2.
 */
public interface RiskManagementDao {

    RiskManagement selectByMemberId(int memberId);

    int updateById(RiskManagement riskManagement);

    void init(int memberId);

    int selectIMEICount(String imei);
}