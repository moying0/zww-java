package com.bfei.icrane.weixin.service;


import com.bfei.icrane.core.models.XmlMessageEntity;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface IWeixinService {

    //传入xml对象,返回给用户对应信息
    XmlMessageEntity getBackEntity(XmlMessageEntity entity) throws Exception;

    String checkSignature(String signature, String timestamp, String nonce, String echostr);

    String getBackEntityMiniApps(JSONObject entity) throws Exception;
}
