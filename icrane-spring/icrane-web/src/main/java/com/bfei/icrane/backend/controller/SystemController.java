package com.bfei.icrane.backend.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bfei.icrane.backend.service.UserService;
import com.bfei.icrane.core.models.User;
import com.bfei.icrane.web.utils.Const;
import com.bfei.icrane.web.utils.RequestUtil;
import com.bfei.icrane.web.utils.UserCookieUtil;
/**
 * @ClassName: SystemController 
 * @Description: TODO 
 * @author perry 
 * @date 2017年10月18日 上午9:14:53 
 * @version V1.0
 */
@Controller
public class SystemController {
	private final Logger logger = LoggerFactory.getLogger(SystemController.class);
	private static final String RANDOMCODE="RANDOMCODE";
	private static final String Y="Y";
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		logger.info("返回首页！");
		return "index";
	}
	
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response,
    		@RequestParam String loginname, @RequestParam String password, 
    		@RequestParam String code,@RequestParam String autologinch) throws Exception{
    	logger.info("登录后台传入参数：code={},loginname={},password={},autologinch={},randCode={}",code,loginname,password,autologinch,request.getSession().getAttribute(RANDOMCODE).toString().toLowerCase());
		if (code.toLowerCase().equals(request.getSession().getAttribute(RANDOMCODE).toString().toLowerCase())){
			User user = userService.findUserByName(loginname);
			if (user == null) {
				logger.info("登陆用户名不存在");  
	    		request.setAttribute("message", "用户名不存在，请重新登录");
	    		return "login"; 
			}else {
				if (user.getPassword().equals(password)) {
					 // 判断是否要添加到cookie中
					if(autologinch!=null && autologinch.equals(Y)){
						// 保存用户信息到cookie
						UserCookieUtil.saveCookie(user, response);
					}
					
					// 保存用信息到session
					request.getSession().setAttribute(Const.SESSION_USER, user);  
					//跳转至访问页面
	        		return "redirect:" + RequestUtil.retrieveSavedRequest();
					
				}else {
					logger.info("登陆密码错误");  
	        		request.setAttribute("message", "用户名密码错误，请重新登录");
	        		return "login"; 
				}
			}
		}else {
			request.setAttribute("message", "验证码错误，请重新输入");
    		return "login"; 
		}
    }
    
    @RequestMapping(value="/logout")
	public String logout(HttpSession session,HttpServletResponse response){
		session.removeAttribute(Const.SESSION_USER);
		UserCookieUtil.clearCookie(response);
		return "redirect:/";
	}
    
}
