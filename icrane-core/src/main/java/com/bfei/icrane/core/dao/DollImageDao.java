package com.bfei.icrane.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.DollImage;

public interface DollImageDao {
	List<DollImage> getImageList(@Param("begin")int begin,@Param("pageSize")int pageSize,@Param("name")String name);
	int totalCount(@Param("name")String name);
	DollImage getImageById(Integer id);
	int insertSelective(DollImage dollImage);
	int deleteById(Integer id);
	int updateImage(DollImage dollImage);
	int deleteAllById(@Param("ids")List<String> ids);
}
