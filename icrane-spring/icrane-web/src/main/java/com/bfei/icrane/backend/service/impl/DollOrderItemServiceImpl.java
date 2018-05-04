package com.bfei.icrane.backend.service.impl;

import com.bfei.icrane.backend.service.DollOrderItemService;
import com.bfei.icrane.core.dao.DollOrderItemDao;
import com.bfei.icrane.core.models.DollOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by webrx on 2017-12-06.
 */
@Service("DollOrderItemService")
public class DollOrderItemServiceImpl implements DollOrderItemService{

    @Autowired
    public DollOrderItemDao dollOrderItemDao;

    @Override
    public int insertSelective(DollOrderItem record) {
        return dollOrderItemDao.insertSelective(record);
    }
}
