package com.bfei.icrane.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfei.icrane.backend.service.UserService;
import com.bfei.icrane.core.models.User;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2017/4/22
 * Description: 统一注册登录管理.
 * Copyright (c) 2017 mwan. All rights reserved.
 */
@Controller
@RequestMapping(value="/sso")
public class SSOController {
	
	private static final Logger logger = LoggerFactory.getLogger(SSOController.class);
	
	@Autowired
	private UserService userService;

	//定位到登录页面
	@RequestMapping(value="/login")
	public String loginView(){
		
		User user = userService.findUniqueById(1);
		System.out.println(user.getName());
		return "login";
		
	}
	//定位到登录提醒页面
	@RequestMapping(value="/loginr")
	public String loginReminderView(){
		
		return "login-reminder";
		
	}
	//提交登录申请
	@RequestMapping(value="/login.submit")
	@ResponseBody
	public int loginSubmit(HttpServletRequest request, HttpSession session) throws Exception{
		
		//获取用户名密码
		String loginMobile = request.getParameter("loginMobile");
		String encryptPassword = request.getParameter("encryptPassword");
				
		try{
			return 0;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
	//提交登出申请
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpSession session) throws Exception{
		
		try {				
			session.removeAttribute("user");

			return "redirect:/";
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw e;
		}
	}
	//获取Session user的id
	@RequestMapping(value="/getsession.user")
	@ResponseBody
	public Object getSessionUser(HttpServletRequest request, HttpSession session) throws Exception{
		
		try{
			User sessionUser = (User)session.getAttribute("user");
			if(sessionUser!=null){
				return sessionUser;
			}else{
				return null;
			}
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
	//获取Session user的对象
	@RequestMapping(value="/getsession.userobj")
	@ResponseBody
	public Object getSessionUserObj(HttpServletRequest request, HttpSession session) throws Exception{
		
		try{
			User sessionUser = (User)session.getAttribute("user");
			if(sessionUser!=null){
				return sessionUser;
			}else{
				return null;
			}
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
}
