package com.bfei.icrane.core.models.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: APP用户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class MemberComplaintAll implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String gameNum;//游戏编号
	private Integer memberId;//用户id
	private String memberNum;//用户编号
	private String memberName;//用户昵称
	private String memberPhone;//用户手机
	private Integer dollId;//娃娃机id
	private String dollImg;//娃娃机头像
	private String dollName;//娃娃机名称
	private Integer dollCions;//消耗金币数
	private Integer memberCatchId;//抓取记录id
	private Date memberCatchDate;//抓取时间
	private String memberCatchResult;//抓取结果
	private String complaintReason;//申诉原因
	private Integer checkState;//审核状态（待审核0，通过1，未通过-1）
	private String checkReason;//审核原因
	private Date creatDate;//创建时间
	private Integer creatBy;//创建人
	private Date modifyDate;//修改时间
	private Integer modifyBy;//修改人
	private String videoURL;//抓取视频

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameNum() {
		return gameNum;
	}

	public void setGameNum(String gameNum) {
		this.gameNum = gameNum;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}


	public String getComplaintReason() {
		return complaintReason;
	}

	public void setComplaintReason(String complaintReason) {
		this.complaintReason = complaintReason;
	}

	public Integer getCheckState() {
		return checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}



	public void setCreatDate(Timestamp creatDate) {
		this.creatDate = creatDate;
	}


	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public Integer getDollId() {
		return dollId;
	}

	public void setDollId(Integer dollId) {
		this.dollId = dollId;
	}

	public String getDollImg() {
		return dollImg;
	}

	public void setDollImg(String dollImg) {
		this.dollImg = dollImg;
	}

	public String getDollName() {
		return dollName;
	}

	public void setDollName(String dollName) {
		this.dollName = dollName;
	}

	public Integer getDollCions() {
		return dollCions;
	}

	public void setDollCions(Integer dollCions) {
		this.dollCions = dollCions;
	}

	public Integer getMemberCatchId() {
		return memberCatchId;
	}

	public void setMemberCatchId(Integer memberCatchId) {
		this.memberCatchId = memberCatchId;
	}


	public Date getMemberCatchDate() {
		return memberCatchDate;
	}

	public void setMemberCatchDate(Date memberCatchDate) {
		this.memberCatchDate = memberCatchDate;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getMemberCatchResult() {
		return memberCatchResult;
	}

	public void setMemberCatchResult(String memberCatchResult) {
		this.memberCatchResult = memberCatchResult;
	}

	public String getCheckReason() {
		return checkReason;
	}

	public void setCheckReason(String checkReason) {
		this.checkReason = checkReason;
	}

	public Integer getCreatBy() {
		return creatBy;
	}

	public void setCreatBy(Integer creatBy) {
		this.creatBy = creatBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", gameNum=" + gameNum + ", memberId=" + memberId + ", memberNum=" + memberNum + ", memberName=" + memberName +", memberPhone=" + memberPhone +
				", dollId=" + dollId +", dollImg=" + dollImg +", dollImg=" + dollImg +", dollCions=" + dollCions
				+ ", memberCatchId=" + memberCatchId + ", memberCatchDate=" + memberCatchDate+ ", memberCatchResult=" + memberCatchResult + ", complaintReason=" + complaintReason + ", checkState=" + checkState + ", checkReason="
				+ checkReason + ", checkState=" + checkState + ", checkReason=" + checkReason + ", creatDate="
				+ creatDate + ", creatBy=" + creatBy + ", modifyDate=" + modifyDate
				+ ", modifyBy=" + modifyBy + ", videoURL=" + videoURL + "]";
	}
	
	
}
