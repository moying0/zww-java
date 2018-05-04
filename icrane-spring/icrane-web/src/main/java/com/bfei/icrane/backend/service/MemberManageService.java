package com.bfei.icrane.backend.service;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.CatchHistory;
import com.bfei.icrane.core.models.Charge;
import com.bfei.icrane.core.models.Member;

import java.util.Date;
import java.util.List;

public interface MemberManageService {
    //渠道查询
    PageBean<Member> getUserList(int page, int pageSize, String name, String memberid, String lastLoginFrom, String registerDate, String endDate, String registerChannel);

    int totalCount(String name, String memberid, String lastLoginFrom, String registerDate, String endDate, String registerChannel);

    //搜索
    PageBean<Member> getUserList1(int page, int pageSize, String name, String memberid, String lastLoginFrom, String registerDate, String endDate);

    int totalCount1(String name, String memberid, String lastLoginFrom, String registerDate, String endDate);

    Member getMemberById(Integer id);

    int updateByPrimaryKeySelective(Member member, HttpServletRequest request);

    PageBean<Charge> getChargeHistory(Integer id, Integer page, Integer pageSize);

    PageBean<CatchHistory> getCatchHistory(Integer id, Integer page, Integer pageSize);

    //查询渠道
    List<Member> getMemberAll();

    //修改金币，券
    int updateBySelective(Account account, HttpServletRequest request);
}
