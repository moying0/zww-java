package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.MemberChannerDeductService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.*;
import com.bfei.icrane.core.models.*;
import com.bfei.icrane.web.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service("MemberChanneDeductService")
public class MemberChannerDeductServiceImpl implements MemberChannerDeductService {
	@Autowired
	private MemberChannelDeductDao memberChannelDeductDao;
	@Autowired
	private ChargeDao chargeDao;
	@Autowired
	private CatchHistoryDao catchHistoryDao;
	
	@Override
	public PageBean<MemberChannelDeduct> getUserList(int page, int pageSize, String name, String memberid, String registerFrom, String registerDate,String endDate) {
		PageBean<MemberChannelDeduct> pageBean = new PageBean<MemberChannelDeduct>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=memberChannelDeductDao.totalCount(name,memberid,registerFrom,registerDate,endDate);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<MemberChannelDeduct> list = memberChannelDeductDao.getUserList(begin, pageSize,name,memberid,registerFrom,registerDate,endDate);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public int totalCount(String name, String memberid, String lastLoginFrom, String registerDate,String endDate) {
		return memberChannelDeductDao.totalCount(name,memberid,lastLoginFrom,registerDate,endDate);
	}

	@Override
	public Integer insertSelective(MemberChannelDeduct memberChannelDeduct) {
		return memberChannelDeductDao.insertSelective(memberChannelDeduct);
	}

	@Override
	public Integer insertSelectives(List<MemberChannelDeduct> memberChannelDeduct) {
		return memberChannelDeductDao.insertSelectives(memberChannelDeduct);
	}

	//去重查询
	@Override
	public Integer selectByUserid(Integer id) {
		return memberChannelDeductDao.selectByUserid(id);
	}

	@Override
	public Integer deleteByid(Integer id) {
		return memberChannelDeductDao.deleteByid(id);
	}

	//充值记录
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


//	@Override
//	public MemberChannelDeduct getMemberById(Integer id) {
//		return memberDao.getMemberById(id);
//	}
//
//	@Override
//	public int updateByPrimaryKeySelective(MemberChannelDeduct member,HttpServletRequest request) {
//		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
//		if(user!=null) {
//			MemberChannelDeduct mb = memberDao.getMemberById(member.getId());
//			if(mb.getCoins()!=member.getCoins()) {
//				TModifyRecord tModifyRecord = new TModifyRecord();
//				tModifyRecord.setMemberId(member.getId());
//				tModifyRecord.setCoins(member.getCoins()-mb.getCoins());
//				tModifyRecord.setModifiedDate(new Date());
//				tModifyRecord.setModifiedBy(user.getId());
//				tModifyRecordMapper.insert(tModifyRecord);
//			}
//		}
//		return memberDao.updateByPrimaryKeySelective(member);
//	}

}
