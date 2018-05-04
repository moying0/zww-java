package com.bfei.icrane.api.service;

import java.util.List;

import com.bfei.icrane.core.models.Message;

/**
 * @author lgq Version: 1.0 Date: 2017/9/23 Description: 用户Service接口类.
 *         Copyright (c) 2017 mwan. All rights reserved.
 */
public interface MessageService {
	
	/**
	 * 获取消息
	 */
	public List<Message> getMessage(Integer memberId,int offset, int limit);
	
	/**
	 * 消息已读
	 * @param id
	 * @return
	 */
	public Integer updateMessageRead(Integer id);
	
	/**
	 * 消息删除
	 * @param id
	 * @return
	 */
	public Integer deleteMessage(Integer id);
	
	/**
	 * 删除已读
	 * @param memberId
	 * @return
	 */
	public Integer deleteReadMessage(Integer memberId);
	
	public Message getMessageDetail(Integer id);
	
	
}








