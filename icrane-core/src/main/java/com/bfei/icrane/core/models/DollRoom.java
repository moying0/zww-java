package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class DollRoom implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer memberId;
	private Integer dollId;
	private Integer playingFlg;
	private Timestamp createdDate;
	private Integer dollRoomCount;
	private String onlineContextPath; //在线头像
	private String onlineFileName; //在线头像
	private String playContextPath; //楼主头像
	private String playFileName; //楼主头像
	private String name; //楼主名称
	private String imgContextPath;//娃娃图片
	private String imgFileName;//娃娃图片
	private Timestamp catchDate; //抓取时间
	private String videoUrl;//视频地址
	private String catchContextPath;//抓取成功用户的头像
	private String catchFileName;//抓取成功用户的头像
	
	
	public String getCatchContextPath() {
		return catchContextPath;
	}
	public void setCatchContextPath(String catchContextPath) {
		this.catchContextPath = catchContextPath;
	}
	public String getCatchFileName() {
		return catchFileName;
	}
	public void setCatchFileName(String catchFileName) {
		this.catchFileName = catchFileName;
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
	public Timestamp getCatchDate() {
		return catchDate;
	}
	public void setCatchDate(Timestamp catchDate) {
		this.catchDate = catchDate;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDollRoomCount() {
		return dollRoomCount;
	}
	public void setDollRoomCount(Integer dollRoomCount) {
		this.dollRoomCount = dollRoomCount;
	}
	public String getOnlineContextPath() {
		return onlineContextPath;
	}
	public void setOnlineContextPath(String onlineContextPath) {
		this.onlineContextPath = onlineContextPath;
	}
	public String getOnlineFileName() {
		return onlineFileName;
	}
	public void setOnlineFileName(String onlineFileName) {
		this.onlineFileName = onlineFileName;
	}
	public String getPlayContextPath() {
		return playContextPath;
	}
	public void setPlayContextPath(String playContextPath) {
		this.playContextPath = playContextPath;
	}
	public String getPlayFileName() {
		return playFileName;
	}
	public void setPlayFileName(String playFileName) {
		this.playFileName = playFileName;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getDollId() {
		return dollId;
	}
	public void setDollId(Integer dollId) {
		this.dollId = dollId;
	}
	public Integer getPlayingFlg() {
		return playingFlg;
	}
	public void setPlayingFlg(Integer playingFlg) {
		this.playingFlg = playingFlg;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "DollRoom [memberId=" + memberId + ", dollId=" + dollId + ", playingFlg=" + playingFlg + ", createdDate="
				+ createdDate + ", dollRoomCount=" + dollRoomCount + ", onlineContextPath=" + onlineContextPath
				+ ", onlineFileName=" + onlineFileName + ", playContextPath=" + playContextPath + ", playFileName="
				+ playFileName + ", name=" + name + ", imgContextPath=" + imgContextPath + ", imgFileName="
				+ imgFileName + ", catchDate=" + catchDate + ", videoUrl=" + videoUrl + ", catchContextPath="
				+ catchContextPath + ", catchFileName=" + catchFileName + "]";
	}
	
	
}
