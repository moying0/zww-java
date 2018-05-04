package com.bfei.icrane.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.WxpayRecordService;
import com.bfei.icrane.core.dao.WxPayRecordDao;
import com.bfei.icrane.core.models.WxpayRecord;

/**
 * @author perry
 * @version V1.0
 * @ClassName: WxpayRecordServiceImpl
 * @Description: 微信支付记录Service实现
 * @date 2017年10月11日 下午1:49:46
 */
@Service("WxpayRecordService")
public class WxpayRecordServiceImpl implements WxpayRecordService {
    private static final Logger logger = LoggerFactory.getLogger(WxpayRecordServiceImpl.class);
    @Autowired
    private WxPayRecordDao wxpayRecordDao;

    @Override
    public int insert(WxpayRecord wr) {
        logger.info("insert 参数wr:{}", wr);
        return wxpayRecordDao.insert(wr);
    }

    @Override
    public WxpayRecord selectByOutTradeNo(String out_trade_no) {
        return wxpayRecordDao.selectByOutTradeNo(out_trade_no);
    }

}
