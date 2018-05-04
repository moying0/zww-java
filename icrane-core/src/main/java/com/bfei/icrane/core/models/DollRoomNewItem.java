package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/26
 * Description: 娃娃房间机器关联表持久层.
 * Copyright (c) 2018 伴飞网络. All rights reserved.
 */
public class DollRoomNewItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer dollRoomId;
	private Integer dollId;
	private Date createdDate;
	private Date modifiedDate;
	private Integer deleteFlg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDollRoomId() {
		return dollRoomId;
	}

	public void setDollRoomId(Integer dollRoomId) {
		this.dollRoomId = dollRoomId;
	}

	public Integer getDollId() {
		return dollId;
	}

	public void setDollId(Integer dollId) {
		this.dollId = dollId;
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
		return "DollOrderItem [id=" + id + ", dollRoomId=" + dollRoomId +
				", dollRoomId=" + dollRoomId +  ", dollId=" + dollId +
				", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate +
				", deleteFlg=" + deleteFlg +"]";
	}
    
}