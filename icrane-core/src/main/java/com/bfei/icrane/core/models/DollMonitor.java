package com.bfei.icrane.core.models;

import java.util.Date;

public class DollMonitor {
    private Integer id;

    private Integer dollid;

    private String alertType;

    private Integer alertNumber;

    private String description;

    private Date createdDate;

    private Integer createdBy;

    private Date modifiedDate;

    private Integer modifiedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDollid() {
        return dollid;
    }

    public void setDollid(Integer dollid) {
        this.dollid = dollid;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType == null ? null : alertType.trim();
    }

    public Integer getAlertNumber() {
        return alertNumber;
    }

    public void setAlertNumber(Integer alertNumber) {
        this.alertNumber = alertNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
}