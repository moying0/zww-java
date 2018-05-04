package com.bfei.icrane.core.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by SUN on 2018/3/15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends BaseModels {

    private String openid;
    //关注时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date concerntime;
    //取消关注时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cancelconcerntime;
    //状态
    private Boolean status;
    //头像路径
    private String headimg;
    //昵称
    private String nickname;
}
