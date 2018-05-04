package com.bfei.icrane.api.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bfei.icrane.common.util.EasemobAPI;
import com.bfei.icrane.common.util.OrgInfo;
import com.bfei.icrane.common.util.ResponseHandler;
import com.bfei.icrane.common.util.TokenUtil;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsersApi;
import io.swagger.client.model.NewPassword;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EasemobIMUsersController {
	private UsersApi api = new UsersApi();
	private ResponseHandler responseHandler = new ResponseHandler();
	private static final Logger logger = LoggerFactory.getLogger(EasemobIMUsersController.class);
//	public static void main(String[] args) {
//		RegisterUsers users = new RegisterUsers();
//        User user = new User().username("2").password("123456");
//        users.add(user);
//        EasemobIMUsersController test = new EasemobIMUsersController();
//        Object result = test.createNewIMUserSingle(users);
//        JSONObject json = JSONObject.fromObject(result);
//        JSONArray jsonArray = (JSONArray)json.get("entities");
//        JSONObject getJson = jsonArray.getJSONObject(0);
//        String uuid = getJson.getString("uuid");
////        logger.info(result.toString());
//        Assert.assertNotNull(result);
//		String userName = "aaaa123456";
//		EasemobIMUsersController test = new EasemobIMUsersController();
//        Object result = test.getIMUserByUserName(userName);
//        System.out.println(result);
//	}
	public Object createNewIMUserSingle(final Object payload) {
		logger.info("注册环信接口传入参数payload"+payload);
		return responseHandler.handle(new EasemobAPI() {
			@Override
			public Object invokeEasemobAPI() throws ApiException {
				logger.info("注册环信api.orgNameAppNameUsersPost传入参数"+"ORG_NAME="+OrgInfo.ORG_NAME+"APP_NAME="+OrgInfo.APP_NAME+"payload="+(RegisterUsers) payload+"getAccessToken"+TokenUtil.getAccessToken());
				return api.orgNameAppNameUsersPost(OrgInfo.ORG_NAME,OrgInfo.APP_NAME, (RegisterUsers) payload,TokenUtil.getAccessToken());
			}
		});
	}
	
	public Object getIMUserByUserName(final String userName) {
		return responseHandler.handle(new EasemobAPI() {
			@Override
			public Object invokeEasemobAPI() throws ApiException {
				logger.info("获取环信用户api.orgNameAppNameUsersUsernameGet传入参数"+"ORG_NAME="+OrgInfo.ORG_NAME+"APP_NAME="+OrgInfo.APP_NAME+"getAccessToken"+TokenUtil.getAccessToken()+"userName"+userName);
				return api.orgNameAppNameUsersUsernameGet(OrgInfo.ORG_NAME,OrgInfo.APP_NAME,TokenUtil.getAccessToken(),userName);
		}
		});
	}
	
	public Object modifyIMUserPasswordWithAdminToken(final String userName, final Object payload) {
		return responseHandler.handle(new EasemobAPI() {
			@Override
			public Object invokeEasemobAPI() throws ApiException {
				return api.orgNameAppNameUsersUsernamePasswordPut(OrgInfo.ORG_NAME,OrgInfo.APP_NAME,userName, (NewPassword) payload,TokenUtil.getAccessToken());
			}
		});
	}
}
