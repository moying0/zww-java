package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.MemberChargeHistoryDao;
import com.bfei.icrane.core.dao.MemberDao;
import com.bfei.icrane.core.models.ChargeOrder;
import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.models.MemberChargeHistory;
import com.bfei.icrane.core.service.MemberChargeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by webrx on 2017-11-30.
 */
@Service("MemberChargeHistoryService")
public class MemberChargeHistoryServiceImpl implements MemberChargeHistoryService{

    @Autowired
    MemberChargeHistoryDao memberChargeHistoryDao;
    @Autowired
    MemberDao memberDao;

    @Override
    public PageBean getMemberChargeHistoryList(String memberId, int page, int pageSize) {
        PageBean<Object> pageBean = new PageBean<Object>();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        Integer userId = null;
        Member member = memberDao.selectByMemberID(memberId);
        if (member != null){
            userId = member.getId();
        }
        totalCount=memberChargeHistoryDao.totalCount(userId);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page - 1) * pageSize;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Object> pageList = new ArrayList<Object>();
        List<MemberChargeHistory> list = memberChargeHistoryDao.selectChargeOrderList(userId,begin, pageSize);
        for (MemberChargeHistory memberChargeHistory:list) {
            Member members = memberDao.getAllInfoById(memberChargeHistory.getMemberId());
            Map<String,Object> map =new HashMap<String,Object>();
            if (members !=null ){
                map.put("memberId",members.getMemberID());
            }
            map.put("id",String.valueOf(memberChargeHistory.getId()));
            map.put("prepaidAmt",String.valueOf(memberChargeHistory.getPrepaidAmt()));
            map.put("coins",String.valueOf(memberChargeHistory.getCoins()));
            map.put("type",String.valueOf(memberChargeHistory.getType()));
            map.put("chargeDate",sdf.format(memberChargeHistory.getChargeDate()));
            map.put("chargeMethod",memberChargeHistory.getChargeMethod());
            map.put("dollId",String.valueOf(memberChargeHistory.getDollId()));
            map.put("coinsBefore",String.valueOf(memberChargeHistory.getCoinsBefore()));
            map.put("coinsAfter",String.valueOf(memberChargeHistory.getCoinsAfter()));
            pageList.add(map);
        }
        pageBean.setList(pageList);
        int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
        int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
        pageBean.setStart(start);
        pageBean.setEnd(end);
        return pageBean;
    }
}
