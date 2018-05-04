package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.DollRoom;
import com.bfei.icrane.core.models.DollRoomNew;
import com.bfei.icrane.core.pojos.CatchDollPojo;
import com.bfei.icrane.core.pojos.DollImgPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lgq
 * Version: 1.0
 * Date: 2017/9/23
 * Description: 房间Dao接口类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollRoomNewDao {

	//查询房间列表
	List<DollRoomNew> selectDollRoomNewList(@Param("id") Integer id, @Param("begin") int begin, @Param("pageSize") int pageSize);

	//总数
	Integer totalCount();

	//添加房间信息
    public Integer insertDollRoomNew(DollRoomNew dollRoomNew);

    //按id查询
	public DollRoomNew getDollRoomNewById(@Param("id")Integer id);

	//按id修改信息
	public Integer updateDollRoomNew(DollRoomNew dollRoomNew);

	//按id删除信息
	public Integer deleteDollRoomNew(@Param("id")Integer id);


}









