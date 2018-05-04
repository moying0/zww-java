package com.bfei.icrane.core.dao;

import java.util.List;

import com.bfei.icrane.core.models.DollParticulars;
import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.DollRoom;
import com.bfei.icrane.core.pojos.CatchDollPojo;
import com.bfei.icrane.core.pojos.DollImgPojo;

/**
 * @author lgq
 * Version: 1.0
 * Date: 2017/9/23
 * Description: 用户Dao接口类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface DollRoomDao {

    public Integer insertDollRoom(DollRoom dollRoom);
    
    public Integer outDollRoom(Integer member);
    
    public DollRoom getDollId(Integer memberId);
    /**
	 * 在线人数
	 * @return
	 */
	public DollRoom getDollRoomCount(Integer dollId);
	
	List<DollRoom> getMemberHead(@Param("dollId") Integer dollId,@Param("offset") int offset, @Param("limit") int limit);
	
	public DollRoom getPlayMember(Integer dollId);
	
	public List<DollImgPojo> getDollImg(Integer dollId);
	
	List<CatchDollPojo> getCatchDoll(Integer dollId);
	//清除当前房间所有玩家的楼主标记
	public int clearPlayFlagByDollId(Integer dollId);
	//设置某玩家为楼主
	public int setPlayFlag(@Param("dollId") Integer dollId, @Param("memberId") Integer memberId);
	//检查当前房间是否有楼主
	public Integer checkPlaying(Integer dollId);
	//获取娃娃详情
	DollParticulars selectDollParticularsById(Integer dollId);
}









