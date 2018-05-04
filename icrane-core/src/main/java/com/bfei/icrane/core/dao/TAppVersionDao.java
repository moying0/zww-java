package com.bfei.icrane.core.dao;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.TAppVersion;

public interface TAppVersionDao {

	TAppVersion selectByPrimaryKey(String appKey);

	TAppVersion selectVersionHide(@Param("appKey") String appKey,@Param("version") String version);

}