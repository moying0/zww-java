package com.bfei.icrane.backend.controller;

import com.bfei.icrane.backend.service.PrefSetService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.SystemPref;
import com.bfei.icrane.core.models.vo.MemberFeedbackAll;
import com.bfei.icrane.core.service.SrvReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/memberFeedbackManage")
public class MemberFeedbackController {
	private static final Logger logger = LoggerFactory.getLogger(MemberFeedbackController.class);

	@Autowired
	private SrvReqService srvReqService;
	@RequestMapping("/list")
	public String list(String memberId,  @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer pageSize, HttpServletRequest request) throws Exception{
		try {
			PageBean<MemberFeedbackAll> pageBean = srvReqService.selectAll(memberId, page, pageSize);
			logger.info("查询参数设置列表结果:{}",pageBean.toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("memberId", memberId);
			return "feedback/user_feedback_list";
		} catch (Exception e) {
			logger.error("查询参数设置列表系统错误：{}",e);
			throw e;
		}
	}
	
//	@RequestMapping("/toEditPref")
//	public String toEditRule(String code,HttpServletRequest request) throws Exception{
//		logger.info("跳转修改参数设置页面输入参数:{}",code);
//		try {
//			SystemPref prefSet = prefSetService.selectByPrimaryKey(code);
//			logger.info("根据Id查询参数设置结果:{}",prefSet);
//			request.setAttribute("prefSet", prefSet);
//			return "discount/pref_set_edit";
//		} catch (Exception e) {
//			logger.error("跳转参数设置页面系统错误：{}",e);
//			throw e;
//		}
//	}
//
//	@RequestMapping(value="/prefUpdate",method=RequestMethod.POST)
//	@ResponseBody
//	public String ruleUpdate(SystemPref systemPref,HttpServletRequest request) throws Exception{
//		logger.info("修改参数设置输入参数:{}",systemPref.toString());
//		try {
//			int result = prefSetService.updateByPrimaryKeySelective(systemPref, request);
//			logger.info("修改参数设置结果:{}",result>0?"success":"fail");
//			if(result>0) {
//				return "1";
//			}else {
//				return "0";
//			}
//		} catch (Exception e) {
//			logger.error("修改参数设置系统错误：{}",e);
//			throw e;
//		}
//	}
//
//	@RequestMapping("/newPrefToAdd")
//	public String toAdd()throws Exception{
//		return "discount/pref_set_add";
//	}
//	@RequestMapping(value="/prefInsert",method=RequestMethod.POST)
//	@ResponseBody
//	public String payInsert(SystemPref systemPref,HttpServletRequest request)throws Exception{
//		logger.info("新增参数设置传入参数：{}",systemPref.toString());
//		try {
//			int result = prefSetService.insertSelective(systemPref,request);
//			logger.info("新增参数设置结果:{}",result>0?"success":"fail");
//			if(result>0) {
//				return "1";
//			}else {
//				return "0";
//			}
//		} catch (Exception e) {
//			logger.error("新增参数设置SystemError："+e);
//			throw e;
//		}
//	}
//
//	@RequestMapping(value="/prefDel",method=RequestMethod.POST)
//	@ResponseBody
//	public String prefDel(SystemPref systemPref) throws Exception{
//		logger.info("删除参数设置id：{}",systemPref.getCode());
//		try {
//			int result = prefSetService.deleteByPrimaryKey(systemPref.getCode());
//			logger.error("删除参数设置结果：{}",result>0?"success":"fail");
//			if(result>0) {
//				return "1";
//			}else {
//				return "0";
//			}
//		} catch (Exception e) {
//			logger.error("删除参数设置SystemError："+e);
//			throw e;
//		}
//	}
}
