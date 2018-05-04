package com.bfei.icrane.core.service;

import com.bfei.icrane.core.models.Account;

/**
 * Created by SUN on 2018/3/2.
 * 用户账户相关服务类接口
 */
public interface RiskManagementService {

    int register(int memberId, String imei, String ipAdrress);

    boolean isOneIMEI(Integer memberId, Integer memberId2);

    int selectIMEICount(String imei);
}