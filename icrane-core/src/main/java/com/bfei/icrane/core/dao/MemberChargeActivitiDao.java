package com.bfei.icrane.core.dao;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.MemberChargeActiviti;

public interface MemberChargeActivitiDao {
	//查询有效套餐用户
	MemberChargeActiviti selectMemberEffect(@Param("memberId") Integer MemberId,@Param("chargeType") Integer chargeType);

	void insertChargeActiviti(MemberChargeActiviti chargeActiviti);
}
