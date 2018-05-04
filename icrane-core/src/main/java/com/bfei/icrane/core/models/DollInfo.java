package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃机持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DollInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String dollName;//娃娃名称
    private Integer dollTotal;//娃娃数量
    private String imgUrl;//图片网址
    private Date addTime;//添加时间
    private String dollCode;//娃娃编号
    private boolean online;//在线状态

}