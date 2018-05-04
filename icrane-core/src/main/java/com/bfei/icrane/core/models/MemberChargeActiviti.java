package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * 圣诞活动表
 * @author Administrator
 *
 */
public class MemberChargeActiviti implements Serializable {
	private static final long serialVersionUID = -3033345550408369949L;
	private Integer id; // '唯一标识',
	 private Integer memberId; //'用户id',
	 private String  memberName; //'用户名称',
	 private Integer chargeType; // '充值规则类型',
	 private String  chargeName; // '充值时长包名称',
	 private Integer chargeDateLimit; //'期限',
	 private Date chargeDateStart; // '充值起始时间',
	 private Integer coinsStandard; // '奖励标准',
	 private Integer coinsTake; // '累计消耗',
	 private Integer memberState;// '时长包有效状态',
	 private Date chargeDateEnd;// '活动结束时间',
	 private String  chargeAward; // '活动奖励说明',
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getChargeType() {
		return chargeType;
	}
	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public Integer getChargeDateLimit() {
		return chargeDateLimit;
	}
	public void setChargeDateLimit(Integer chargeDateLimit) {
		this.chargeDateLimit = chargeDateLimit;
	}
	public Date getChargeDateStart() {
		return chargeDateStart;
	}
	public void setChargeDateStart(Date chargeDateStart) {
		this.chargeDateStart = chargeDateStart;
	}
	public Integer getCoinsStandard() {
		return coinsStandard;
	}
	public void setCoinsStandard(Integer coinsStandard) {
		this.coinsStandard = coinsStandard;
	}
	public Integer getCoinsTake() {
		return coinsTake;
	}
	public void setCoinsTake(Integer coinsTake) {
		this.coinsTake = coinsTake;
	}
	public Integer getMemberState() {
		return memberState;
	}
	public void setMemberState(Integer memberState) {
		this.memberState = memberState;
	}
	public Date getChargeDateEnd() {
		return chargeDateEnd;
	}
	public void setChargeDateEnd(Date chargeDateEnd) {
		this.chargeDateEnd = chargeDateEnd;
	}
	public String getChargeAward() {
		return chargeAward;
	}
	public void setChargeAward(String chargeAward) {
		this.chargeAward = chargeAward;
	}
	 
	 
}
