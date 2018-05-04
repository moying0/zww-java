package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by SUN on 2018/2/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DivinationTopic extends BaseModels {

    private String divinationName;//预测名称
    private Date createdDate;//创建时间
    private int createdBy;//创建人
    private Date modifiedDate;//修改时间
    private int modifiedBy;//修改人
    private String modeUrl;//图片地址
    private int wxpireTime;//图片地址

}
