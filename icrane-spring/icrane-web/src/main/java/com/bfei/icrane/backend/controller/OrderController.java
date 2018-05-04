package com.bfei.icrane.backend.controller;


import com.bfei.icrane.backend.service.ChargeRulesService;
import com.bfei.icrane.backend.service.MemberManageService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.ChargeOrder;
import com.bfei.icrane.core.models.ChargeRules;
import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.service.ChargeOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orderManage")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private ChargeOrderService chargeOrderService;

    @Autowired
    private ChargeRulesService chargeRulesService;

    @RequestMapping("/list")
    public String list( @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="50")Integer pageSize, HttpServletRequest request)throws Exception {
        logger.info("查询充值列表输入参数:name={},page={},pageSize={}",page,pageSize);
        try {
            PageBean<ChargeOrder> pageBean = chargeOrderService.getChargeOrderList(page, pageSize);
            List<ChargeRules> chargeRules = chargeRulesService.selectChargeRules();
            logger.info("查询充值列表结果:{}",pageBean.getList().toString());
            logger.info("查询充值规则列表结果:{}",chargeRules.toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("chargeRules", chargeRules);
            return "user/charge_order_list";
        } catch (Exception e) {
            logger.error("查询充值列表SystemError:"+e);
            throw e;
        }
    }


    @RequestMapping("/searchList")
    public String list(String memberName, String memberId,Integer chargeName, Integer charge_state, String create_date, String endtime, @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="50")Integer pageSize, HttpServletRequest request)throws Exception {
        logger.info("查询充值列表输入参数:name={},page={},pageSize={}",memberName,page,pageSize);
        try {

            if("".equals(memberId)){
                memberId = null;
            }
            if("".equals(memberName)){
                memberName = null;
            }
            if("".equals(chargeName)){
                chargeName = null;
            }
            ChargeRules chargeRule = chargeRulesService.selectByPrimaryKey(chargeName);
            Integer chargeid = null;
            if(chargeRule != null){
                chargeid = chargeRule.getId();
            }
            if("".equals(charge_state)){
                charge_state = null;
            }

            if("".equals(create_date)){
                create_date = null;
            }
            if("".equals(endtime)){
                endtime = null;
            }
            PageBean<ChargeOrder> pageBean = chargeOrderService.selectChargeOrderBy(memberName,memberId,chargeid,charge_state,create_date,endtime,page, pageSize);
            List<ChargeRules> chargeRules = chargeRulesService.selectChargeRules();
            logger.info("查询充值列表结果:{}",pageBean.getList().toString());
            logger.info("查询充值规则列表结果:{}",chargeRules.toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("chargeRules", chargeRules);
            request.setAttribute("memberName", memberName);
            request.setAttribute("memberId", memberId);
            request.setAttribute("chargeName", chargeName);
            request.setAttribute("charge_state", charge_state);
            request.setAttribute("create_date", create_date);
            request.setAttribute("endtime", endtime);
            return "user/charge_order_list";
        } catch (Exception e) {
            logger.error("查询充值列表SystemError:"+e);
            throw e;
        }
    }
}
