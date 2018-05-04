package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.MemberWhite;

import javax.servlet.http.HttpServletRequest;

public interface MemberWhiteService {
    PageBean<MemberWhite> getUserList(int page, int pageSize, String memberId);

    int totalCount(String memberId);

    //搜索
    MemberWhite getMemberById(Integer id);

    int updateByPrimaryKeySelective(MemberWhite member, HttpServletRequest request);

    int insertSelective(MemberWhite member);

    int memberDel(Integer id);
}
