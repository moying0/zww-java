package com.bfei.icrane.core.models;

import java.util.Date;

public class DollImage {
	private Integer id;

    private String imgContextPath;

    private String imgFileName;

    private String imgRealPath;

    private Date createdDate;

    private Integer createdBy;

    private Date modifiedDate;

    private Integer modifiedBy;
    
    private Doll doll;

    public Doll getDoll() {
		return doll;
	}

	public void setDoll(Doll doll) {
		this.doll = doll;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgContextPath() {
        return imgContextPath;
    }

    public void setImgContextPath(String imgContextPath) {
        this.imgContextPath = imgContextPath == null ? null : imgContextPath.trim();
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName == null ? null : imgFileName.trim();
    }

    public String getImgRealPath() {
        return imgRealPath;
    }

    public void setImgRealPath(String imgRealPath) {
        this.imgRealPath = imgRealPath == null ? null : imgRealPath.trim();
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
