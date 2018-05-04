package com.bfei.icrane.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.core.dao.*;
import com.bfei.icrane.core.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.backend.service.MemberManageService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.web.utils.Const;
@Service("MemberManageService")
public class  MemberManageServiceImpl implements MemberManageService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private TModifyRecordMapper tModifyRecordMapper;
	@Autowired
	private ChargeDao chargeDao;
	@Autowired
	private CatchHistoryDao catchHistoryDao;

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public PageBean<Member> getUserList(int page, int pageSize, String name, String memberid, String registerFrom, String registerDate,String endDate,String registerChannel) {
		PageBean<Member> pageBean = new PageBean<Member>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=memberDao.totalCount(name,memberid,registerFrom,registerDate,endDate,registerChannel);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Member> list = memberDao.getUserList(begin, pageSize,name,memberid,registerFrom,registerDate,endDate,registerChannel);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public int totalCount(String name, String memberid, String lastLoginFrom, String registerDate,String endDate,String registerChannel) {
		return memberDao.totalCount(name,memberid,lastLoginFrom,registerDate,endDate,registerChannel);
	}


	@Override
	public int totalCount1(String name, String memberid, String lastLoginFrom, String registerDate,String endDate) {
		 return memberDao.totalCount1(name,memberid,lastLoginFrom,registerDate,endDate);
	}

	@Override
	public PageBean<Member> getUserList1(int page, int pageSize, String name, String memberid, String registerFrom, String registerDate,String endDate) {
		PageBean<Member> pageBean = new PageBean<Member>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=memberDao.totalCount1(name,memberid,registerFrom,registerDate,endDate);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Member> list = memberDao.getUserList1(begin, pageSize,name,memberid,registerFrom,registerDate,endDate);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public PageBean<Charge> getChargeHistory(Integer memberId,Integer page, Integer pageSize) {
		PageBean<Charge> pageBean = new PageBean<Charge>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=chargeDao.totalCount(memberId);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Charge> list = chargeDao.getChargeList(begin, pageSize, memberId);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	/**
	 * 抓去记录
	 * @param memberId
	 * @param page
	 * @param pageSize
	 * @return
	 */

	@Override
	public PageBean<CatchHistory> getCatchHistory(Integer memberId, Integer page, Integer pageSize) {
		PageBean<CatchHistory> pageBean = new PageBean<CatchHistory>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=catchHistoryDao.totalCount(memberId);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<CatchHistory> list = catchHistoryDao.getCatchHistory(begin, pageSize, memberId);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}


	@Override
	public Member getMemberById(Integer id) {
		return memberDao.getAllById(id);
	}

	//查询渠道
	@Override
	public List<Member> getMemberAll() {
		return memberDao.getMemberAllGroupBy();
	}

	@Override
	public int updateByPrimaryKeySelective(Member member,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			Member mb = memberDao.getMemberById(member.getId());
			if(mb.getCoins()!=member.getCoins()) {
				TModifyRecord tModifyRecord = new TModifyRecord();
				tModifyRecord.setMemberId(member.getId());
				tModifyRecord.setCoins(member.getCoins()-mb.getCoins());
				tModifyRecord.setModifiedDate(new Date());
				tModifyRecord.setModifiedBy(user.getId());
				tModifyRecordMapper.insert(tModifyRecord);
			}
		}
		return memberDao.updateByPrimaryKeySelective(member);
	}


	@Override
	public int updateBySelective(Account account,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			Account ac = accountDao.selectById(account.getId());
			if(ac.getCoins()!=account.getCoins()) {
				TModifyRecord tModifyRecord = new TModifyRecord();
				tModifyRecord.setMemberId(account.getId());
				tModifyRecord.setCoins(account.getCoins()-ac.getCoins());
				tModifyRecord.setSuperTicket(account.getSuperTicket()-ac.getSuperTicket());
				tModifyRecord.setModifiedDate(new Date());
				tModifyRecord.setModifiedBy(user.getId());
				tModifyRecordMapper.insertSelective(tModifyRecord);
			}
		}
		//return accountDao.updateByKeyId(account);
		return 1;
	}

}
