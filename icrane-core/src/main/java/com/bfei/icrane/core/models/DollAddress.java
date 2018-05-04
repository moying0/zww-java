package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: perry
 * Version: 1.0
 * Date: 2017/09/25
 * Description: 收货地址实体类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class DollAddress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private Integer id;

	    private String province;//省

	    private String city;//市

	    private String county;//区

	    private String street;//街道

	    private Date createdDate;//创建时间

	    private Date modifiedDate;//修改时间

	    private Boolean defaultFlg;//可用状态

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getProvince() {
	        return province;
	    }

	    public void setProvince(String province) {
	        this.province = province == null ? null : province.trim();
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city == null ? null : city.trim();
	    }

	    public String getCounty() {
	        return county;
	    }

	    public void setCounty(String county) {
	        this.county = county == null ? null : county.trim();
	    }

	    public String getStreet() {
	        return street;
	    }

	    public void setStreet(String street) {
	        this.street = street == null ? null : street.trim();
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

	    public Boolean getDefaultFlg() {
	        return defaultFlg;
	    }

	    public void setDefaultFlg(Boolean defaultFlg) {
	        this.defaultFlg = defaultFlg;
	    }

		@Override
		public String toString() {
			return "MemberAddr [id=" + id + ", province=" + province + ", city=" + city + ", county="
					+ county + ", street=" + street + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
					+ ", defaultFlg=" + defaultFlg + "]";
		}
	    
}
