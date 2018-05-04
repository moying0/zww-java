package com.bfei.icrane.core.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.Message;
/**
 * @author lgq
 * Version: 1.0
 * Date: 2017/9/21
 * Description: 用户Dao接口类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface MessageDao {

    public List<Message> getMessage(@Param("memberId") Integer memberId,@Param("offset") int offset, @Param("limit") int limit);
    
    public Integer updateMessageRead(Integer id);
    
    public Integer deleteByPrimaryKey(Integer id);
    
    public Integer deleteReadMessage(Integer id);
    
    public Message getMessageDetail(Integer id);
}
