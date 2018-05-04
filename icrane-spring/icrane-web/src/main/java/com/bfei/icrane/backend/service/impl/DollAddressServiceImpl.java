package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.DollAddressService;
import com.bfei.icrane.backend.service.DollTopicService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.DollAddressDao;
import com.bfei.icrane.core.dao.DollDao;
import com.bfei.icrane.core.dao.DollTopicDao;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollAddress;
import com.bfei.icrane.core.models.DollTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service("DollAddressService")
public class DollAddressServiceImpl implements DollAddressService {
	@Autowired
	private DollAddressDao dollAddressDao;


	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dollAddressDao.deleteByPrimaryKey(id);
	}

	@Override
	public PageBean<DollAddress> getDollAddressList(int page, int pageSize) {
		PageBean<DollAddress> pageBean = new PageBean<DollAddress>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=dollAddressDao.totalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<DollAddress> list = dollAddressDao.getDollAddressList(begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public List<DollAddress> getDollAddressList() {
		return dollAddressDao.selectDollAddress();
	}

	@Override
	public DollAddress getDollAddressById(Integer id) {
		return dollAddressDao.selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(DollAddress dollAddress) {
		dollAddress.setCreatedDate(new Date());
		return dollAddressDao.insertSelective(dollAddress);
	}

	@Override
	public int updateByPrimaryKeySelective(DollAddress dollAddress, HttpServletRequest request) {
		dollAddress.setModifiedDate(new Date());
		return dollAddressDao.updateByPrimaryKeySelective(dollAddress);
	}
}
