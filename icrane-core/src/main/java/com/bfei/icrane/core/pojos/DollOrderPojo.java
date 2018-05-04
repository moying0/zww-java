package com.bfei.icrane.core.pojos;

import java.io.Serializable;
import java.sql.Timestamp;

public class DollOrderPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberName;
	private String mobile;
	private String weixinId;
	private String orderNumber;
	private String orderStatus;
	private Timestamp orderDate;
	private Timestamp deliverDate;
	private String province;
	private String city;
	private String county;
	private String street;

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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Timestamp deliverDate) {
		this.deliverDate = deliverDate;
	}

	@Override
	public String toString() {
		return "DollOrderPojo [memberName=" + memberName + ", mobile=" + mobile + ", weixinId=" + weixinId
				+ ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", deliverDate=" + deliverDate + ", province=" + province + ", city=" + city + ", county=" + county
				+ ", street=" + street + "]";
	}

}
