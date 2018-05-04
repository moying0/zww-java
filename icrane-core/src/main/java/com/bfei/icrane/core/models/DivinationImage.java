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
public class DivinationImage extends BaseModels {

    private String divinationTopicImg;//占卜主题图片
    private long divinationTopicId;//占卜主题id
    private String divinationName;//占卜主题名称
    private Date created_date;//创建时间
    private int created_by;//创建人
    private Date modified_date;//修改时间
    private int modified_by;//修改人

}
