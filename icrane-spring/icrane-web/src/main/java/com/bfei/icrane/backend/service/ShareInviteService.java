package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.Banner;
import com.bfei.icrane.core.models.Charge;
import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.models.ShareInvite;
import com.bfei.icrane.core.models.vo.ShareInviteAll;

public interface ShareInviteService {
	PageBean<Member> selectShareInviteList(String registerDate, String memberid, String name,int page, int pageSize);

	PageBean<ShareInviteAll> selectShareInviteById(Integer id, int page, int pageSize);

	PageBean<ShareInviteAll> selectShareInviteBywhere(String startTime, String endTime, Integer id, int page, int pageSize);

	//被邀请人数
	Integer totalCountBVisit(String registerDate, String memberid, String name);

	//某一邀请人邀请人数
	Integer totalCountMemberBVisit(Integer id);

	//某一邀请人充值人数
	Integer totalCountMemberBVisitToMoney(Integer id);
}
