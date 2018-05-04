package com.bfei.icrane.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.common.util.RedisUtil;
import com.bfei.icrane.common.util.ResultMap;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.service.RedeemCodeService;
import com.bfei.icrane.core.service.ValidateTokenService;

/**
 * Created by SUN on 2018/1/10.
 * 礼品码控制器
 */
@Controller
@RequestMapping(value = "/redeemCode")
@CrossOrigin
public class RedeemCodeController {

    private static final Logger logger = LoggerFactory.getLogger(RedeemCodeController.class);

    @Autowired
    private RedeemCodeService redeemCodeService;
    @Autowired
    private ValidateTokenService validateTokenService;

    /**
     * 兑换礼品码
     *
     * @param memberId
     * @param token
     * @return
     */
    @RequestMapping(value = "/prize", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap prize(Integer memberId, String token, String cdkey) {
        try {
            logger.info("兑换礼品码接口参数:memberId=" + memberId + ",token=" + token);
            //验证参数
            if (memberId == null || StringUtils.isEmpty(token) || StringUtils.isEmpty(cdkey)) {
                logger.info("兑换礼品码接口参数异常=" + Enviroment.RETURN_INVALID_PARA_MESSAGE);
                return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE1, Enviroment.RETURN_INVALID_PARA_MESSAGE);
            }
            //访问间隔限制
            RedisUtil redisUtil = new RedisUtil();
            if (redisUtil.getString("prize" + memberId) != null || redisUtil.getString("prize" + cdkey) != null) {
                logger.info("兑换礼品码失败=" + Enviroment.PLEASE_PRIZE_DOWN);
                return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE1, Enviroment.PLEASE_PRIZE_DOWN);
            }
            //加锁
            redisUtil.setString("prize" + memberId, "", Enviroment.PRIZE_CONTROL_TIME);
            redisUtil.setString("prize" + cdkey, "", Enviroment.PRIZE_CONTROL_TIME);
            //验证token
            if (!validateTokenService.validataToken(token, memberId)) {
                logger.info("兑换礼品码接口参数异常=" + Enviroment.RETURN_UNAUTHORIZED_MESSAGE);
                return new ResultMap(Enviroment.RETURN_FAILE_CODE, Enviroment.RETURN_UNAUTHORIZED_MESSAGE);
            }
            return redeemCodeService.getPrize(memberId, cdkey);
        } catch (Exception e) {
            logger.error("兑换礼品码接口参数异常=" + e.getMessage());
            e.printStackTrace();
            return new ResultMap(Enviroment.ERROR_CODE, Enviroment.HAVE_ERROR);
        }
    }
}
