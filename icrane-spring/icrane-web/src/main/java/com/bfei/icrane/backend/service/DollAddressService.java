package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.DollAddress;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DollAddressService {
    PageBean<DollAddress> getDollAddressList(int page, int pageSize);

    List<DollAddress> getDollAddressList();

    //搜索
    DollAddress getDollAddressById(Integer id);

    int updateByPrimaryKeySelective(DollAddress dollAddress, HttpServletRequest request);

    int insertSelective(DollAddress dollAddress);

    int deleteByPrimaryKey(Integer id);
}
