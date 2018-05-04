package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.util.Date;

public class SrvReq implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private Integer id;

	    private String srNumber;

	    private String srType;

	    private String srStatus;

	    private String srContent;

	    private Date createdDate;

	    private Integer createdBy;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getSrNumber() {
	        return srNumber;
	    }

	    public void setSrNumber(String srNumber) {
	        this.srNumber = srNumber == null ? null : srNumber.trim();
	    }

	    public String getSrType() {
	        return srType;
	    }

	    public void setSrType(String srType) {
	        this.srType = srType == null ? null : srType.trim();
	    }

	    public String getSrStatus() {
	        return srStatus;
	    }

	    public void setSrStatus(String srStatus) {
	        this.srStatus = srStatus == null ? null : srStatus.trim();
	    }

	    public String getSrContent() {
	        return srContent;
	    }

	    public void setSrContent(String srContent) {
	        this.srContent = srContent == null ? null : srContent.trim();
	    }

	    public Date getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(Date createdDate) {
	        this.createdDate = createdDate;
	    }

	    public Integer getCreatedBy() {
	        return createdBy;
	    }

	    public void setCreatedBy(Integer createdBy) {
	        this.createdBy = createdBy;
	    }

		@Override
		public String toString() {
			return "SrvReq [id=" + id + ", srNumber=" + srNumber + ", srType=" + srType + ", srStatus=" + srStatus
					+ ", srContent=" + srContent + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
		}
	    
}
