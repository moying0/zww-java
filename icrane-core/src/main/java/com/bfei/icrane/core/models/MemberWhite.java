package com.bfei.icrane.core.models;

import java.io.Serializable;

import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: APP用户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class MemberWhite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private String memberId;
	private String userName;
	private String userIP;
	private Integer states;
	private Date createdDate;
	private Date modifiedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIP() {
		return userIP;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStates() {
		return states;
	}

	public void setStates(Integer states) {
		this.states = states;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", userId=" + userId + ", memberId=" + memberId + ", userName=" + userName + ", userIP="
				+ userIP + ", states=" + states + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate  +"]";
	}

}
