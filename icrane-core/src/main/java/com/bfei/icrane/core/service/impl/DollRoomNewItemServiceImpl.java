package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.DollDao;
import com.bfei.icrane.core.dao.DollInfoDao;
import com.bfei.icrane.core.dao.DollRoomNewDao;
import com.bfei.icrane.core.dao.DollRoomNewItemDao;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollInfo;
import com.bfei.icrane.core.models.DollRoomNew;
import com.bfei.icrane.core.models.DollRoomNewItem;
import com.bfei.icrane.core.models.vo.DollRoomNewItemAll;
import com.bfei.icrane.core.service.DollRoomNewItemService;
import com.bfei.icrane.core.service.DollRoomNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃机管理业务接口实现类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("DollRoomNewItemService")
public class DollRoomNewItemServiceImpl implements DollRoomNewItemService {

	@Autowired
	private DollRoomNewItemDao dollRoomNewItemDao;


	//房间分页
	@Override
	public PageBean<DollRoomNewItemAll> selectDollRoomNewItemList(int page, int pageSize, Integer dollRoomId, String dollRoomName) {
		PageBean<DollRoomNewItemAll> pageBean = new PageBean<DollRoomNewItemAll>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=dollRoomNewItemDao.totalCount(dollRoomName,dollRoomId);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<DollRoomNewItemAll> list=dollRoomNewItemDao.selectDollRoomNewItemList(dollRoomName,dollRoomId,begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}



	//添加房间
	@Override
	public int insertSelective(DollRoomNewItem dollRoomNew) {

		dollRoomNew.setCreatedDate(new Date());
		return dollRoomNewItemDao.insertDollRoomNewItem(dollRoomNew);
	}

	/**
	 * 删除房间
	 */
	@Override
	public int dollDollRoomNewItemDel(Integer id) {
		return dollRoomNewItemDao.deleteDollRoomNewItem(id);
	}

	/**
	 * 根据id查询娃娃机
	 */
	@Override
	public DollRoomNewItem getDollRoomNewItemById(Integer id) {
		return dollRoomNewItemDao.getDollRoomNewItemById(id);
	}
	/**
	 * 更新房间
	 */
	@Override
	public int updateByPrimaryKeySelective(DollRoomNewItem dollRoomNew) {
		//修改时间
		dollRoomNew.setModifiedDate(new Date());
		return dollRoomNewItemDao.updateDollRoomNewItem(dollRoomNew);
	}


	//查询机器信息
	@Override
	public List<Doll> selectDollByDollRoomItem() {
		return dollRoomNewItemDao.selectDollByDollRoomItem();
	}
}
