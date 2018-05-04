package com.bfei.icrane.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bfei.icrane.api.service.MessageService;
import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.core.models.Message;
import com.bfei.icrane.core.service.ValidateTokenService;

@Controller
@RequestMapping(value = "/message")
@CrossOrigin
public class MessageController {
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private ValidateTokenService validateTokenService;

	// 获取用户消息
	/**
	 * @param mobile
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMessage(Integer memberId, Integer pageNo,Integer pageSize ,String token) throws Exception {
		logger.info("获取用户消息接口参数memberId="+memberId+","+"pageNo="+pageNo+","+"pageSize="+pageSize+","+"token="+token);
		Map<String, Object> resultMap = new HashedMap<String, Object>();
		try {
			// 验证token有效性
			if (token == null || "".equals(token) || !validateTokenService.validataToken(token,memberId)) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_UNAUTHORIZED_CODE);
				resultMap.put("message", Enviroment.RETURN_UNAUTHORIZED_MESSAGE);

				return resultMap;
			}
			if(pageNo==null||pageNo==0) {
			pageNo = 1;
			}
			if(pageSize==null) {
				pageSize = 10;
			}
			
			int offset = pageSize * (pageNo - 1);
			List<Message> getMessage = messageService.getMessage(memberId, offset, pageSize);
//			List<Map<String, Object>> dh = new ArrayList<Map<String, Object>>();
//			for (Message message : getMessage) {
//				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("sendDate", message.getSendDate());
//				map.put("msgBody", message.getMsgBody());
//				map.put("msgTitle", message.getMsgTitle());
//				map.put("readFlg", message.getReadFlg());
//				dh.add(map);
//			}
			if (getMessage != null) {
				resultMap.put("resultData", getMessage);
				resultMap.put("success", Enviroment.RETURN_SUCCESS);
				resultMap.put("statusCode", Enviroment.RETURN_SUCCESS_CODE);
				resultMap.put("message", Enviroment.RETURN_SUCCESS_MESSAGE);
			} else if (getMessage == null) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_FAILE_CODE);
				resultMap.put("message", Enviroment.RETURN_FAILE_MESSAGE);
			}
			logger.info("获取用户消息resultMap="+resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("获取用户消息出错", e);
			throw e;
		}
	}

	// 消息已读
	/**
	 * @param mobile
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateMessageRead", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateMessageRead(Integer id, String token) throws Exception {
		logger.info("消息已读接口参数id="+id+","+"token="+token);
		Map<String, Object> resultMap = new HashedMap<String, Object>();
		try {
			// 验证token有效性
			if (token == null || "".equals(token) || !validateTokenService.validataToken(token)) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_UNAUTHORIZED_CODE);
				resultMap.put("message", Enviroment.RETURN_UNAUTHORIZED_MESSAGE);

				return resultMap;
			}
			Integer messageRead = messageService.updateMessageRead(id);
			logger.info("消息已读messageRead="+messageRead);
			if (messageRead == 1) {
				resultMap.put("success", Enviroment.RETURN_SUCCESS);
				resultMap.put("statusCode", Enviroment.RETURN_SUCCESS_CODE);
				resultMap.put("message", Enviroment.RETURN_SUCCESS_MESSAGE);
			} else {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_FAILE_CODE);
				resultMap.put("message", Enviroment.RETURN_FAILE_MESSAGE);
			}
			logger.info("消息已读resultMap="+resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("消息已读出错", e);
			throw e;
		}
	}

	// 消息删除
	/**
	 * @param mobile
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteMessage(String ids, String token) throws Exception {
		logger.info("消息删除接口参数ids="+ids+","+"token="+token);
		Map<String, Object> resultMap = new HashedMap<String, Object>();
		try {
			// 验证token有效性
			if (token == null || "".equals(token) || !validateTokenService.validataToken(token)) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_UNAUTHORIZED_CODE);
				resultMap.put("message", Enviroment.RETURN_UNAUTHORIZED_MESSAGE);

				return resultMap;
			}
			Integer result = 0;
			String id[] = ids.split(",");
			for (int i = 0; i < id.length; i++) {
				result = messageService.deleteMessage(Integer.parseInt(id[i]));
			}

			if (result != 0) {
				resultMap.put("success", Enviroment.RETURN_SUCCESS);
				resultMap.put("statusCode", Enviroment.RETURN_SUCCESS_CODE);
				resultMap.put("message", Enviroment.RETURN_SUCCESS_MESSAGE);
			} else {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_FAILE_CODE);
				resultMap.put("message", Enviroment.RETURN_FAILE_MESSAGE);
			}
			logger.info("消息删除resultMap="+resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("消息删除出错", e);
			throw e;
		}
	}

	// 消息快速删除
	/**
	 * @param mobile
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/quickDeleteMessage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> quickDeleteMessage(Integer memberId, String token) throws Exception {
		logger.info("消息快速删除接口参数memberId="+memberId+","+"token="+token);
		Map<String, Object> resultMap = new HashedMap<String, Object>();
		try {
			// 验证token有效性
			if (token == null || "".equals(token) || !validateTokenService.validataToken(token,memberId)) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_UNAUTHORIZED_CODE);
				resultMap.put("message", Enviroment.RETURN_UNAUTHORIZED_MESSAGE);

				return resultMap;
			}
			Integer result = messageService.deleteReadMessage(memberId);
			logger.info("快速删除result="+result);
			if (result != 0) {
				resultMap.put("success", Enviroment.RETURN_SUCCESS);
				resultMap.put("statusCode", Enviroment.RETURN_SUCCESS_CODE);
				resultMap.put("message", Enviroment.RETURN_SUCCESS_MESSAGE);
			} else {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_FAILE_CODE);
				resultMap.put("message", Enviroment.RETURN_FAILE_MESSAGE);
			}
			logger.info("快速删除resultMap="+resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("消息快速删除出错", e);
			throw e;
		}
	}

	// 获取消息详细
	/**
	 * @param mobile
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMessageDetail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMessageDetail(Integer id, String token) throws Exception {
		logger.info("消息快速删除接口参数id="+id+","+"token="+token);
		Map<String, Object> resultMap = new HashedMap<String, Object>();
		try {
			// 验证token有效性
			if (token == null || "".equals(token) || !validateTokenService.validataToken(token)) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_UNAUTHORIZED_CODE);
				resultMap.put("message", Enviroment.RETURN_UNAUTHORIZED_MESSAGE);

				return resultMap;
			}
			Message message = messageService.getMessageDetail(id);
//			logger.info("获取消息详细message="+message);
			if (message != null) {
				resultMap.put("resultData", message);
				resultMap.put("success", Enviroment.RETURN_SUCCESS);
				resultMap.put("statusCode", Enviroment.RETURN_SUCCESS_CODE);
				resultMap.put("message", Enviroment.RETURN_SUCCESS_MESSAGE);
			} else {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_FAILE_CODE);
				resultMap.put("message", Enviroment.RETURN_FAILE_MESSAGE);
			}
			logger.info("获取消息详细resultMap="+resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息详细出错", e);
			throw e;
		}
	}
}
