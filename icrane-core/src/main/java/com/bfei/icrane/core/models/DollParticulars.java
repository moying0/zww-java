package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 娃娃详情类
 * Created by SUN on 2018/1/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DollParticulars implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String size;
    private String type;
    private String note;

}
