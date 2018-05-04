package com.bfei.icrane.core.models.vo;

import java.io.Serializable;
import java.util.Date;

public class MemberFeedbackAll implements Serializable{

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

	private String memberId;

	private String name;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", createdBy=" + createdBy + ", srNumber=" + srNumber + ", srType="
				+ srType + ", srStatus=" + srStatus + ", srContent=" + srContent + ", createdDate=" + createdDate
				+ ", memberId=" + memberId + ", name=" + name +"]";
	}

}
