package com.bfei.icrane.api.service;

import com.bfei.icrane.core.models.WxpayRecord;

public interface WxpayRecordService {

    int insert(WxpayRecord wr);

    WxpayRecord selectByOutTradeNo(String out_trade_no);

}
