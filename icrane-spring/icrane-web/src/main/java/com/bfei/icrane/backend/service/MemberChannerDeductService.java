package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.CatchHistory;
import com.bfei.icrane.core.models.Charge;
import com.bfei.icrane.core.models.MemberChannelDeduct;

import java.util.List;

public interface MemberChannerDeductService {
	//渠道查询
	public PageBean<MemberChannelDeduct> getUserList(int page, int pageSize, String name, String memberid, String lastLoginFrom, String registerDate, String endDate);
	public int totalCount(String name, String memberid, String lastLoginFrom, String registerDate, String endDate);
	//搜索
//	public Member getMemberById(Integer id);
//	public int updateByPrimaryKeySelective(Member member, HttpServletRequest request);
	public PageBean<Charge> getChargeHistory(Integer id, Integer page, Integer pageSize);
	public PageBean<CatchHistory> getCatchHistory(Integer id, Integer page, Integer pageSize);
	public Integer insertSelective(MemberChannelDeduct memberChannelDeducts);
	public Integer insertSelectives(List<MemberChannelDeduct> memberChannelDeducts);

	//去重
	public Integer selectByUserid(Integer id);

	public Integer deleteByid(Integer id);
}
