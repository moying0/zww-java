package com.bfei.icrane.common.util;

import com.bfei.icrane.core.models.User;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: 权限管理类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class PermissionManager {
	//判断用户是否具备角色权限
	public static boolean hasPermission(User user,String roleCode) {
        
//		Set<Role> roleList = user.getRole();
//		if(roleList == null){
//			return false;
//		}
//		Iterator<Role> iter = roleList.iterator();
//		Role role = new Role();
//		while(iter.hasNext())  
//        {  
//			role = iter.next();
//			if(role.getRole_code().equals(roleCode)){
//				return true;
//			}		              
//        }
		return false;
	}
	//根据url关键字判断相应的角色权限
	public static boolean hasPermissionByUrl(User user,String url) {
        
		if(url.contains("/sys/adm")){
			return hasPermission(user, "admin");
		}else if(url.contains("/my/course")){
			return (hasPermission(user, "author")||hasPermission(user, "admin"));
		}else{
			return true;
		}
	}
}