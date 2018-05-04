package com.bfei.icrane.api.service;

import com.bfei.icrane.common.util.ResultMap;

/**
 * Created by SUN on 2018/1/17.
 */
public interface MemberChargeComboService {

    /**
     * 周卡领取
     *
     * @param memberId
     * @return
     */
    ResultMap weeksCombo(Integer memberId);

    /**
     * 月卡领取
     *
     * @param memberId
     * @return
     */
    ResultMap monthCombo(Integer memberId);

}
