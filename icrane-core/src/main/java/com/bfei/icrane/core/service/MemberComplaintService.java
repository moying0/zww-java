package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.MemberComplaint;
import com.bfei.icrane.core.models.vo.MemberComplaintAll;

/**
 * 申诉列表 on 2017-12-03.
 */
public interface MemberComplaintService {

    //获取待处理申诉list
    PageBean<MemberComplaintAll> getMemberComplaintList(int page, int pageSize, String memberid);

    //获取已处理申诉list
    PageBean<MemberComplaintAll> getDoneMemberComplaintList(int page, int pageSize, String memberid);


    //修改
    Integer updateComplaintResult(Integer id, Integer state, String checkReason);

    Integer insert(MemberComplaint complaint);

    int selectMemberComplaintByHistoryId(Integer historyId);

}
