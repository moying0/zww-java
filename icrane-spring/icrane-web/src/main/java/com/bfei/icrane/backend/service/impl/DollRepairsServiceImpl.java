package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.DollRepairsService;
import com.bfei.icrane.backend.service.DollTopicService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.DollDao;
import com.bfei.icrane.core.dao.DollRepairsDao;
import com.bfei.icrane.core.dao.DollTopicDao;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollRepairs;
import com.bfei.icrane.core.models.DollTopic;
import com.bfei.icrane.core.models.vo.DollRepairsAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("DollRepairsService")
public class DollRepairsServiceImpl implements DollRepairsService {
	@Autowired
	private DollRepairsDao dollRepairsDao;


	@Override
	public PageBean<DollRepairsAll> getDollRepairsList(int page, int pageSize) {
		PageBean<DollRepairsAll> pageBean = new PageBean<DollRepairsAll>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=dollRepairsDao.totalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<DollRepairsAll> list = dollRepairsDao.selectDollRepairsList(begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}



}
