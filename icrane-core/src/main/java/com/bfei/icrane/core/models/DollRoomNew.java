package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/19
 * Description: 娃娃房间持久化类.
 * Copyright (c) 2018 伴飞网络. All rights reserved.
 */
public class DollRoomNew implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;//id

    private String roomNo;//房间编号

    private String roomName;//房间名

    private Integer dollId;//机器id

    private String dollName;//机器名

    private String dollNo;//娃娃编号

    private Date createdDate;//创建时间

    private Date modifiedDate;//修改时间

    private Integer deleteFlg;//删除状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getDollId() {
        return dollId;
    }

    public void setDollId(Integer dollId) {
        this.dollId = dollId;
    }

    public String getDollName() {
        return dollName;
    }

    public void setDollName(String dollName) {
        this.dollName = dollName;
    }

    public String getDollNo() {
        return dollNo;
    }

    public void setDollNo(String dollNo) {
        this.dollNo = dollNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(Integer deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    @Override
    public String toString() {
        return "DollRoomNew [id=" + id + ", roomNo=" + roomNo + ", roomName=" + roomName +
                ", dollId=" + dollId + ", dollName=" + dollName +  ", dollNo=" + dollNo +
                ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", deleteFlg=" + deleteFlg + "]";
    }


}