package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by SUN on 2018/3/2.
 * 用户风控信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskManagement extends BaseModels {

    private Integer userId;
    private String IMEI1;
    private String IMEI2;
    private String IMEI3;
    private String IP1;
    private String IP2;
    private String IP3;

}
