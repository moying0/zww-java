package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.dao.RiskManagementDao;
import com.bfei.icrane.core.dao.MemberDao;
import com.bfei.icrane.core.models.RiskManagement;
import com.bfei.icrane.core.service.RiskManagementService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SUN on 2018/3/2.
 */
@Service("RiskManagementService")
@Transactional
public class RiskManagementServiceImpl implements RiskManagementService {

    @Autowired
    private RiskManagementDao riskManagementDao;
    @Autowired
    private MemberDao memberDao;

    @Override
    public int register(int memberId, String imei, String ipAdrress) {
        try {
            //获取用户风控信息
            RiskManagement baseRiskManagement = riskManagementDao.selectByMemberId(memberId);
            if (baseRiskManagement == null) {
                //创建风控信息
                riskManagementDao.init(memberId);
                baseRiskManagement = riskManagementDao.selectByMemberId(memberId);
            }
            Set<String> imeis = new HashSet<>();
            imeis.add(baseRiskManagement.getIMEI1());
            imeis.add(baseRiskManagement.getIMEI2());
            imeis.add(baseRiskManagement.getIMEI3());
            Set<String> ips = new HashSet<>();
            ips.add(baseRiskManagement.getIP1());
            ips.add(baseRiskManagement.getIP2());
            ips.add(baseRiskManagement.getIP3());
            int result = 1;
            RiskManagement riskManagement = new RiskManagement();
            riskManagement.setId(baseRiskManagement.getId());
            if (StringUtils.isNotEmpty(imei) && !imeis.contains(imei)) {
                result++;
                riskManagement.setIMEI1(imei);
                String oldImei1 = baseRiskManagement.getIMEI1();
                if (StringUtils.isNotEmpty(oldImei1)) {
                    riskManagement.setIMEI2(oldImei1);
                    String oldImei2 = baseRiskManagement.getIMEI2();
                    if (StringUtils.isNotEmpty(oldImei2)) {
                        riskManagement.setIMEI3(oldImei2);
                    }
                }
            }
            if (StringUtils.isNotEmpty(ipAdrress) && !ips.contains(ipAdrress)) {
                result++;
                riskManagement.setIP1(ipAdrress);
                String oldIp1 = baseRiskManagement.getIP1();
                if (StringUtils.isNotEmpty(oldIp1)) {
                    riskManagement.setIP2(oldIp1);
                    String oldIp2 = baseRiskManagement.getIP2();
                    if (StringUtils.isNotEmpty(oldIp2)) {
                        riskManagement.setIP3(oldIp2);
                    }
                }
            }
            //保存风控信息
            if (result > 1) {
                result = riskManagementDao.updateById(riskManagement);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean isOneIMEI(Integer memberId, Integer memberId2) {
        if (memberId.equals(memberId2)) {
            return true;
        }
        RiskManagement byMemberId = riskManagementDao.selectByMemberId(memberId);
        if (byMemberId == null) {
            return false;
        }
        RiskManagement byMemberId2 = riskManagementDao.selectByMemberId(memberId2);
        if (byMemberId2 == null) {
            return false;
        }
        List<String> list = new ArrayList<>();
        if (StringUtils.isNotEmpty(byMemberId.getIMEI1()) && !"IMEI".equals(byMemberId.getIMEI1())) {
            list.add(byMemberId.getIMEI1());
        }
        if (StringUtils.isNotEmpty(byMemberId.getIMEI2()) && !"IMEI".equals(byMemberId.getIMEI2())) {
            list.add(byMemberId.getIMEI2());
        }
        if (StringUtils.isNotEmpty(byMemberId.getIMEI3()) && !"IMEI".equals(byMemberId.getIMEI3())) {
            list.add(byMemberId.getIMEI3());
        }
        List<String> list2 = new ArrayList<>();
        if (StringUtils.isNotEmpty(byMemberId2.getIMEI1()) && !"IMEI".equals(byMemberId2.getIMEI1())) {
            list2.add(byMemberId2.getIMEI1());
        }
        if (StringUtils.isNotEmpty(byMemberId2.getIMEI2()) && !"IMEI".equals(byMemberId2.getIMEI2())) {
            list2.add(byMemberId2.getIMEI2());
        }
        if (StringUtils.isNotEmpty(byMemberId2.getIMEI3()) && !"IMEI".equals(byMemberId2.getIMEI3())) {
            list2.add(byMemberId2.getIMEI3());
        }
        if (list.size() == 0 || list2.size() == 0) {
            return false;
        }
        for (String s : list2) {
            if (list.contains(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int selectIMEICount(String imei) {
        return riskManagementDao.selectIMEICount(imei);
    }
}
