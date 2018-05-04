package com.bfei.icrane.core.models.vo;

import java.io.Serializable;

import java.util.Date;

/**
 * Created by webrx on 2017-12-08.
 */
public class OutGoods implements Serializable {

    private static final long serialVersionUID = 1L;



    private Integer id;

    private String orderNumber;

    private String addrName;

    private String addrPhone;


    private String addrProvince;

    private String addrCity;

    private String addrCounty;
    private String street;

    private String memberId;

    private String addrProvince1;

    private String addrCity1;

    private String addrCounty1;
    private String street1;

    private String deliverMethod;

    private String deliverNumber;

    private Date deliverDate;

    private Date modifiedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone;
    }

    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrCounty() {
        return addrCounty;
    }

    public void setAddrCounty(String addrCounty) {
        this.addrCounty = addrCounty;
    }

    public String getAddrProvince1() {
        return addrProvince1;
    }

    public void setAddrProvince1(String addrProvince1) {
        this.addrProvince1 = addrProvince1;
    }

    public String getAddrCity1() {
        return addrCity1;
    }

    public void setAddrCity1(String addrCity1) {
        this.addrCity1 = addrCity1;
    }

    public String getAddrCounty1() {
        return addrCounty1;
    }

    public void setAddrCounty1(String addrCounty1) {
        this.addrCounty1 = addrCounty1;
    }

    public String getDeliverMethod() {
        return deliverMethod;
    }

    public void setDeliverMethod(String deliverMethod) {
        this.deliverMethod = deliverMethod;
    }

    public String getDeliverNumber() {
        return deliverNumber;
    }

    public void setDeliverNumber(String deliverNumber) {
        this.deliverNumber = deliverNumber;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "DollOrder [id=" + id + ", orderNumber=" + orderNumber + ", memberId=" + memberId +
                ", addrName=" + addrName + ", addrPhone=" + addrPhone
                + ", addrProvince=" + addrProvince + ", addrCity=" + addrCity + ", addrCounty=" + addrCounty
                + ", addrProvince1=" + addrProvince1 + ", addrCity1=" + addrCity1 + ", addrCounty1=" + addrCounty1
                + ", deliverDate=" + deliverDate + ", deliverMethod=" + deliverMethod + ", deliverNumber=" + deliverNumber + ", modifiedDate=" + modifiedDate + "]";
    }
}
