package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户交易历史
 *
 * @author Administrator
 */

public class MemberChargeHistory implements Serializable{

	private static final long serialVersionUID = -8422287866656057489L;
	private Integer id;	//标识
	private Integer memberId; //用户id
	private Double prepaidAmt;//充值金额
	private Integer coins;//金币数
	private Date chargeDate;//充值时间
	private String type;	//类型
	private String chargeMethod;//获取金币方式方式
	private Integer dollId;    //房间号
	private Integer coinsBefore;//之前金币
	private Integer coinsAfter;	 //之后金币
	
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Double getPrepaidAmt() {
		return prepaidAmt;
	}

	public void setPrepaidAmt(Double prepaidAmt) {
		this.prepaidAmt = prepaidAmt;
	}

	public Integer getCoins() {
		return coins;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}

	public Date getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChargeMethod() {
		return chargeMethod;
	}

	public void setChargeMethod(String chargeMethod) {
		this.chargeMethod = chargeMethod;
	}

	public Integer getDollId() {
		return dollId;
	}

	public void setDollId(Integer dollId) {
		this.dollId = dollId;
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

	@Override
	public String toString() {
		return "ChargeOrder["+id+memberId+prepaidAmt+coins+chargeDate+type+chargeMethod+dollId+coinsBefore+coinsAfter+"]";
	}
}
