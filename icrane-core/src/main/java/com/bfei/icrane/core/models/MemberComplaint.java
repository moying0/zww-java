package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: mwan
 * Version: 1.1
 * Date: 2017/09/16
 * Description: APP用户持久化类.
 * Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public class MemberComplaint implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String gameNum;//游戏编号
	private Integer memberId;//用户id
	private String memberNum;//用户编号
	private Integer dollId;//娃娃机id
	private Integer memberCatchId;//抓取记录id
	private String complaintReason;//申诉原因
	private Integer checkState;//审核状态（待审核0，通过1，未通过-1）
	private String checkReason;//审核原因
	private Date creatDate;//创建时间
	private Integer creatBy;//创建人
	private Date modifyDate;//修改时间
	private Integer modifyBy;//修改人


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

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Integer getDollId() {
		return dollId;
	}

	public void setDollId(Integer dollId) {
		this.dollId = dollId;
	}

	public Integer getMemberCatchId() {
		return memberCatchId;
	}

	public void setMemberCatchId(Integer memberCatchId) {
		this.memberCatchId = memberCatchId;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", gameNum=" + gameNum + ", memberId=" + memberId + ", memberNum=" + memberNum + ", dollId="
				+ dollId + ", memberCatchId=" + memberCatchId + ", complaintReason=" + complaintReason + ", checkState=" + checkState + ", checkReason="
				+ checkReason + ", checkState=" + checkState + ", checkReason=" + checkReason + ", creatDate="
				+ creatDate + ", creatBy=" + creatBy + ", modifyDate=" + modifyDate
				+ ", modifyBy=" + modifyBy + "]";
	}
	
	
}
