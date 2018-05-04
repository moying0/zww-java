package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.DollRepairs;
import com.bfei.icrane.core.models.MemberComplaint;
import com.bfei.icrane.core.models.RepairsProblem;
import com.bfei.icrane.core.models.vo.DollRepairsAll;
import com.bfei.icrane.core.models.vo.MemberComplaintAll;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by webrx on 2017-12-09.
 */
public interface DollRepairsDao {

    List<DollRepairsAll> selectDollRepairsList(@Param("begin") int begin, @Param("pageSize") int pageSize);

    Integer totalCount();

    Integer updateDollRepairs(DollRepairs dollRepairs);

    DollRepairs selectByPrimaryKey(@Param("id") Integer id);

    Integer insert(DollRepairs repairs);


}
