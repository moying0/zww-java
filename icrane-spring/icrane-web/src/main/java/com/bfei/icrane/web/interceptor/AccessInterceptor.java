package com.bfei.icrane.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bfei.icrane.backend.service.UserService;
import com.bfei.icrane.common.util.PermissionManager;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.models.User;
import com.bfei.icrane.web.utils.Const;
import com.bfei.icrane.web.utils.RequestUtil;
import com.bfei.icrane.web.utils.UserCookieUtil;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: 网页访问拦截器.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private UserService userService;
	//private static final String[] IGNORE_URL = {"/login", "/register", "/logout"};
	private static final String[] AUTH_REQUIRED_URL = {"/auth/", "/my/","/sys/"};
	
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        
    	if ("GET".equalsIgnoreCase(request.getMethod())) {
    		RequestUtil.saveRequest();
        }
    	String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		User user =  (User)request.getSession().getAttribute(Const.SESSION_USER);
		
		 // 判断用户是否登录，一般是都没登录的
        if(user == null){
        	// 取cookie值，这里还有其他网站的
        	Cookie[] cookies = request.getCookies();	
        	if(cookies!=null && cookies.length>0){
	  			  String cookieValue = null;
	  			  // 下面是找到本项目的cookie
	  			  for (int i = 0; i < cookies.length; i++) {
	  				  if(Const.COOKIEDOMAINNAME.equals(cookies[i].getName())){
	  					  cookieValue = cookies[i].getValue();
	  					  break;
	  				  }
	  			  }
	  			  // 如果cookieValue为空说明用户上次没有选择“记住下次登录”执行其他
	  			  if(cookieValue==null){
	  				  if (url.contains("login")){
	  					  return true;
	  				  }
	  				  request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		  	          return false;
	  			  }else{
	  				  // 先得到的CookieValue进行Base64解码
	  				  //String cookieValueAfterDecode = new String(base64.decode(cookieValue),"UTF-8");
	  				  String cookieValueAfterDecode = new String(Base64.decodeBase64(cookieValue),"UTF-8");
	  				  // 对解码后的值进行分拆,得到一个数组,如果数组长度不为3,就是非法登陆
	  				  String cookieValues[] = cookieValueAfterDecode.split(":");
	  				  if(cookieValues.length!=3){ 
	  					  request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	  		        	  return false;
	  				  }
	  				  // 判断是否在有效期内,过期就删除Cookie
	  				  long validTimeInCookie = new Long(cookieValues[1]);
	  				  if (validTimeInCookie < System.currentTimeMillis()) {
	  					  // 删除Cookie
	  					  UserCookieUtil.clearCookie(response); 
	  					  request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	  		        	  return false;
	  				  }
	  				  // 取出cookie中的用户名,并到数据库中检查这个用户名,
	  				  String userName = cookieValues[0];
	  				  User temp = userService.findUserByName(userName);
	  				  // 如果user返回不为空,就取出密码,使用用户名(userName)+密码+有效时间+ webSiteKey进行MD5加密。与前面设置的进行比较，看是否是同一个用户
	  				  if(temp!=null){
	  					  String md5ValueInCookie = cookieValues[2];
	  					  String md5ValueFromUser = StringUtils.EncoderByMd5(temp.getName() + ":" + temp.getPassword() + ":" + validTimeInCookie + ":" + Const.COOKIEDOMAINNAME);
	  					  // 将结果与Cookie中的MD5码相比较,如果相同,写入Session,自动登陆成功,并继续用户请求
	  					  if (md5ValueFromUser.equals(md5ValueInCookie)) {
	  						  request.getSession().setAttribute(Const.SESSION_USER, temp);
	  						  request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	  			        	  return false;
	  					  }
	  				  }
  			      }
  		     }else{
  		    	if (url.contains("login")){
				    return true;
			    }
  		    	request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
  	            return false;
  		    }
        }
    	/*// get uri and queryString
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
        }*/
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
