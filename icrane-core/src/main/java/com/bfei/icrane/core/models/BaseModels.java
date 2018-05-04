package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基本模型类
 * Created by SUN on 2018/1/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModels implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;

}