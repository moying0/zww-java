package com.bfei.icrane.common.util;

import java.io.File;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: 获取服务路径相关信息.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class ServerHelper {

	/** 
	 * Gets the root path of server. 
	 * 
	 * @return the root path 
	 */  
	public static String getRootPath() {  
	    String classPath = Thread.currentThread().getContextClassLoader()  
	            .getResource("").getPath();  
	    String rootPath = "";  
	  
	    /** For Windows */  
	    if ("\\".equals(File.separator)) {  
	        String path = classPath.substring(1,  
	                classPath.indexOf("/WEB-INF/classes"));  
	        rootPath = path.substring(0, path.lastIndexOf("/"));  
	        rootPath = rootPath.replace("/", "\\");  
	    }  
	  
	    /** For Linux */  
	    if ("/".equals(File.separator)) {  
	        String path = classPath.substring(0,  
	                classPath.indexOf("/WEB-INF/classes"));  
	        rootPath = path.substring(0, path.lastIndexOf("/"));  
	        rootPath = rootPath.replace("\\", "/");  
	    }  
	    return rootPath;  
	}  
}
