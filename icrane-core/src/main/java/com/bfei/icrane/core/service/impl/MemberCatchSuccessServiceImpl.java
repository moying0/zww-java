package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.MemberCatchSuccessDao;
import com.bfei.icrane.core.models.vo.MemberCatchStatistics;
import com.bfei.icrane.core.service.MemberCatchSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抓取成功次数 on 2017-12-03.
 */

@Service("MemberCatchSuccessService")
public class MemberCatchSuccessServiceImpl implements MemberCatchSuccessService {

    @Autowired
    private MemberCatchSuccessDao memberCatchSuccessDao;

    @Override
    public PageBean<MemberCatchStatistics> getCatchStatisticsList(int page,int pageSize,String name,String memberid,String lastLoginFrom,String registerDate) {
        PageBean<MemberCatchStatistics> pageBean = new PageBean<MemberCatchStatistics>();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        totalCount=memberCatchSuccessDao.totalCount(name,memberid,lastLoginFrom,registerDate);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page - 1) * pageSize;
        List<MemberCatchStatistics> list = memberCatchSuccessDao.getUserList(begin, pageSize,name,memberid,lastLoginFrom,registerDate);
        pageBean.setList(list);
        int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
        int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
        pageBean.setStart(start);
        pageBean.setEnd(end);
        return pageBean;
    }


}
