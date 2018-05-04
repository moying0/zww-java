package com.bfei.icrane.core.models;

import java.io.Serializable;

public class WxpayRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer memberId;

    private String mchOrderNo;

    private String wxOrderNo;

    private String openId;

    private String totalFee;

    private String timeEnd;

    public String getChargeFrom() {
        return chargeFrom;
    }

    public void setChargeFrom(String chargeFrom) {
        this.chargeFrom = chargeFrom;
    }

    private String chargeFrom;

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

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo == null ? null : mchOrderNo.trim();
    }

    public String getWxOrderNo() {
        return wxOrderNo;
    }

    public void setWxOrderNo(String wxOrderNo) {
        this.wxOrderNo = wxOrderNo == null ? null : wxOrderNo.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee == null ? null : totalFee.trim();
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd == null ? null : timeEnd.trim();
    }

	@Override
	public String toString() {
		return "WxpayRecord [id=" + id + ", memberId=" + memberId + ", mchOrderNo=" + mchOrderNo + ", wxOrderNo="
				+ wxOrderNo + ", openId=" + openId + ", totalFee=" + totalFee + ", timeEnd=" + timeEnd + "]";
	}
    
}
