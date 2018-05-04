package com.bfei.icrane.core.models;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMessageEntity {

    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private String Content;
    private String Event;
    private String EventKey;
    private Long MsgId;
    private String MediaId;
}