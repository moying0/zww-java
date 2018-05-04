package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.vo.MemberCatchStatistics;

/**
 * Created by webrx on 2017-12-03.
 */
public interface MemberCatchSuccessService {

    //获取list
    public PageBean<MemberCatchStatistics> getCatchStatisticsList(int page, int pageSize, String name, String memberid, String lastLoginFrom, String registerDate);


}
