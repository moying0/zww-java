package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: APP用户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class MemberChannelDeduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private Integer userId;//用户id
	private String memberID;//用户编号
	private String name;//用户名
	private String mobile;//手机
	private String weixinId;//微信
	private String gender;//性别
	private Timestamp registerDate;//注册时间
	private Timestamp lastLoginDate;//最近登录时间
	private String registerFrom;//注册设备
	private String lastLoginFrom;//登录设备
	private String registerChannel;//注册渠道号
	private String loginChannel;//登陆渠道号
	private String phoneModel;//手机机型
	private boolean onlineFlg;//是否在线 0：登录成功 1：登录失败

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
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

	public String getWeixinId() {
		return weixinId;
	}

	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getRegisterFrom() {
		return registerFrom;
	}

	public void setRegisterFrom(String registerFrom) {
		this.registerFrom = registerFrom;
	}

	public String getLastLoginFrom() {
		return lastLoginFrom;
	}

	public void setLastLoginFrom(String lastLoginFrom) {
		this.lastLoginFrom = lastLoginFrom;
	}

	public String getRegisterChannel() {
		return registerChannel;
	}

	public void setRegisterChannel(String registerChannel) {
		this.registerChannel = registerChannel;
	}

	public String getLoginChannel() {
		return loginChannel;
	}

	public void setLoginChannel(String loginChannel) {
		this.loginChannel = loginChannel;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public boolean isOnlineFlg() {
		return onlineFlg;
	}

	public void setOnlineFlg(boolean onlineFlg) {
		this.onlineFlg = onlineFlg;
	}

	@Override
	public String toString() {

		return "MemberChannelDeduct [id=" + id + ", memberID=" + memberID + ", name=" + name +
				", mobile=" + mobile + ", weixinId=" + weixinId + ", gender=" + gender +
				", registerDate=" + registerDate + ", onlineFlg=" + onlineFlg + ", lastLoginDate=" + lastLoginDate +
				",registerChannel="+registerChannel+"]";

	}
	
	
}
