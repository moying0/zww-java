package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.ResultMap;

/**
 * Created by SUN on 2018/1/25.
 */
public interface RedeemCodeService {

    /**
     * 兑换礼品码
     *
     * @param memberId 用户userId
     * @param cdkey    cdkey
     * @return
     */
    ResultMap getPrize(Integer memberId, String cdkey);

    void insert(String s);
}
