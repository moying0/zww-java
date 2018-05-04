package com.bfei.icrane.api.controller;

import com.bfei.icrane.api.service.*;
import com.bfei.icrane.common.util.*;
import com.bfei.icrane.core.service.ValidateTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SUN on 2018/1/9.
 */
@Controller
@RequestMapping("/pay")
@CrossOrigin
public class AppPayController {
    /*private static final Logger logger = LoggerFactory.getLogger(WxPayController.class);

    @Autowired
    private ValidateTokenService validateTokenService;
    @Autowired
    private PayService payService;//订单服务

    *//**
     * 微信支付
     *//*
    @RequestMapping(value = "/appPay", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap wxPay(HttpServletRequest request, Integer chargeruleid, Integer memberId,
                           String token, String head) throws Exception {
        try {
            logger.info("统一支付接口参数:规则id" + chargeruleid + ", memberId=" + memberId + ", token=" + token);
            if (chargeruleid == null || memberId == null || token == null || head == null || "".equals(chargeruleid) || "".equals(memberId) || "".equals(token) || "".equals(head)) {
                logger.info("统一支付接口参数异常=" + Enviroment.RETURN_INVALID_PARA_MESSAGE);
                return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE1, Enviroment.RETURN_INVALID_PARA_MESSAGE);
            }
            //验证token
            if (!validateTokenService.validataToken(token, memberId)) {
                logger.info("统一支付接口参数异常=" + Enviroment.RETURN_UNAUTHORIZED_MESSAGE);
                return new ResultMap(Enviroment.RETURN_FAILE_CODE, Enviroment.RETURN_UNAUTHORIZED_MESSAGE);
            }
            if ("wx".equals(head)) {
                return payService.wxpay(request, memberId, chargeruleid);
            } else if ("ali".equals(head)) {
                return payService.alipay(memberId, chargeruleid);
            } else {
                logger.info("统一支付接口参数异常=" + Enviroment.RETURN_INVALID_PARA_MESSAGE + "head不能为" + head);
                return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE1, Enviroment.RETURN_INVALID_PARA_MESSAGE);
            }
        } catch (Exception e) {
            logger.info("统一支付接口参数异常=" + e.getMessage());
            return new ResultMap(Enviroment.ERROR_CODE, Enviroment.PAY_ERROR);
        }
    }*/
}