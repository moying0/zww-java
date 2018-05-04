package com.bfei.icrane.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfei.icrane.core.service.ValidateTokenService;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/28
 * Description: 验证token控制层，给内部服务使用.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Controller
@RequestMapping(value = "/")
@CrossOrigin
public class ValidateTokenController {

	private static final Logger logger = LoggerFactory.getLogger(ValidateTokenController.class);
	@Autowired
	private ValidateTokenService validateTokenService;
	
	//验证token
	@RequestMapping(value = "/validateToken", method = RequestMethod.POST)
	@ResponseBody
	public boolean validateToken(String token) throws Exception {
		logger.info("验证token="+token);
		try {
			return validateTokenService.validataToken(token);
		} catch (Exception e) {
			logger.error("调用验证token接口时出错",e);
			throw e;
		}
	}
	
	//验证token
	@RequestMapping(value = "/validateTokenNew", method = RequestMethod.POST)
	@ResponseBody
	public boolean validateTokenNew(String token,Integer memberId) throws Exception {
		logger.info("验证token="+token+",memberId="+memberId);
		try {
			return validateTokenService.validataToken(token,memberId);
		} catch (Exception e) {
			logger.error("调用验证token接口时出错",e);
			throw e;
		}
	}
}




