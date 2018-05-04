package com.bfei.icrane.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bfei.icrane.common.util.PermissionManager;
import com.bfei.icrane.core.models.User;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: 网页访问拦截器.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {
	
	//private static final String[] IGNORE_URL = {"/login", "/register", "/logout"};
	private static final String[] AUTH_REQUIRED_URL = {"/auth/", "/my/","/sys/"};
	
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        
    	// get uri and queryString
        String path = request.getRequestURI();
        String queryString = request.getQueryString();
        String projectName = request.getServletContext().getContextPath();
        
    	boolean login_require_flg = false;
        String url = request.getRequestURL().toString();
        //只拦截上面定义的路径
        for (String str : AUTH_REQUIRED_URL) {
            if (url.contains(str)) {
            	login_require_flg = true;
                break;
            }
        }
        if (login_require_flg) {
            User user = (User)request.getSession().getAttribute("user");
            if (user != null){
            	login_require_flg = false;
            	if(!PermissionManager.hasPermissionByUrl(user, url)){
            		response.sendRedirect(projectName+"/other/not.allow");
            		return false;
            	}
            }else{
                // do redirect
            	if (queryString == null || "".equals(queryString)) {
            		response.sendRedirect(projectName+"/sso/loginr?redirect="+path);
            	}else{
            		response.sendRedirect(projectName+"/sso/loginr?redirect="+path+"?"+queryString);
            	}
            	
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
