package com.bfei.icrane.backend.service;

import java.util.List;
import com.bfei.icrane.core.models.User;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2017/4/23
 * Description: 用户Service接口类.
 * Copyright (c) 2017 mwan. All rights reserved.
 */
public interface UserService {

	/**
     * 查询用户对象列表
     * @param 查询语句hql
     */
    public List<User> listUsers(String hql);
	/**
     * 保存用户对象
     * @param entity 用户对象
     */
    public void save(User user);
    /**
     * 更新实体对象
     * @param 用户对象
     */
    public void update(User user);
    /**
     * 查询特定记录的数量
     * @param 查询语句hql
     */
    public int findResultCount(String hql);
    /**
     * 查询特定用户对象根据id
     * @param 查询语句hql
     */
	public User findUniqueById(int id);
	/**
	 * 根据用户名查询用户
	 */
	public User findUserByName(String userName);
	
}
