package com.bfei.icrane.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfei.icrane.backend.service.PrefSetService;
import com.bfei.icrane.core.dao.SystemPrefDao;
import com.bfei.icrane.core.models.SystemPref;
import com.bfei.icrane.core.models.User;
import com.bfei.icrane.web.utils.Const;
@Service("PrefSetService")
public class PrefSetServiceImpl implements PrefSetService {
	@Autowired
	private SystemPrefDao systemPrefDao;
	@Override
	public List<SystemPref> selectAll() {
		return systemPrefDao.selectAll();
	}
	@Override
	public SystemPref selectByPrimaryKey(String code) {
		return systemPrefDao.selectByPrimaryKey(code);
	}
	@Transactional
	public int updateByPrimaryKeySelective(SystemPref record,HttpServletRequest request) {
		record.setModifiedDate(new Date());
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			record.setModifiedBy(user.getId());
		}
		return systemPrefDao.updateByPrimaryKeySelective(record);
	}
	@Transactional
	public int insertSelective(SystemPref record,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			record.setModifiedBy(user.getId());
		}
		record.setModifiedDate(new Date());
		return systemPrefDao.insertSelective(record);
	}
	@Transactional
	public int deleteByPrimaryKey(String code) {
		return systemPrefDao.deleteByPrimaryKey(code);
	}

}
