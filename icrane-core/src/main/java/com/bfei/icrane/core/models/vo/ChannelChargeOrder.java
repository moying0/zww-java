package com.bfei.icrane.core.models.vo;

import java.io.Serializable;
import java.util.Date;

public class ChannelChargeOrder implements Serializable{

	private static final long serialVersionUID = -7573063272518136649L;

	private Integer id;				//订单序号
	private String orderNo;			//订单编号
	private Integer  chargeruleid;	//充值规则
	private String chargeName;		//充值规则名称
	private Double price;			//订单金额
	private Integer memberId;		//用户id
	private String  memberName;		//用户名称
	private Integer chargeType;		//充值类型  1 为微信
	private Integer chargeState;		//订单状态
	private Integer coinsBefore;		//充值前娃娃币
	private Integer coinsAfter;		//充值后娃娃币
	private Integer coinsCharge;		//充值娃娃币
	private Integer coinsOffer;		//充值赠送娃娃币
	private Date createDate;		//创建时间
	private Date updateDate;		//修改时间
	private String registerChannel; //注册渠道号
	private String loginChannel;    //登录渠道号
	private String memberNum;    //用户编号


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getChargeruleid() {
		return chargeruleid;
	}
	public void setChargeruleid(Integer chargeruleid) {
		this.chargeruleid = chargeruleid;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public Integer getChargeState() {
		return chargeState;
	}
	public void setChargeState(Integer chargeState) {
		this.chargeState = chargeState;
	}
	public Integer getCoinsBefore() {
		return coinsBefore;
	}
	public void setCoinsBefore(Integer coinsBefore) {
		this.coinsBefore = coinsBefore;
	}
	public Integer getCoinsAfter() {
		return coinsAfter;
	}
	public void setCoinsAfter(Integer coinsAfter) {
		this.coinsAfter = coinsAfter;
	}
	public Integer getCoinsCharge() {
		return coinsCharge;
	}
	public void setCoinsCharge(Integer coinsCharge) {
		this.coinsCharge = coinsCharge;
	}
	public Integer getCoinsOffer() {
		return coinsOffer;
	}
	public void setCoinsOffer(Integer coinsOffer) {
		this.coinsOffer = coinsOffer;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRegisterChannel() {
		return registerChannel;
	}

	public void setRegisterChannel(String registerChannel) {
		this.registerChannel = registerChannel;
	}

	public String getLoginChannel() {
		return loginChannel;
	}

	public void setLoginChannel(String loginChannel) {
		this.loginChannel = loginChannel;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "ChargeOrder["+"id="+id+",orderNo="+orderNo+",chargeruleid="+chargeruleid+",chargeName="+chargeName+",price="
				+price+",memberId="+memberId+",memberName="+memberName+",chargeType="+chargeType+",chargeState="+chargeState+
				",coinsBefore="+coinsBefore+",coinsAfter="+coinsAfter+",coinsCharge="+coinsCharge+",coinsOffer="+coinsOffer+",createDate="+
				createDate+",updateDate="+updateDate+",registerChannel="+registerChannel+",loginChannel="+loginChannel+
				",memberNum="+memberNum+"]";
	}
	
	
}
