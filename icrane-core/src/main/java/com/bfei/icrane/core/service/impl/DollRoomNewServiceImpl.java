package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.DollInfoDao;
import com.bfei.icrane.core.dao.DollRoomNewDao;
import com.bfei.icrane.core.dao.DollRoomNewItemDao;
import com.bfei.icrane.core.models.*;
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
@Service("DollRoomNewService")
public class DollRoomNewServiceImpl implements DollRoomNewService {

    @Autowired
    private DollRoomNewDao dollRoomNewDao;

    @Autowired
    private DollRoomNewItemDao dollRoomNewItemDao;

    @Autowired
    private DollInfoDao dollInfoDao;

    //查询娃娃信息
    @Override
    public List<DollInfo> selectDollInfoList() {
        return dollInfoDao.selectDollInfoList();
    }

    @Override
    public DollInfo selectDollInfoByDollCode(String dollCode) {
        return dollInfoDao.selectDollInfoByDollCode(dollCode);
    }

    //房间分页
    @Override
    public PageBean<DollRoomNew> selectDollRoomNewList(int page, int pageSize, Integer id) {
        PageBean<DollRoomNew> pageBean = new PageBean<DollRoomNew>();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        totalCount = dollRoomNewDao.totalCount();
        pageBean.setTotalCount(totalCount);
        int totalPage = 0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page - 1) * pageSize;
        List<DollRoomNew> list = dollRoomNewDao.selectDollRoomNewList(id, begin, pageSize);
        pageBean.setList(list);
        int start = page % 10 == 0 ? (page - 1) / 10 * 10 + 1 : page / 10 * 10 + 1;
        int end = page % 10 == 0 ? ((page - 1) / 10 * 10 + 10 > totalPage ? totalPage : (page - 1) / 10 * 10 + 10) : (page / 10 * 10 + 10 > totalPage ? totalPage : page / 10 * 10 + 10);
        pageBean.setStart(start);
        pageBean.setEnd(end);
        return pageBean;
    }


    //添加房间
    @Override
    public int insertSelective(DollRoomNew dollRoomNew) {

        if (dollRoomNew.getDollId() != null) {
            DollInfo dollInfo = dollInfoDao.selectDollInfoById(dollRoomNew.getDollId());
            if (dollInfo != null) {
                dollRoomNew.setDollName(dollInfo.getDollName());
                dollRoomNew.setDollNo(dollInfo.getDollCode());
            }
        }
        dollRoomNew.setCreatedDate(new Date());
        return dollRoomNewDao.insertDollRoomNew(dollRoomNew);
    }

    /**
     * 删除房间
     */
    @Override
    public int dollRoomNewDel(Integer id) {
        dollRoomNewItemDao.deleteDollRoomNewItemByRoomId(id);
        return dollRoomNewDao.deleteDollRoomNew(id);
    }

    /**
     * 根据id查询娃娃机
     */
    @Override
    public DollRoomNew getDollRoomNewById(Integer id) {
        return dollRoomNewDao.getDollRoomNewById(id);
    }

    /**
     * 更新房间
     */
    @Override
    public int updateByPrimaryKeySelective(DollRoomNew dollRoomNew) {
        if (dollRoomNew.getDollId() != null) {
            DollInfo dollInfo = dollInfoDao.selectDollInfoById(dollRoomNew.getDollId());
            if (dollInfo != null) {
                dollRoomNew.setDollName(dollInfo.getDollName());
                dollRoomNew.setDollNo(dollInfo.getDollCode());
            }
        }
        //修改时间
        dollRoomNew.setModifiedDate(new Date());
        return dollRoomNewDao.updateDollRoomNew(dollRoomNew);
    }
//
//	@Override
//	public int totalCount(String name, String machineCode,String machineStates) {
//		// TODO Auto-generated method stub
//		return dollDao.totalCount(name,machineCode,machineCode);
//	}
//
//	@Override
//	public List<Doll> allDollList() {
//		return dollDao.allDollList();
//	}


}
