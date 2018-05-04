package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.vo.MemberCatchStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by webrx on 2017-12-03.
 */
public interface MemberCatchSuccessDao {

    List<MemberCatchStatistics> getUserList(@Param("begin")int begin, @Param("pageSize")int pageSize, @Param("name")String name, @Param("memberID")String memberID, @Param("lastLoginFrom")String lastLoginFrom, @Param("registerDate")String registerDate);

    int totalCount(@Param("name")String name,@Param("memberid")String memberid,@Param("lastLoginFrom")String lastLoginFrom,@Param("registerDate")String registerDate);

}
