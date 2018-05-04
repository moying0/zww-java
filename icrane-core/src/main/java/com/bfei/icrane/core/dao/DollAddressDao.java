package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.DollAddress;
import com.bfei.icrane.core.models.DollTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mwan Version: 1.0 Date: 2017/9/16 Description: 用户Dao接口类. Copyright
 *         (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollAddressDao {


	/**
	 * 更新机器地址
	 */
	int updateByPrimaryKeySelective(DollAddress dollAddress);
	int insertSelective(DollAddress dollAddress);
	/**
	 * 分页查询机器地址列表
	 */
	List<DollAddress> getDollAddressList(@Param("begin") int begin, @Param("pageSize") int pageSize);
	/**
	 * 总记录数
	 */
	int totalCount();

	DollAddress selectByPrimaryKey(@Param("id") Integer id);

	int deleteByPrimaryKey(@Param("id") Integer id);

	List<DollAddress> selectDollAddress();

}




