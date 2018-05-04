package com.bfei.icrane.core.models.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃机持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class DollMachineStatistics implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;//机器id

    private String machineCode;//机器编号

    private String machineUrl;//机器名称

    private String name;//娃娃名称

    private String dollID;//娃娃编号

    private Date catchDate;//抓取时间

    private Integer historyId;//抓取历史id

    private Integer gameNum;//游戏次数

    private Integer catchNum;//抓中次数

    private Double catchRatio;//抓取率



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getMachineUrl() {
        return machineUrl;
    }

    public void setMachineUrl(String machineUrl) {
        this.machineUrl = machineUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDollID() {
        return dollID;
    }

    public void setDollID(String dollID) {
        this.dollID = dollID;
    }


    public Date getCatchDate() {
        return catchDate;
    }

    public void setCatchDate(Date catchDate) {
        this.catchDate = catchDate;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getGameNum() {
        return gameNum;
    }

    public void setGameNum(Integer gameNum) {
        this.gameNum = gameNum;
    }

    public Integer getCatchNum() {
        return catchNum;
    }

    public void setCatchNum(Integer catchNum) {
        this.catchNum = catchNum;
    }

    public Double getCatchRatio() {
        return catchRatio;
    }

    public void setCatchRatio(Double catchRatio) {
        this.catchRatio = catchRatio;
    }

    @Override
	public String toString() {
		return "Doll [id=" + id + ", machineCode=" + machineCode +", machineUrl=" + machineUrl +", name=" + name +
                ",dollID="+dollID+ ", catchDate=" + catchDate +", historyId=" + historyId +", gameNum=" + gameNum +
                ", catchNum=" + catchNum +", catchRatio=" + catchRatio +"]";
	}
	
	
}