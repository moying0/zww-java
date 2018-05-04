package com.bfei.icrane.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TAppVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String appKey;

    private String version;

    private String upgradeUrl;

    private String content;

    private String hideFlg;

    private int forceUpdate;

    private int openUpdate;

}