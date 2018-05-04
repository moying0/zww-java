package com.bfei.icrane.weixin.service.impl;


import com.bfei.icrane.core.dao.MessageLogingDao;
import com.bfei.icrane.core.models.MessageLoging;
import com.bfei.icrane.weixin.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WIN on 2017/11/2.
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageLogingDao mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(MessageLoging record) {
        return mapper.insert(record);
    }

    @Override
    public MessageLoging selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<MessageLoging> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(MessageLoging record) {
        return 0;
    }

   /* @Override
    public PageResult queryList(MessageQueryObject qo) {
        int count = mapper.queryCount(qo);
        if (count==0){
            return new PageResult(count, Collections.emptyList());
        }
        return new PageResult(count,mapper.queryList(qo));
    }*/
}
