package com.bfei.icrane.weixin.service;


import com.bfei.icrane.core.models.MessageLoging;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface IMessageService {

    int deleteByPrimaryKey(Long id);

    int insert(MessageLoging record);

    MessageLoging selectByPrimaryKey(Long id);

    List<MessageLoging> selectAll();

    int updateByPrimaryKey(MessageLoging record);

    //PageResult queryList(MessageQueryObject qo);
}
