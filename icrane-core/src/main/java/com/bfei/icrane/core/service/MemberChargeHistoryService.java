package com.bfei.icrane.core.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.ChargeOrder;
import com.bfei.icrane.core.models.MemberChargeHistory;

/**
 * Created by webrx on 2017-11-30.
 */
public interface MemberChargeHistoryService {

    /**
     * 查询订单list
     */
    PageBean<MemberChargeHistory> getMemberChargeHistoryList(String memberId, int page, int pageSize);
}
