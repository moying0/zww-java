package com.bfei.icrane.core.dao;

import com.bfei.icrane.common.util.ResultMap;
import com.bfei.icrane.core.models.ComplaintProblem;
import com.bfei.icrane.core.models.DollRepairs;
import com.bfei.icrane.core.models.RepairsProblem;

import java.util.List;

public interface RepairsProblemDao {
    List<RepairsProblem> queryList();

    int count();

    int insertService(RepairsProblem repairsProblem);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepairsProblem repairsProblem);

    RepairsProblem selectByPrimaryKey(Integer id);

    void insertRepairs(DollRepairs dollRepairs);
}
