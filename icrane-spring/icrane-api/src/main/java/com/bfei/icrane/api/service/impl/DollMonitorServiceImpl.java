package com.bfei.icrane.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfei.icrane.api.service.DollMonitorService;
import com.bfei.icrane.common.util.TimeUtil;
import com.bfei.icrane.core.dao.DollDao;
import com.bfei.icrane.core.dao.DollMonitorDao;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollMonitor;

/**
 * @author mwan 
 * Version: 1.0 
 * Date: 2017/10/26 
 * Description: 娃娃机报警监控Service接口实现类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("DollMonitorService")
public class DollMonitorServiceImpl implements DollMonitorService {
	
	@Autowired
	private DollMonitorDao dollMonitorDao;
	@Autowired
	private DollDao dollDao;
	
	private static final int ALERT_THRESHOLD = 20;

	@Override
	@Transactional
	public boolean gameAlert(int memberId, int dollId) {
		// TODO Auto-generated method stub
		DollMonitor dollMonitor = dollMonitorDao.selectByDollIdType(dollId,"游戏异常");
		if(dollMonitor == null) {
			dollMonitor = new DollMonitor();
			dollMonitor.setDollid(dollId);
			dollMonitor.setAlertNumber(1);
			dollMonitor.setAlertType("游戏异常");
			dollMonitor.setDescription("游戏连接过程异常报警");
			dollMonitor.setCreatedDate(TimeUtil.getTime());
			dollMonitor.setCreatedBy(memberId);
			dollMonitor.setModifiedDate(TimeUtil.getTime());
			dollMonitor.setModifiedBy(memberId);
			dollMonitorDao.insert(dollMonitor);
		}else {
			dollMonitor.setAlertNumber(dollMonitor.getAlertNumber() + 1);
			dollMonitor.setModifiedDate(TimeUtil.getTime());
			dollMonitor.setModifiedBy(memberId);
			dollMonitorDao.updateByPrimaryKeySelective(dollMonitor);
		}
		//如果报警次数达到阈值，则自动修改娃娃机状态为“维修中”
		/*if(dollMonitor.getAlertNumber() >= ALERT_THRESHOLD) {
			Doll doll = new Doll();
			doll.setId(dollId);
			doll.setMachineStatus("维修中");
			doll.setModifiedDate(TimeUtil.getTime());
			dollDao.updateByPrimaryKeySelective(doll);
			
			dollMonitor.setAlertNumber(0);
			dollMonitor.setCreatedDate(TimeUtil.getTime());
			dollMonitor.setCreatedBy(memberId);
			dollMonitor.setModifiedDate(TimeUtil.getTime());
			dollMonitor.setModifiedBy(memberId);
			dollMonitorDao.updateByPrimaryKeySelective(dollMonitor);
		}*/
		
		return true;
	}

}
