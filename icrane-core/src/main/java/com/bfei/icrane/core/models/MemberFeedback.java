package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.util.Date;

public class MemberFeedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private Integer createdBy;

    private String srNumber;

    private String srType;

    private String srStatus;

    private String srContent;

    private Date createdDate;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}

	public String getSrType() {
		return srType;
	}

	public void setSrType(String srType) {
		this.srType = srType;
	}

	public String getSrStatus() {
		return srStatus;
	}

	public void setSrStatus(String srStatus) {
		this.srStatus = srStatus;
	}

	public String getSrContent() {
		return srContent;
	}

	public void setSrContent(String srContent) {
		this.srContent = srContent;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", createdBy=" + createdBy + ", srNumber=" + srNumber + ", srType="
				+ srType + ", srStatus=" + srStatus + ", srContent=" + srContent + ", createdDate=" + createdDate
				+ "]";
	}

}
