package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.DollInfo;
import com.bfei.icrane.core.models.DollRoomNew;

import java.util.List;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃机管理业务接口.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollRoomNewService {

	//通过id查询信息
	DollInfo selectDollInfoByDollCode(String dollCode);


	//获取娃娃机列表PageBean分页
	 PageBean<DollRoomNew> selectDollRoomNewList(int page, int pageSize, Integer id);

	//查询娃娃房间信息
	List<DollInfo> selectDollInfoList();

	//新增娃娃机房间
	int insertSelective(DollRoomNew dollRoomNew);

	/**
	 * 删除房间
	 */
	 int dollRoomNewDel(Integer id);

	/**
	 * 根据id查询娃娃机
	 */
	 DollRoomNew getDollRoomNewById(Integer id);

	/**
	 * 更新房间
	 */
	 int updateByPrimaryKeySelective(DollRoomNew dollRoomNew);

}
