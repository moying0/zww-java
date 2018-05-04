package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.common.util.ResultMap;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.common.util.TimeUtil;
import com.bfei.icrane.core.dao.MemberDao;
import com.bfei.icrane.core.dao.RedeemCodeDao;
import com.bfei.icrane.core.models.*;
import com.bfei.icrane.core.service.AccountService;
import com.bfei.icrane.core.service.ChargeOrderService;
import com.bfei.icrane.core.service.RedeemCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SUN on 2018/1/25.
 */
@Service("RedeemCodeService")
@Transactional
public class RedeemCodeServiceImpl implements RedeemCodeService {

    private static final Logger logger = LoggerFactory.getLogger(RedeemCodeServiceImpl.class);

    @Autowired
    private RedeemCodeDao redeemCodeDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private ChargeOrderService chargeOrderService;
    @Autowired
    private AccountService accountService;

    /**
     * 兑换礼品码
     *
     * @param memberId 用户userId
     * @param cdkey    cdkey
     * @return
     */
    @Override
    public ResultMap getPrize(Integer memberId, String cdkey) {
        // 根据cdkey查询礼品码信息
        RedeemCode redeemCode = redeemCodeDao.selectBycdkey(cdkey);
        // 验证礼品码是否存在
        if (redeemCode != null) {
            // 验证礼品码是否过期
            Date nowDate = new Date();
            if (nowDate.before(redeemCode.getValidStartDate())) {
                // 验证礼品码是否已兑换
                if (redeemCode.isState()) {
                    // 该用户是否兑换过该礼包
                    if (check(cdkey, memberId)) {
                        // 根据memberId查询账户信息
                        Member member = memberDao.selectById(memberId);
                        Account account = member.getAccount();
                        ChargeOrder order = new ChargeOrder();
                        Map<String, Object> map = new HashMap<>();
                        // 兑换
                        // 添加奖励
                        if (redeemCode.getCoins() > 0 || redeemCode.getSuperTicket() > 0) {
                            // 给币
                            order.setOrderNo(cdkey);
                            order.setSuperTicketBefore(account.getSuperTicket());
                            order.setChargeName(redeemCode.getName());
                            order.setMemberId(memberId);
                            order.setMemberName(member.getName());
                            order.setChargeType(-1);
                            order.setChargeState(1);
                            order.setCoinsBefore(account.getCoins());
                            order.setCoinsAfter(account.getCoins() + redeemCode.getCoins());
                            order.setSuperTicketBefore(account.getSuperTicket());
                            order.setSuperTicketAfter(account.getSuperTicket() + redeemCode.getSuperTicket());
                            order.setCreateDate(nowDate);
                            order.setUpdateDate(nowDate);
                            chargeOrderService.createChareOrder(order);
                            Charge charge = new Charge();
                            charge.setMemberId(memberId);
                            charge.setCoins(order.getCoinsBefore());
                            charge.setCoinsSum(redeemCode.getCoins());
                            charge.setPrepaidAmt(order.getPrice());
                            charge.setSuperTicket(order.getSuperTicketBefore());
                            charge.setSuperTicketSum(redeemCode.getSuperTicket());
                            charge.setType("income");
                            charge.setChargeDate(TimeUtil.getTime());
                            charge.setChargeMethod("礼品码兑换-" + order.getChargeName());
                            //保存记录并加币
                            Integer result2 = chargeOrderService.insertChargeHistory(charge);
                            map.put("account", accountService.select(memberId));
                        }
                        if (redeemCode.getWeeksCardTime() > 0) {
                            // 给周卡
                            map.put("account", accountService.select(memberId));
                        }
                        if (redeemCode.getMonthCardTime() > 0) {
                            // 给月卡
                            map.put("account", accountService.select(memberId));
                        }
                        if (StringUtils.isNotEmpty(redeemCode.getDollCode())) {
                            // 给娃娃
                            map.put("doll", accountService.select(memberId));
                        }
                        // 标记已兑换
                        redeemCode.setState(false);
                        // 标记兑换人
                        redeemCode.setGivinger(memberId);
                        // 更新礼品码
                        int result = redeemCodeDao.updateById(redeemCode);
                        if (!redeemCode.isState()) {
                            logger.info("memberId=" + memberId + order.getChargeName() + Enviroment.PRIZE_SUCCESS);
                            return new ResultMap(order.getChargeName() + Enviroment.PRIZE_SUCCESS, map);
                        }
                        // 添加记录
                        logger.info("兑换礼品码成功");
                        return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.PRIZE_FAILE);
                    }
                    logger.info("兑换礼品码失败" + Enviroment.CHECK_FALSE);
                    return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.CHECK_FALSE);
                }
                logger.info("兑换礼品码失败" + Enviroment.THE_CODE_USE_UP);
                return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.THE_CODE_USE_UP);
            }
            logger.info("兑换礼品码失败" + Enviroment.THE_CODE_OVERDUE);
            return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.THE_CODE_OVERDUE);
        }
        logger.info("兑换礼品码失败" + Enviroment.THE_CODE_NOT_EXIST);
        return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.THE_CODE_NOT_EXIST);
    }

    /**
     * 根据礼包cdk和memberID检查用户是否兑换过该礼包
     *
     * @param cdkey
     * @param memberId
     * @return
     */
    private boolean check(String cdkey, Integer memberId) {
        RedeemCode redeemCode = redeemCodeDao.selectBycdkey(cdkey);
        if (redeemCodeDao.selectByNameAndMemberId(redeemCode.getName(), memberId) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insert(String s) {
        RedeemCode redeemCode = new RedeemCode();
        redeemCode.setCdkey(s);
        redeemCode.setCoins(666);
        redeemCode.setSuperTicket(0);
        redeemCode.setWeeksCardTime(0);
        redeemCode.setMonthCardTime(0);
        redeemCode.setValidStartDate(new Date());
        redeemCode.setState(true);
        redeemCode.setGivinger(-1);
        redeemCode.setDollCode("");
        redeemCodeDao.insert(redeemCode);
    }
}
