package com.bfei.icrane.core.dao;


import com.bfei.icrane.core.models.MessageLoging;

import java.util.List;

public interface MessageLogingDao {
    int deleteByPrimaryKey(Long id);

    int insert(MessageLoging record);

    MessageLoging selectByPrimaryKey(Long id);

    List<MessageLoging> selectAll();

    int updateByPrimaryKey(MessageLoging record);

//    int queryCount(MessageQueryObject qo);
//
//    List<MessageLoging> queryList(MessageQueryObject qo);

}