package com.bfei.icrane.backend.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfei.icrane.backend.service.UserService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.MemberDao;
import com.bfei.icrane.core.dao.UserDao;
import com.bfei.icrane.core.models.DollImage;
import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.models.User;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2017/9/16
 * Description: 用户Service接口实现类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private MemberDao memberDao;

	public List<User> listUsers(String hql) {
		// TODO Auto-generated method stub
		return userDao.getUserAll(0, 0);
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Timestamp nowdate = new Timestamp(date.getTime());
		user.setCreated_date(nowdate);
		user.setModified_date(nowdate);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Timestamp nowdate = new Timestamp(date.getTime());
		user.setModified_date(nowdate);
	}

	@Transactional
	public int findResultCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public User findUniqueById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public User findUserByName(String userName) {
		return userDao.getUserByName(userName);
	}
}
