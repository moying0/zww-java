package com.bfei.icrane.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.MessageService;
import com.bfei.icrane.core.dao.MessageDao;
import com.bfei.icrane.core.models.Message;

/**
 * 
 * @author lgq Version: 1.0 Date: 2017年9月19日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("MessageService")
public class MessageServiceImpl implements MessageService {
	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> getMessage(Integer memberId,int offset, int limit) {
		// TODO Auto-generated method stub
		logger.info("getMessage 参数memberId:{},offset:{},limit:{}",memberId,offset,limit);
		return messageDao.getMessage(memberId, offset, limit);
	}

	@Override
	public Integer updateMessageRead(Integer id) {
		// TODO Auto-generated method stub
		logger.info("updateMessageRead 参数id:{}",id);
		return messageDao.updateMessageRead(id);
	}

	@Override
	public Integer deleteMessage(Integer id) {
		// TODO Auto-generated method stub
		logger.info("deleteMessage 参数id:{}",id);
		return messageDao.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteReadMessage(Integer memberId) {
		// TODO Auto-generated method stub
		logger.info("deleteReadMessage 参数memberId:{}",memberId);
		return messageDao.deleteReadMessage(memberId);
	}

	@Override
	public Message getMessageDetail(Integer id) {
		// TODO Auto-generated method stub
		logger.info("getMessageDetail 参数id:{}",id);
		return messageDao.getMessageDetail(id);
	}

}
