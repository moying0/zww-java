package com.bfei.icrane.backend.controller;

import com.bfei.icrane.backend.service.PrefSetService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.ComplaintProblem;
import com.bfei.icrane.core.models.SystemPref;
import com.bfei.icrane.core.service.ComplaintProblemService;
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
@RequestMapping("/complaintProblemManage")
public class ComplaintProblemController {
	private static final Logger logger = LoggerFactory.getLogger(ComplaintProblemController.class);
	@Autowired
	private ComplaintProblemService complaintProblemService;
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50")Integer pageSize,HttpServletRequest request) throws Exception{
		try {
			PageBean<ComplaintProblem> pageBean = complaintProblemService.getComplaintProblemList(page,pageSize);
			logger.info("查询参数设置列表结果:{}",pageBean.toString());
			request.setAttribute("pageBean", pageBean);
			return "appeal/user_appeal_problem_list";
		} catch (Exception e) {
			logger.error("查询参数设置列表系统错误：{}",e);
			throw e;
		}
	}
	
	@RequestMapping("/toEditPref")
	public String toEditRule(Integer id,HttpServletRequest request) throws Exception{
		logger.info("跳转修改参数设置页面输入参数:{}",id);
		try {
			ComplaintProblem complaintProblem = complaintProblemService.selectByPrimaryKey(id);
			logger.info("根据Id查询参数设置结果:{}",complaintProblem);
			request.setAttribute("complaintProblem", complaintProblem);
			return "appeal/user_appeal_problem_edit";
		} catch (Exception e) {
			logger.error("跳转参数设置页面系统错误：{}",e);
			throw e;
		}
	}
	
	@RequestMapping(value="/prefUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String ruleUpdate(ComplaintProblem complaintProblem,HttpServletRequest request) throws Exception{
		logger.info("修改参数设置输入参数:{}",complaintProblem.toString());
		try {
			int result = complaintProblemService.updateComplaintResult(complaintProblem);
			logger.info("修改参数设置结果:{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("修改参数设置系统错误：{}",e);
			throw e;
		}
	}

	@RequestMapping("/newPrefToAdd")
	public String toAdd()throws Exception{
		return "appeal/user_appeal_problem_add";
	}
	@RequestMapping(value="/problemInsert",method=RequestMethod.POST)
	@ResponseBody
	public String payInsert(ComplaintProblem complaintProblem,HttpServletRequest request)throws Exception{
		logger.info("新增申诉问题传入参数：{}",complaintProblem.toString());
		try {
			int result = complaintProblemService.insertComplaintResult(complaintProblem);
			logger.info("新增申诉问题结果:{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("新增申诉问题结果SystemError："+e);
			throw e;
		}
	}
//
	@RequestMapping(value="/problemDel",method=RequestMethod.POST)
	@ResponseBody
	public String prefDel(Integer id) throws Exception{
		logger.info("删除参数设置id：{}",id);
		try {
			int result = complaintProblemService.deleteByid(id);
			logger.error("删除参数设置结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除参数设置SystemError："+e);
			throw e;
		}
	}
}
