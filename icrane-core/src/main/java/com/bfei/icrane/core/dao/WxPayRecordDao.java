package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.WxpayRecord;

/**
 * 
 * @ClassName: WxPayRecordDao 
 * @Description: 微信支付记录Dao
 * @author perry 
 * @date 2017年10月11日 下午1:43:49 
 * @version V1.0
 */
public interface WxPayRecordDao {
	int insert(WxpayRecord wr);

    WxpayRecord selectByOutTradeNo(String out_trade_no);

}
