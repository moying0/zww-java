package com.bfei.icrane.core.dao;



import com.bfei.icrane.core.models.PrefSet;
/**
 * @author lgq
 * Version: 1.0
 * Date: 2017/9/21
 * Description: 用户Dao接口类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface PrefSetDao {

    public Integer updateByPrimaryKeySelective(PrefSet prefSet);

}
