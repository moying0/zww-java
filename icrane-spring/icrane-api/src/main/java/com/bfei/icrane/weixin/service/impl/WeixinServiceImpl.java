package com.bfei.icrane.weixin.service.impl;


import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.bfei.icrane.common.util.HttpUtil;
import com.bfei.icrane.common.util.RobotUtil;
import com.bfei.icrane.common.util.SampleUtil;
import com.bfei.icrane.common.util.WXUtil;
import com.bfei.icrane.common.wx.utils.Sha1Util;
import com.bfei.icrane.common.wx.utils.WxConfig;
import com.bfei.icrane.core.models.Client;
import com.bfei.icrane.core.models.MessageLoging;
import com.bfei.icrane.core.models.XmlMessageEntity;
import com.bfei.icrane.weixin.service.IClientService;
import com.bfei.icrane.weixin.service.IMessageService;
import com.bfei.icrane.weixin.service.IWeixinService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class WeixinServiceImpl implements IWeixinService {
    @Autowired
    private IClientService clientService;
    @Autowired
    private IMessageService messageService;


    @Override
    public XmlMessageEntity getBackEntity(XmlMessageEntity entity) {
        try {
            //        创建一个消息对象保存记录
            MessageLoging messageLoging = new MessageLoging();
            Client client;

            XmlMessageEntity newEntity = new XmlMessageEntity();
            newEntity.setToUserName(entity.getFromUserName());
            newEntity.setFromUserName(entity.getToUserName());
            newEntity.setMsgType("text");
            newEntity.setCreateTime(System.currentTimeMillis() / 1000);

            if ("event".equals(entity.getMsgType())) {
                String reuslt = HttpUtil.get(WXUtil.GET_USERINFO_URL.replace("ACCESS_TOKEN", WXUtil.getAccessToken())
                        .replace("OPENID", entity.getFromUserName()));
                JSONObject jsonObject = JSONObject.fromObject(reuslt);
                String openid = jsonObject.getString("openid");
                if ("subscribe".equals(entity.getEvent())) {
                    //调用接口获取用户详细信息
                    //创建客户信息，保存到数据库
                    client = new Client();
                    client.setConcerntime(new Date());
                    client.setHeadimg(jsonObject.getString("headimgurl"));
                    client.setNickname(jsonObject.getString("nickname"));
                    client.setOpenid(openid);
                    client.setStatus(true);
                    if (clientService.selectByOpenId(openid) == null) {
                        clientService.insert(client);
                    } else {
                        clientService.updateByPrimaryKey(client);
                    }
                    //回复内容
                    Properties prop = new Properties();


                    InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("concernReply.properties");
                    prop.load(new InputStreamReader(in, "utf-8"));
                    //获取
                    String concernReply = prop.getProperty("concernReply");
                    in.close();
                    newEntity.setContent("亲爱的" + client.getNickname() + concernReply);


                } else if ("unsubscribe".equals(entity.getEvent())) {
                    //更新客户状态,设置为取消关注
                    clientService.deleteByFromUserName(entity.getFromUserName());
                } else if ("CLICK".equals(entity.getEvent())) {
                    //如果是sendTemplate,则发送模板
                    if ("sendTemplate".equals(entity.getEventKey())) {
                        //                 Template t = new Template();
                        //                   t.setTouser(openid);
                        //                   t.setTemplate_id("sqYWSCcMi-MBqDYYVChLUSp_kulLGeAPmFNkMM8XKdw");
                        //                   Data data = new Data();
                        //                   data.setFirst(new Value("您已成功购买",null));
                        //                   data.setKeyword1(new Value("123",null));
                        //                   data.setKeyword2(new Value("41212",null));
                        //                   data.setKeyword3(new Value("41212",null));
                        //                   data.setRemark(new Value("4112311212",null));
                        //                   t.setData(data);
                        //                   HttpUtil.post(WXUtil.SEND_TEMPLATE_URL.replace("ACCESS_TOKEN",WXUtil.getAccessToken()),JSON.toJSONString(t));*//*
                    }
                }
            } else if ("text".equals(entity.getMsgType())) {
                //保存消息
                client = clientService.selectByOpenId(entity.getFromUserName());
                messageLoging.setClient(client);
                messageLoging.setInMessage(entity.getContent());

                String robot = RobotUtil.Robot(entity.getContent());
                newEntity.setContent("小抓：" + robot);

            } else if ("voice".equals(entity.getMsgType())) {
                //            保存消息
                client = clientService.selectByOpenId(entity.getFromUserName());
                messageLoging.setClient(client);
                String doem = SampleUtil.doem(entity, newEntity);
                messageLoging.setInMessage(doem);
                newEntity.setContent("用户：" + doem + "，\n小抓：" + RobotUtil.Robot(doem));
            }

            if (!"event".equals(entity.getMsgType())) {
                messageLoging.setOutMessage(newEntity.getContent());
                messageLoging.setMessageTime(new Date());
                messageService.insert(messageLoging);
            }
            //System.out.println(newEntity);
            return newEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getBackEntityMiniApps(JSONObject entity) throws Exception {
        //System.out.println(entity);
        //获取access_token
        String accessToken = WXUtil.getMiniAppsAccessToken();

        //发送模版消息给指定用户
        String action = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;

        //创建一个消息对象保存记录
        MessageLoging messageLoging = new MessageLoging();
        Client client;

        XmlMessageEntity newEntity = new XmlMessageEntity();
        String ToUserName = entity.get("ToUserName").toString();
        String FromUserName = entity.get("FromUserName").toString();
        long CreateTime = System.currentTimeMillis() / 1000;
        String MsgType = entity.get("MsgType").toString();
        String Content = null;
        if (entity.has("Content")) {
            Content = entity.get("Content").toString();
        }
        String MsgId = null;
        if (entity.has("MsgId")) {
            MsgId = entity.get("MsgId").toString();
        }
        String Event = null;
        if (entity.has("Event")) {
            Event = entity.get("Event").toString();
        }
        newEntity.setMsgType("text");
        JSONObject jsonObject = null;
        if ("event".equals(MsgType)) {
            if ("user_enter_tempsession".equals(Event)) {
//                String robot = "{\n" +
//                        "    \"touser\":\"" + FromUserName + "\",\n" +
//                        "    \"msgtype\":\"text\",\n" +
//                        "    \"text\":\n" +
//                        "    {\n" +
//                        "         \"content\":\"欢迎光临\"\n" +
//                        "    }\n" +
//                        "}";
//                jsonObject = JSONObject.fromObject(robot);
//                String result = WXUtil.sendPost(action, jsonObject.toString());
                String robot = "{\n" +
                        "\n" +
                        "    \"touser\": \"" + FromUserName + "\",\n" +
                        "    \"msgtype\": \"link\",\n" +
                        "    \"link\": {\n" +
                        "          \"title\": \"网搜抓娃娃\",\n" +
                        "          \"description\": \"给朕来抓\",\n" +
                        "          \"url\": \"https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxConfig.GZHAPPID+"&redirect_uri=http%3A%2F%2Flanao.nat300.top/icrane/api/h5login&response_type=code&scope=snsapi_userinfo&state=weixin&connect_redirect=1#wechat_redirect\",\n" +
                        "          \"thumb_url\": \"http://zww-image-dev.oss-cn-shanghai.aliyuncs.com/fa338152-e5e4-401d-9ea9-b06fdba7db17.jpg?Expires=5122493966&OSSAccessKeyId=LTAIR9bpEjEQwnHO&Signature=dsYX6mBF6tDZaZTg%2FFvDlU6waKo%3D\"\n" +
                        "    }\n" +
                        "}";
                jsonObject = JSONObject.fromObject(robot);
            }
        } else if ("text".equals(MsgType)) {
            String robot = "{\n" +
                    "    \"touser\":\"" + FromUserName + "\",\n" +
                    "    \"msgtype\":\"text\",\n" +
                    "    \"text\":\n" +
                    "    {\n" +
                    "         \"content\":\"" + RobotUtil.Robot(Content) + "\"\n" +
                    "    }\n" +
                    "}";
            jsonObject = JSONObject.fromObject(robot);
        } else if ("voice".equals(MsgType)) {
            //            保存消息
           /* client = clientService.selectByOpenId(entity.getFromUserName());
            messageLoging.setClient(client);
            String doem = SampleUtil.doem(entity, newEntity);
            messageLoging.setInMessage(doem);
            newEntity.setContent("用户：" + doem + "，\n小抓：" + RobotUtil.Robot(doem));*/
        }


        try {
            String result = WXUtil.sendPost(action, jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
        //加密/校验流程如下：
        String[] arr = {WxConfig.GZHTOKEN, timestamp, nonce};
        //1）将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        String str = "";
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        for (String temp : arr) {
            str += temp;
        }
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (signature.equals(Sha1Util.getSha1(str))) {
            System.out.println("接入成功！");
            return echostr;
        }
        System.out.println("接入失败！");
        return null;
    }
}
