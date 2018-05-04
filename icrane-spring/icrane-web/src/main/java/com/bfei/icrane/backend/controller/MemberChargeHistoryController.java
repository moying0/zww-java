package com.bfei.icrane.backend.controller;


import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.MemberChargeHistory;
import com.bfei.icrane.core.service.MemberChargeHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/memberChargeManage")
public class MemberChargeHistoryController {
    private static final Logger logger = LoggerFactory.getLogger(MemberChargeHistoryController.class);

    @Autowired
    private MemberChargeHistoryService memberChargeHistoryService;

    @RequestMapping("/list")
    public String list(String memberId, @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="50")Integer pageSize, HttpServletRequest request)throws Exception {
        logger.info("查询交易记录输入参数:name={},page={},pageSize={}",memberId,page,pageSize);
        try {

            PageBean<MemberChargeHistory> pageBean = memberChargeHistoryService.getMemberChargeHistoryList(memberId,page, pageSize);
            logger.info("查询交易记录列表结果:{}",pageBean.getList().toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("memberId", memberId);
            return "user/user_charge_history_list";
        } catch (Exception e) {
            logger.error("查询交易记录列表SystemError:"+e);
            throw e;
        }
    }
}
