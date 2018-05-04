package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.InitializeHeads;
import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.models.ShareInvite;
import com.bfei.icrane.core.models.vo.ShareInviteAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by SUN on 2018/1/10.
 */
public interface ShareInviteDao {

    ShareInvite selectById(@Param("id") Integer id);

    List<Member> selectByWhere(@Param("registerDate") String registerDate, @Param("memberid") String memberid, @Param("name") String name,@Param("page") Integer page, @Param("pageSize") Integer pageSize);
    List<ShareInviteAll> selectByWhereId(@Param("id") Integer id, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    List<ShareInviteAll> selectByWhereWhere(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("id") Integer id, @Param("page") Integer page, @Param("pageSize") Integer pageSize);
    //被邀请人数
    int totalCountVisitWhere(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("id") Integer id);

    //邀请人数
    int totalCount(@Param("registerDate") String registerDate, @Param("memberid") String memberid, @Param("name") String name);

    //被邀请人数
    int totalCountBVisit(@Param("registerDate") String registerDate, @Param("memberid") String memberid, @Param("name") String name);

    //被邀请充值人数
    int totalCountMemberBVisitToMoney(@Param("id") Integer id);

    //某一邀请人邀请人数
    Integer totalCountMemberBVisit(@Param("id") Integer id);
}
