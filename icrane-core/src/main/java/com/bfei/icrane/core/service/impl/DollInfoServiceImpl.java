package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.core.dao.DollInfoDao;
import com.bfei.icrane.core.models.DollInfo;
import com.bfei.icrane.core.service.DollInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃机管理业务接口实现类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("DollInfoService")
public class DollInfoServiceImpl implements DollInfoService {

    @Autowired
    DollInfoDao dollInfoDao;

    @Override
    public List<DollInfo> selectByLikeDollCode(Set<String> likeDollCode) {

        return dollInfoDao.selectByLikeDollCode(likeDollCode);

    }
}
