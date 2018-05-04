package com.bfei.icrane.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.Session;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

import com.bfei.icrane.common.util.HttpClientUtil;
import com.bfei.icrane.game.task.HeartbeatDetectTask;

public class RoomSession {
	//当前房主连接
	//private Session session;
	//房主Id
	private Integer memberId;
	private Integer dollId;
	//房主token
	private String token;
	private String device;
	// 产品key
	private String productKey;
	// 娃娃机对应的设备控制发布主题
	private String iotControlTopic;
	// 娃娃机对应的设备消息获取队列
	private String iotStatusQueue;
	private String nickname;
	private String housename;

	//private Date heartbeatDetectTime;//心跳检测时间
	//private boolean heartbeatFlag;//心跳检测标记
	
	
	private String consumeUrl;
	private String endGameUrl;//断开游戏地址
	private String exitDollRoomUrl;//退出房间地址
	
	
//	private HeartbeatDetectTask heartbeatDetectTask;
	
	/**
	 * 扣费接口
	 * @throws ClientProtocolException
	 */
	public void consumeGame() throws ClientProtocolException {
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("memberId",String.valueOf(this.getMemberId())));
		params.add(new BasicNameValuePair("dollId",String.valueOf(this.getDollId())));
		params.add(new BasicNameValuePair("token",this.getToken()));
		HttpClientUtil.getInstance().executeByPOST(consumeUrl, params);
	}
	
	/**
	 * 发送游戏结束
	 * @throws ClientProtocolException
	 */
	public void endGameMsg() throws ClientProtocolException {
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("memberId",String.valueOf(this.getMemberId())));
		params.add(new BasicNameValuePair("dollId",String.valueOf(this.getDollId())));
		params.add(new BasicNameValuePair("token",this.getToken()));
		HttpClientUtil.getInstance().executeByPOST(endGameUrl, params);
	}
	
	public void exitDollMsg() throws ClientProtocolException {
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("memberId",String.valueOf(memberId)));
		params.add(new BasicNameValuePair("token",token));
		HttpClientUtil.getInstance().executeByPOST(exitDollRoomUrl, params);
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getProductKey() {
		return productKey;
	}
	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}
	public String getIotControlTopic() {
		return iotControlTopic;
	}
	public void setIotControlTopic(String iotControlTopic) {
		this.iotControlTopic = iotControlTopic;
	}
	public String getIotStatusQueue() {
		return iotStatusQueue;
	}
	public void setIotStatusQueue(String iotStatusQueue) {
		this.iotStatusQueue = iotStatusQueue;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
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

	public String getEndGameUrl() {
		return endGameUrl;
	}
	public void setEndGameUrl(String endGameUrl) {
		this.endGameUrl = endGameUrl;
	}
	public String getExitDollRoomUrl() {
		return exitDollRoomUrl;
	}
	public void setExitDollRoomUrl(String exitDollRoomUrl) {
		this.exitDollRoomUrl = exitDollRoomUrl;
	}

	public String getConsumeUrl() {
		return consumeUrl;
	}

	public void setConsumeUrl(String consumeUrl) {
		this.consumeUrl = consumeUrl;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	
}
