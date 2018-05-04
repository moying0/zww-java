package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by SUN on 2018/1/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    //主题类别
    private int topicType;
    //主题名称
    private String topicName;
    //娃娃详情
    private String details;

}