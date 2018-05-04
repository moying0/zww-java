package com.bfei.icrane.core.service;

import java.util.List;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.ComplaintProblem;

/**
 * 申诉列表 on 2017-12-03.
 */
public interface ComplaintProblemService {

    //获取申诉问题list
    public PageBean<ComplaintProblem> getComplaintProblemList(int page, int pageSize);

    //修改
    Integer updateComplaintResult(ComplaintProblem complaintProblem);

    //添加
    Integer insertComplaintResult(ComplaintProblem complaintProblem);

    //删除
    Integer deleteByid(Integer id);

    //查询byid
    ComplaintProblem selectByPrimaryKey(Integer id);
    
    List<ComplaintProblem> queryList();
}
