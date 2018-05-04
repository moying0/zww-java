package com.bfei.icrane.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.MemberComplaint;
import com.bfei.icrane.core.models.vo.MemberComplaintAll;

/**
 * Created by webrx on 2017-12-09.
 */
public interface MemberComplaintDao {

    List<MemberComplaintAll> getMemberComplaintList(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("memberNum") String memberNum);

    List<MemberComplaintAll> getDoneMemberComplaintList(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("memberNum") String memberNum);

    Integer totalCount(@Param("memberNum") String memberNum);

    Integer totalDoneCount(@Param("memberNum") String memberNum);

    Integer updateComplaintResult(@Param("id") Integer id, @Param("checkState") Integer state, @Param("checkReason") String checkReason, @Param("modifyTime") Date modifyTime);

    MemberComplaintAll selectByPrimaryKey(@Param("id") Integer id);

    Integer insert(MemberComplaint complaint);


    /**
     * 根据抓取记录获取申述信息
     *
     * @param historyId 抓取历史id
     * @return 申诉信息
     */
    int selectMemberComplaintByHistoryId(Integer historyId);
}
