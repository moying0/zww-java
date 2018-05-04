package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollRoomNew;
import com.bfei.icrane.core.models.DollRoomNewItem;
import com.bfei.icrane.core.models.vo.DollRoomNewItemAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lgq
 * Version: 1.0
 * Date: 2017/9/23
 * Description: 房间Dao接口类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollRoomNewItemDao {

	//查询房间列表
	List<DollRoomNewItemAll> selectDollRoomNewItemList(@Param("dollRoomName") String dollRoomName, @Param("dollRoomId") Integer dollRoomId, @Param("begin") int begin, @Param("pageSize") int pageSize);
	//总数
	Integer totalCount(@Param("dollRoomName") String dollRoomName, @Param("dollRoomId") Integer dollRoomId);

	//添加房间信息
    public Integer insertDollRoomNewItem(DollRoomNewItem dollRoomNew);

    //按id查询
	public DollRoomNewItem getDollRoomNewItemById(@Param("id") Integer id);

	//按id修改信息
	public Integer updateDollRoomNewItem(DollRoomNewItem dollRoomNew);

	//按id删除信息
	public Integer deleteDollRoomNewItem(@Param("id") Integer id);

	//按doll_room_id删除信息
	public Integer deleteDollRoomNewItemByRoomId(@Param("dollRoomId") Integer id);

	//按id排除doll信息
	public List<Doll> selectDollByDollRoomItem();
}









