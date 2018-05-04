package com.bfei.icrane.core.models.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: APP用户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class DollRepairsAll implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//id
	private Integer userId;//用户id
	private String memberID;//用户编号
	private String name;//用户名
	private Integer dollId;//娃娃机id
	private String dollName;//机器名
	private String tbimgRealPath;//娃娃机头像
	private String machineCode;//机器号
	private String machineStatus;//机器状态
	private String province;//机器 省
	private String city;//机器 市
	private String county;//机器 区
	private String street;//机器 街
	private String repairsReason;//报修原因
	private Date createDate;//创建时间
	private Date modifyDate;//修改时间


	public Integer getId() {
		return id;
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

	public Integer getDollId() {
		return dollId;
	}

	public void setDollId(Integer dollId) {
		this.dollId = dollId;
	}

	public String getRepairsReason() {
		return repairsReason;
	}

	public void setRepairsReason(String repairsReason) {
		this.repairsReason = repairsReason;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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

	public String getDollName() {
		return dollName;
	}

	public void setDollName(String dollName) {
		this.dollName = dollName;
	}

	public String getTbimgRealPath() {
		return tbimgRealPath;
	}

	public void setTbimgRealPath(String tbimgRealPath) {
		this.tbimgRealPath = tbimgRealPath;
	}

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public String getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", dollId=" + dollId +
				", repairsReason=" + repairsReason +
				", userId=" + userId +
				", memberID=" + memberID +
				", name=" + name +
				", dollName=" + dollName +
				", tbimgRealPath=" + tbimgRealPath +
				", machineCode=" + machineCode +
				", machineStatus=" + machineStatus +
				", province=" + province +
				", city=" + city +
				", county=" + county +
				", street=" + street +
				", modifyDate=" + modifyDate +
				", createDate=" + createDate +
				"]";
	}
	
	
}
