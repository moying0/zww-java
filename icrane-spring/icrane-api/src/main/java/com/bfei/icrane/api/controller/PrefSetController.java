package com.bfei.icrane.api.controller;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfei.icrane.api.service.PrefSetService;
import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.core.models.PrefSet;
import com.bfei.icrane.core.service.ValidateTokenService;

@Controller
@RequestMapping(value = "/pref")
@CrossOrigin
public class PrefSetController {
	private static final Logger logger = LoggerFactory.getLogger(PrefSetController.class);

	@Autowired
	private PrefSetService prefSetService;

	@Autowired
	private ValidateTokenService validateTokenService;

	/**
	 * @param mobile
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatePrefSet", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(Integer memberId, Integer musicFlg, Integer soundFlg,Integer shockFlg, String token)
			throws Exception {
		logger.info("音乐设置接口参数memberId=" + memberId + "," + "musicFlg=" + musicFlg + "," + "soundFlg=" + soundFlg + ","
				+ "token=" + token);
		Map<String, Object> resultMap = new HashedMap<String, Object>();
		try {
			// 验证token有效性
			if (token == null || "".equals(token) || !validateTokenService.validataToken(token,memberId)) {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_UNAUTHORIZED_CODE);
				resultMap.put("message", Enviroment.RETURN_UNAUTHORIZED_MESSAGE);

				return resultMap;
			}
			PrefSet prefSet = new PrefSet();
			prefSet.setMemberId(memberId);
			prefSet.setMusicFlg(musicFlg);
			prefSet.setSoundFlg(soundFlg);
			prefSet.setShockFlg(shockFlg);
//			logger.info("音乐设置参数prefSet=" + prefSet);
			Integer result = prefSetService.updateByPrimaryKeySelective(prefSet);
			logger.info("音乐设置result=" + result);
			if (result == 1) {
				resultMap.put("success", Enviroment.RETURN_SUCCESS);
				resultMap.put("statusCode", Enviroment.RETURN_SUCCESS_CODE);
				resultMap.put("message", Enviroment.RETURN_SUCCESS_MESSAGE);
			} else {
				resultMap.put("success", Enviroment.RETURN_FAILE);
				resultMap.put("statusCode", Enviroment.RETURN_FAILE_CODE);
				resultMap.put("message", Enviroment.RETURN_FAILE_MESSAGE);
			}
			logger.info("音乐设置resultMap=" + resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("音乐设置出错", e);
			throw e;
		}
	}

}
