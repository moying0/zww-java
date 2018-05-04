package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.DollInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author lgq
 *         Version: 1.0
 *         Date: 2017/9/23
 *         Description: 用户Dao接口类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollInfoDao {

    //通过id查询信息
    DollInfo selectDollInfoById(@Param("id") Integer id);

    List<DollInfo> selectDollInfoList();

    DollInfo selectDollInfoByDollCode(String dollCode);

    List<DollInfo> selectByLikeDollCode(@Param("set") Set<String> likeDollCode);

    boolean selectOnline(String dollCode);

}









