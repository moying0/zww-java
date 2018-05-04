package com.bfei.icrane.common.comparator;

import java.util.Comparator;

import com.bfei.icrane.core.models.User;
/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: 用户排序比较器.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class UserComparator implements Comparator<User>{  
	  
    public int compare(User o1, User o2) {  
        //按视频序号升序
        return o1.getId() - o2.getId();  
    }  
      
}  
