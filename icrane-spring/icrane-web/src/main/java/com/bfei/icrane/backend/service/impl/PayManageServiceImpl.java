package com.bfei.icrane.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfei.icrane.backend.service.PayManageService;
import com.bfei.icrane.core.dao.ChargeRulesDao;
import com.bfei.icrane.core.models.ChargeRules;
import com.bfei.icrane.core.models.User;
import com.bfei.icrane.web.utils.Const;
@Service("PayManageService")
public class PayManageServiceImpl implements PayManageService {
	@Autowired
	private ChargeRulesDao chageRulesDao;
	@Override
	public List<ChargeRules> selectChargeRules() {
		return chageRulesDao.selectChargeRules();
	}
	@Transactional
	public int updateByPrimaryKeySelective(ChargeRules chargeRules,HttpServletRequest request) {
		chargeRules.setModifiedDate(new Date());
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			chargeRules.setModifiedBy(user.getId());
		}
		return chageRulesDao.updateByPrimaryKeySelective(chargeRules);
	}
	@Override
	public ChargeRules selectByPrimaryKey(Integer id) {
		return chageRulesDao.selectByPrimaryKey(id);
	}
	@Transactional
	public int insertSelective(ChargeRules chargeRules,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			chargeRules.setCreatedBy(user.getId());
		}
		chargeRules.setCreatedDate(new Date());
		return chageRulesDao.insertSelective(chargeRules);
	}
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return chageRulesDao.deleteByPrimaryKey(id);
	}
	
}
