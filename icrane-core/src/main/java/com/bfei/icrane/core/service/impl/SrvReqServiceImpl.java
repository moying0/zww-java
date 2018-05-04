package com.bfei.icrane.core.service.impl;

import java.util.Date;
import java.util.List;

import com.bfei.icrane.core.models.vo.MemberCatchStatistics;
import com.bfei.icrane.core.models.vo.MemberFeedbackAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.common.util.OrderNoUtil;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.SrvReqDao;
import com.bfei.icrane.core.models.SrvReq;
import com.bfei.icrane.core.service.SrvReqService;
/**
 * @ClassName: SrvReqServiceImpl 
 * @Description: 工单Service实现类
 * @author perry 
 * @date 2017年9月27日 下午2:24:08 
 * @version V1.0
 */
@Service("SrvreqService")
public class SrvReqServiceImpl implements SrvReqService {
	@Autowired
	private SrvReqDao srvReqDao;
	
	@Override
	public int insert(SrvReq sr) {
		return srvReqDao.insert(sr);
	}

	@Override
	public int insertSelective(SrvReq sr) {
		sr.setCreatedDate(new Date());
		String orderNo=OrderNoUtil.getOrderNo();
		sr.setSrNumber(orderNo);
		sr.setSrStatus("0");
		return srvReqDao.insertSelective(sr);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return srvReqDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SrvReq sr) {
		return srvReqDao.updateByPrimaryKeySelective(sr);
	}

	@Override
	public int updateByPrimaryKey(SrvReq sr) {
		return srvReqDao.updateByPrimaryKey(sr);
	}

	@Override
	public PageBean<SrvReq> select(int createdBy, int page, int pageSize) {
		PageBean<SrvReq> pageBean = new PageBean<SrvReq>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=srvReqDao.count();
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<SrvReq> list = srvReqDao.select(createdBy,begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SrvReq selectByPrimaryKey(Integer id) {
		return srvReqDao.selectByPrimaryKey(id);
	}

	@Override
	public int count() {
		return srvReqDao.count();
	}

	@Override
	public PageBean<MemberFeedbackAll> selectAll(String memberId, int page, int pageSize) {
		PageBean<MemberFeedbackAll> pageBean = new PageBean<MemberFeedbackAll>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=srvReqDao.totalCount(memberId);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<MemberFeedbackAll> list = srvReqDao.selectAll(memberId,begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

}
