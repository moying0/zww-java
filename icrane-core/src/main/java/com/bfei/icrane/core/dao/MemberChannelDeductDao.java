package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mwan Version: 1.0 Date: 2017/9/16 Description: 用户Dao接口类. Copyright
 *         (c) 2017 伴飞网络. All rights reserved.
 */
public interface MemberChannelDeductDao {

	/**
	 * 插入
	 */
	Integer insertSelective(MemberChannelDeduct memberChannelDeduct);
	Integer insertSelectives(@Param("memberChannelDeducts") List<MemberChannelDeduct> memberChannelDeducts);
	//去重
	Integer selectByUserid(@Param("userId") Integer id);
	/**
	 * 根据手机号查询
	 */
	Member selectByMobile(String mobile);

	/**
	 * 根据邀请码查询
	 */
	Member selectByMemberID(String memberID);

	/**
	 * 更新用户属性
	 */
	int updateByPrimaryKeySelective(Member member);

	/**
	 * 分页查询用户列表
	 */
	List<MemberChannelDeduct> getUserList(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("name") String name, @Param("memberID") String memberID, @Param("lastLoginFrom") String lastLoginFrom, @Param("registerDate") String registerDate, @Param("endDate") String endDate);
	/**
	 * 总记录数
	 */
	int totalCount(@Param("name") String name, @Param("memberid") String memberid, @Param("lastLoginFrom") String lastLoginFrom, @Param("registerDate") String registerDate, @Param("endDate") String endDate);


	Integer deleteByid(@Param("id")Integer id);
}




