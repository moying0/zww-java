package com.bfei.icrane.backend.controller;

import com.bfei.icrane.backend.service.BannerService;
import com.bfei.icrane.backend.service.ChargeRulesService;
import com.bfei.icrane.backend.service.ShareInviteService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.common.util.PropFileManager;
import com.bfei.icrane.common.util.RedisUtil;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.models.*;
import com.bfei.icrane.core.models.vo.ShareInviteAll;
import com.bfei.icrane.core.service.impl.AliyunServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @ClassName: DollManageController
 * @Description: 娃娃机管理控制层
 * @author perry
 * @date 2017年10月19日 上午9:33:35
 * @version V1.0
 */
@Controller
@RequestMapping("/ShareInviteManage")
public class ShareInviteController {
	private static final Logger logger = LoggerFactory.getLogger(ShareInviteController.class);

	@Autowired
	private ShareInviteService shareInviteService;


	@RequestMapping("/list")
	public String list(String registerDate, String memberid, String name, @RequestParam(defaultValue = "1") Integer page,
					   @RequestParam(defaultValue = "10") Integer pageSize, HttpServletRequest request) throws Exception {
		logger.info("查询广告列表输入参数:name={},page={},pageSize={}", name, page, pageSize);
		try {
			Integer totalVisit = shareInviteService.totalCountBVisit(registerDate,memberid,name);
			PageBean<Member> pageBean = shareInviteService.selectShareInviteList(registerDate, memberid, name, page, pageSize);
			logger.info("查询广告列表结果:{}", pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("totalVisit", totalVisit);
			request.setAttribute("memberid", memberid);
			request.setAttribute("name", name);
			request.setAttribute("registerDate", registerDate);
			return "share/share_invite_list";
		} catch (Exception e) {
			logger.error("查询广告列表SystemError:" + e);
			throw e;
		}
	}


	@RequestMapping("/shareInvite")
	public String listCatch(Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50") Integer pageSize, HttpServletRequest request) throws Exception {
		logger.info("查询用户列表输入参数:id={},page={},pageSize={}", id, page, pageSize);
		try {

			Integer total = shareInviteService.totalCountMemberBVisitToMoney(id);
			PageBean<ShareInviteAll> pageBean = shareInviteService.selectShareInviteById(id, page, pageSize);
			logger.info("查询用户邀请列表结果:{}", pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("id", id);
			request.setAttribute("total", total);
			return "share/share_invite_bei_list";
		} catch (Exception e) {
			logger.error("查询用户邀请列表SystemError:" + e);
			throw e;
		}
	}

	@RequestMapping("/shareInvites")
	public String listCatchs(String createDate, String endDate, Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50") Integer pageSize, HttpServletRequest request) throws Exception {
		logger.info("查询用户列表输入参数:id={},page={},pageSize={}", id, page, pageSize);
		try {
			PageBean<ShareInviteAll> pageBean = shareInviteService.selectShareInviteBywhere(createDate, endDate, id, page, pageSize);
			logger.info("查询用户邀请列表结果:{}", pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("id", id);
			request.setAttribute("createDate", createDate);
			request.setAttribute("endDate", endDate);
			return "share/bei_share_invite_list";
		} catch (Exception e) {
			logger.error("查询用户邀请列表SystemError:" + e);
			throw e;
		}
	}
}
