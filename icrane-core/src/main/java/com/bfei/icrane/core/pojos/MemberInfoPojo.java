package com.bfei.icrane.core.pojos;

import com.bfei.icrane.core.models.Vip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/10/20
 * Description: 用户常用信息pojo类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoPojo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String gender;
    private String iconRealPath;
    private String memberID;
    private String level;

}
