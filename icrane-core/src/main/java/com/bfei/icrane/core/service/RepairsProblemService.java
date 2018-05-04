package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.common.util.ResultMap;
import com.bfei.icrane.core.models.ComplaintProblem;
import com.bfei.icrane.core.models.RepairsProblem;

import java.util.List;

/**
 * 申诉列表 on 2017-12-03.
 */
public interface RepairsProblemService {

    //获取报修问题list
    public PageBean<RepairsProblem> getComplaintProblemList(int page, int pageSize);

    //修改
    Integer updateComplaintResult(RepairsProblem complaintProblem);

    //添加
    Integer insertComplaintResult(RepairsProblem complaintProblem);

    //删除
    Integer deleteByid(Integer id);

    //查询byid
    RepairsProblem selectByPrimaryKey(Integer id);

    List<RepairsProblem> queryList();

    //报修
    ResultMap insertRepairs(Integer memberId, Integer bollId, String reason);
}
