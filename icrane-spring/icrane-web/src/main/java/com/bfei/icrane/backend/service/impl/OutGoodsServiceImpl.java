package com.bfei.icrane.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.backend.service.OutGoodsService;
import com.bfei.icrane.core.dao.OutGoodsDao;
import com.bfei.icrane.core.pojos.DollOrderPojo;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2017/9/16
 * Description: 用户Service接口实现类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("OutGoodsService")
public class OutGoodsServiceImpl implements OutGoodsService {
	
	@Autowired
	private OutGoodsDao outGoodsDao;

	@Override
	public List<DollOrderPojo> outGoodsList() {
		// TODO Auto-generated method stub
		return outGoodsDao.outGoodsList();
	}

}
