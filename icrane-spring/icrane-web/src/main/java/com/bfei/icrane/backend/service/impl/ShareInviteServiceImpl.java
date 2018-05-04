package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.BannerService;
import com.bfei.icrane.backend.service.ShareInviteService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.BannerDao;
import com.bfei.icrane.core.dao.ShareInviteDao;
import com.bfei.icrane.core.models.Banner;
import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.models.ShareInvite;
import com.bfei.icrane.core.models.vo.ShareInviteAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ShareInviteService")
public class ShareInviteServiceImpl implements ShareInviteService {
	@Autowired
	private ShareInviteDao shareInviteDao;

	@Override
	public PageBean<Member> selectShareInviteList(String registerDate, String memberid, String name,int page, int pageSize) {
		PageBean<Member> pageBean = new PageBean<Member>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=shareInviteDao.totalCount(registerDate, memberid, name);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Member> list = shareInviteDao.selectByWhere( registerDate, memberid, name,begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}


	@Override
	public PageBean<ShareInviteAll> selectShareInviteById(Integer id, int page, int pageSize) {
		PageBean<ShareInviteAll> pageBean = new PageBean<ShareInviteAll>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=shareInviteDao.totalCountMemberBVisit(id);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<ShareInviteAll> list = shareInviteDao.selectByWhereId(id, begin, pageSize);

		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public PageBean<ShareInviteAll> selectShareInviteBywhere(String startTime, String endTime, Integer id, int page, int pageSize) {
		PageBean<ShareInviteAll> pageBean = new PageBean<ShareInviteAll>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=shareInviteDao.totalCountVisitWhere(startTime,endTime,id);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<ShareInviteAll> list = shareInviteDao.selectByWhereWhere(startTime,endTime,id, begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public Integer totalCountBVisit(String registerDate, String memberid, String name) {
		return shareInviteDao.totalCountBVisit(registerDate,memberid,name);
	}

	@Override
	public Integer totalCountMemberBVisit(Integer id) {
		return shareInviteDao.totalCountMemberBVisit(id);
	}

	@Override
	public Integer totalCountMemberBVisitToMoney(Integer id) {
		return shareInviteDao.totalCountMemberBVisitToMoney(id);
	}
}
