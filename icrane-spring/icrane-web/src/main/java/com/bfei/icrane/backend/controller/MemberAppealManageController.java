package com.bfei.icrane.backend.controller;

import com.bfei.icrane.backend.service.MemberManageService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.DollOrderItem;
import com.bfei.icrane.core.models.vo.MemberComplaintAll;
import com.bfei.icrane.core.service.MemberComplaintService;
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
@RequestMapping("/memberAppealManage")
public class MemberAppealManageController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MemberComplaintService memberComplaintService;

	@Autowired
	private MemberManageService memberService;
	
	@RequestMapping("/list")
	public String list(String MemberId,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="50")Integer pageSize,HttpServletRequest request)throws Exception {
		logger.info("查询用户申诉输入参数:name={},page={},pageSize={}",MemberId,page,pageSize);
		try {
			if("".equals(MemberId)){
				MemberId=null;
			}
			PageBean<MemberComplaintAll> pageBean = memberComplaintService.getMemberComplaintList(page, pageSize,MemberId);
			logger.info("查询用户申诉列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("MemberId", MemberId);
			return "appeal/user_appeal_list";
		} catch (Exception e) {
			logger.error("查询用户申诉列表SystemError:"+e);
			throw e;
		}
	}

	@RequestMapping("/doneList")
	public String doneList(String MemberId,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="50")Integer pageSize,HttpServletRequest request)throws Exception {
		logger.info("查询用户申诉输入参数:name={},page={},pageSize={}",MemberId,page,pageSize);
		if("".equals(MemberId)){
			MemberId=null;
		}
		try {
			PageBean<MemberComplaintAll> pageBean = memberComplaintService.getDoneMemberComplaintList(page, pageSize,MemberId);
			logger.info("查询用户申诉列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("MemberId", MemberId);
			return "appeal/user_appeal_done_list";
		} catch (Exception e) {
			logger.error("查询用户申诉列表SystemError:"+e);
			throw e;
		}
	}

	@RequestMapping("/player")
	public String video(String players,HttpServletRequest request)throws Exception {
		logger.info("视频播放输入参数:players={}",players);
		try {
			request.setAttribute("players", players);
			return "appeal/appeal_player";
		} catch (Exception e) {
			logger.error("视频播放SystemError:"+e);
			throw e;
		}
	}

//	@RequestMapping("/toEditMember")
//	public String toEditMember(Integer id,HttpServletRequest request) throws Exception{
//		logger.info("跳转编辑用户id:{}",id);
//		try {
//			Member member = memberService.getMemberById(id);
//			logger.info("编辑用户查询用户:{}",member!=null?member.toString():"无此用户");
//			request.setAttribute("member",member);
//			return "user/user_edit";
//		} catch (Exception e) {
//			logger.error("编辑用户SystemError："+e);
//			throw e;
//		}
//
//	}
//	/**
//	 * 查询历史充值记录
//	 * @param id
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/toQueryCharge")
//	public String toQueryCharge(Integer id,HttpServletRequest request) throws Exception{
//		logger.info("查询用户充值记录id:{}",id);
//		try {
//			Member member = memberService.getMemberById(id);
//			logger.info("查询用户充值记录:{}",member!=null?member.toString():"无此用户");
//			request.setAttribute("member",member);
//		} catch (Exception e) {
//			logger.error("查询用户充值记录SystemError："+e);
//		}
//		return "user/user_charge_list";
//	}
//
	@RequestMapping("/appealPass")
	public String appealPass(Integer id,Integer state,HttpServletRequest request)throws Exception {
		logger.info("查询用户列表输入参数:id={},page={},pageSize={}",id);
		try {
			request.setAttribute("state",state);
			request.setAttribute("id",id);
			if(state == 1){
				return "appeal/user_appeal_pass";
			}else {
				return "appeal/user_appeal_nopass";
			}
		} catch (Exception e) {
			throw e;
		}
	}


	@RequestMapping(value="/upNopass",method=RequestMethod.POST)
	@ResponseBody
	public String listCatch(Integer id,Integer state, String checkReason,HttpServletRequest request)throws Exception {
		logger.info("参数:id={},page={},pageSize={}",id,state,checkReason);
		try {
			int result = memberComplaintService.updateComplaintResult(id,state,checkReason);
			logger.info("驳回结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("驳回SystemError:"+e);
			throw e;
		}
	}

	@RequestMapping("/upPass")
	public String upPass(Integer id,Integer state, String checkReason,HttpServletRequest request)throws Exception {
		logger.info("参数:id={},state={},checkReason={}",id,state,checkReason);
		try {
			int result = memberComplaintService.updateComplaintResult(id,state,checkReason);
			logger.error("通过结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "user/success";
			}else {
				return "user/fail";
			}
		} catch (Exception e) {
			logger.error("通过SystemError:"+e);
			throw e;
		}
	}

}

