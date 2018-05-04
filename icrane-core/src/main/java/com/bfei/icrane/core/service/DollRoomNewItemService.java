package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollInfo;
import com.bfei.icrane.core.models.DollRoomNew;
import com.bfei.icrane.core.models.DollRoomNewItem;
import com.bfei.icrane.core.models.vo.DollRoomNewItemAll;

import java.util.List;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃机管理业务接口.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollRoomNewItemService {



	//获取房间关联列表PageBean分页
	 PageBean<DollRoomNewItemAll> selectDollRoomNewItemList(int page, int pageSize, Integer dollRoomId, String dollRoomName);


	//新增娃娃机房间
	int insertSelective(DollRoomNewItem dollRoomNew);

	/**
	 * 删除房间
	 */
	 int dollDollRoomNewItemDel(Integer id);

	/**
	 * 根据id查询娃娃机
	 */
	 DollRoomNewItem getDollRoomNewItemById(Integer id);

	/**
	 * 更新房间
	 */
	 int updateByPrimaryKeySelective(DollRoomNewItem dollRoomNew);

	 //查询排除机器
	 List<Doll> selectDollByDollRoomItem();

}
