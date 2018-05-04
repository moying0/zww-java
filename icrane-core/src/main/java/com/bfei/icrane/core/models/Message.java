package com.bfei.icrane.core.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer memberId;
	private String msgBody;
	private Timestamp sendDate;
	private String msgTitle;
	private Integer readFlg;
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
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public Timestamp getSendDate() {
		return sendDate;
	}
	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public Integer getReadFlg() {
		return readFlg;
	}
	public void setReadFlg(Integer readFlg) {
		this.readFlg = readFlg;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", memberId=" + memberId + ", msgBody=" + msgBody + ", sendDate=" + sendDate
				+ ", msgTitle=" + msgTitle + ", readFlg=" + readFlg + "]";
	}
	
	
} 
