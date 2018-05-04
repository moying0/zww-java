package com.bfei.icrane.core.models;

import java.util.Date;

public class TModifyRecord {
    private Integer id;

    private Integer memberId; //用户id（userId）

    private Integer coins; //金币

    private Integer superTicket; //强爪券

    private Date modifiedDate; //修改时间

    private Integer modifiedBy; //修改人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getSuperTicket() {
        return superTicket;
    }

    public void setSuperTicket(Integer superTicket) {
        this.superTicket = superTicket;
    }

}