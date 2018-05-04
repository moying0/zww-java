package com.bfei.icrane.core.models.vo;

import java.io.Serializable;
import java.util.Date;

public class ShareInviteAll implements Serializable {

	
	private static final long serialVersionUID = 5319339675762595464L;
	private Integer id;
	/**
	 * 邀请码编号
	 */
	private String inviteCode;//邀请码
	private String name;//被邀请人名
	private String memberID;//被邀请memberId
	private String gender;//被邀请memberId
	private String mobile;//被邀请memberId
	private String inviteMemberId;//邀请人id
	private String invitedId;//被邀请id
	private Date createDate;//邀请码填写时间
	private Integer state;//充值奖励状态0未奖励,1,奖励过


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	public String getInviteMemberId() {
		return inviteMemberId;
	}
	public void setInviteMemberId(String inviteMemberId) {
		this.inviteMemberId = inviteMemberId;
	}
	public String getInvitedId() {
		return invitedId;
	}
	public void setInvitedId(String invitedId) {
		this.invitedId = invitedId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ShareInvite [id=" + id +
				", inviteCode=" + inviteCode +
				", inviteMemberId=" + inviteMemberId +
				", invitedId=" + invitedId +
				", createDate=" + createDate +
				", name=" + name +
				", memberID=" + memberID +
				", gender=" + gender +
				", mobile=" + mobile +
				", state=" + state + "]";
	}
}
