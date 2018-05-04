package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.DollOrder;
import com.bfei.icrane.core.models.DollOrderGoods;
import com.bfei.icrane.core.models.DollOrderItem;
import com.bfei.icrane.core.models.vo.DollMachineStatistics;
import com.bfei.icrane.core.models.vo.OutGoods;

import java.util.List;

public interface StatisticsService {

	public PageBean<DollMachineStatistics> getMachineStatisticsList(int page, int pageSize);
//	public List<DollOrderItem> getOrderItemByOrderId(Integer id);
//	public int updateByPrimaryKeySelective(DollOrder dollOrder);
//	public PageBean<OutGoods> getOutOrdersByStatus(int page, int pageSize, String phone, int outGoodsId);
//	public PageBean<DollOrderGoods> getAllOutOrdersByStatus(int page, int pageSize, String phone);


}
