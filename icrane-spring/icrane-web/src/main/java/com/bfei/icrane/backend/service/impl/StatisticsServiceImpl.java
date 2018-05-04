package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.OutGoodsService;
import com.bfei.icrane.backend.service.StatisticsService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.OutGoodsDao;
import com.bfei.icrane.core.dao.StatisticsDao;
import com.bfei.icrane.core.models.DollTopic;
import com.bfei.icrane.core.models.vo.DollMachineStatistics;
import com.bfei.icrane.core.pojos.DollOrderPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2017/9/16
 * Description: 用户Service接口实现类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("StatisticsService")
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	private StatisticsDao statisticsDao;


	@Override
	public PageBean<DollMachineStatistics> getMachineStatisticsList(int page, int pageSize) {
		PageBean<DollMachineStatistics> pageBean = new PageBean<DollMachineStatistics>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=statisticsDao.totalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<DollMachineStatistics> list = statisticsDao.getMachineStatisticsList(begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}
}
