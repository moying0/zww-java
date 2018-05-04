package com.bfei.icrane.core.dao;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.DollMonitor;

public interface DollMonitorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DollMonitor record);

    int insertSelective(DollMonitor record);

    DollMonitor selectByPrimaryKey(Integer id);
    
    DollMonitor selectByDollIdType(@Param("dollId") Integer dollId, @Param("alertType") String type);

    int updateByPrimaryKeySelective(DollMonitor record);

    int updateByPrimaryKey(DollMonitor record);
}