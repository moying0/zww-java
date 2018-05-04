package com.bfei.icrane.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.models.User;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2017/9/16
 * Description: 用户Dao接口类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface UserDao {

    /**
     * 通过ID查询单本图书
     * 
     * @param id
     * @return
     */
    User getUserById(int userId);

    /**
     * 查询所有图书
     * 
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<User> getUserAll(@Param("offset") int offset, @Param("limit") int limit);
    
    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);
}
