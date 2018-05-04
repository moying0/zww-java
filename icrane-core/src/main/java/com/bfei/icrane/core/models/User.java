package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: 管理后台账户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String mobile;
	private String password;
	private Timestamp created_date;
	private int created_by;
	private Timestamp modified_date;
	private int modified_by;
	private Timestamp last_login_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public Timestamp getModified_date() {
		return modified_date;
	}
	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}
	public int getModified_by() {
		return modified_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	public Timestamp getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + ", password=" + password + ", created_date="
				+ created_date + ", created_by=" + created_by + ", modified_date=" + modified_date + ", modified_by="
				+ modified_by + ", last_login_date=" + last_login_date + "]";
	}
	
	
}
