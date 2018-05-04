package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: APP用户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DollRepairs implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;//id
    private Integer userId;//用户id
    private Integer dollId;//娃娃机id
    private String repairsReason;//报修原因
    private Date createDate;//创建时间
    private Date modifyDate;//修改时间


}
