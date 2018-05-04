package com.bfei.icrane.core.pojos;

import java.io.Serializable;

public class DollImgPojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgContextPath;
	private String imgFileName;
	private String imgRealPath;
	private Integer dollId;
	
	
	public String getImgRealPath() {
		return imgRealPath;
	}
	public void setImgRealPath(String imgRealPath) {
		this.imgRealPath = imgRealPath;
	}
	public Integer getDollId() {
		return dollId;
	}
	public void setDollId(Integer dollId) {
		this.dollId = dollId;
	}
	public String getImgContextPath() {
		return imgContextPath;
	}
	public void setImgContextPath(String imgContextPath) {
		this.imgContextPath = imgContextPath;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	@Override
	public String toString() {
		return "DollImgPojo [imgContextPath=" + imgContextPath + ", imgFileName=" + imgFileName + ", imgRealPath="
				+ imgRealPath + ", dollId=" + dollId + "]";
	}
	
}
