package com.bfei.icrane.api.service;

import cn.jpush.api.JPushClient;

public abstract class BaseTest {

	protected static final String APP_KEY = "fff1e895ddc17063e8fc24f2";
    protected static final String MASTER_SECRET = "969898f3655706a944e9dd4a";
    protected static final String GROUP_MASTER_SECRET = "b11314807507e2bcfdeebe2e";
    protected static final String GROUP_PUSH_KEY = "2c88a01e073a0fe4fc7b167c";

    public static final String ALERT = "JPush Test - alert";
    public static final String MSG_CONTENT = "JPush Test - msgContent";
    
    public static final String REGISTRATION_ID1 = "0900e8d85ef";
    public static final String REGISTRATION_ID2 = "0a04ad7d8b4";
    public static final String REGISTRATION_ID3 = "18071adc030dcba91c0";

    
    protected JPushClient jpushClient = null;
    
    public void before() {
        jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        
    }

}
