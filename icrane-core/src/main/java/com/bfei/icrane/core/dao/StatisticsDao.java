package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.vo.DollMachineStatistics;
import com.bfei.icrane.core.models.vo.MemberCatchStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by webrx on 2017-12-03.
 */
public interface StatisticsDao {

    List<DollMachineStatistics> getMachineStatisticsList(@Param("begin") int begin, @Param("pageSize") int pageSize);

    int totalCount();

}
