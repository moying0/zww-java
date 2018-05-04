package com.bfei.icrane.backend.controller;

import com.bfei.icrane.backend.service.ChargeRulesService;
import com.bfei.icrane.backend.service.MemberChannerDeductService;
import com.bfei.icrane.backend.service.MemberManageService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.*;
import com.bfei.icrane.core.models.vo.ChannelChargeOrder;
import com.bfei.icrane.core.service.ChargeOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/channelManage")
public class ChannerController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MemberManageService memberService;

	@Autowired
	private ChargeOrderService chargeOrderService;

	@Autowired
	private ChargeRulesService chargeRulesService;

	@Autowired
	private MemberChannerDeductService memberChannerDeductService;

	@Autowired
	private MemberManageService memberManageService;

	@RequestMapping("/searchList")
	public String list(String registerChannel, String endDate,String registerDate,String lastLoginFrom, String memberid, String name, @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="50")Integer pageSize, HttpServletRequest request)throws Exception {
		logger.info("查询用户列表输入参数:name={},page={},pageSize={}",name,page,pageSize);
		try {
			if("".equals(endDate)){
				endDate = null;
			}
			if("".equals(registerDate)){
				registerDate = null;
			}
			if("".equals(lastLoginFrom)){
				lastLoginFrom = null;
			}
			if("".equals(memberid)){
				memberid = null;
			}
			if("".equals(name)){
				name = null;
			}
			if("".equals(registerChannel)){
				registerChannel = null;
			}
			if("2".equals(registerChannel)){
				registerChannel = "";
			}
			//查询渠道号
			List<Member> memberList = memberService.getMemberAll();
			//分页信息
			PageBean<Member> pageBean = memberService.getUserList(page, pageSize,name,memberid,lastLoginFrom,registerDate,endDate,registerChannel);
			logger.info("查询用户列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("name", name);
			request.setAttribute("memberid", memberid);
			request.setAttribute("lastLoginFrom", lastLoginFrom);
			request.setAttribute("registerDate", registerDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("registerChannel", registerChannel);
			request.setAttribute("memberList", memberList);
			return "channel/channel_list";
		} catch (Exception e) {
			logger.error("查询用户列表SystemError:"+e);
			throw e;
		}
	}


	//渠道充值历史记录
	@RequestMapping("/listChargeHistory")
	public String listChargeHistory(String lastLoginFrom,String registerChannel, String memberName, String memberId,Integer chargeName, Integer charge_state, String create_date, String endtime,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="50")Integer pageSize,HttpServletRequest request)throws Exception {
		logger.info("查询充值列表输入参数:name={},page={},pageSize={}",memberName,page,pageSize);
		try {
			if("".equals(lastLoginFrom)){
				lastLoginFrom = null;
			}
			if("".equals(registerChannel)){
				registerChannel = null;
			}
			if("".equals(memberId)){
				memberId = null;
			}
			if("".equals(memberName)){
				memberName = null;
			}
			if("".equals(chargeName)){
				chargeName = null;
			}
			ChargeRules chargeRule = chargeRulesService.selectByPrimaryKey(chargeName);
			Integer chargeid = null;
			if(chargeRule != null){
				chargeid = chargeRule.getId();
			}
			if("".equals(charge_state)){
				charge_state = null;
			}

			if("".equals(create_date)){
				create_date = null;
			}
			if("".equals(endtime)){
				endtime = null;
			}
			//查询渠道号
			List<Member> memberList = memberService.getMemberAll();
			//查询充值人数
			Integer allNum = chargeOrderService.selectChannelChargeNum(lastLoginFrom,registerChannel,memberName,memberId,chargeid,charge_state,create_date,endtime);
			//查询充值金额
			Double allPrice = chargeOrderService.selectChannelChargePrice(lastLoginFrom,registerChannel,memberName,memberId,chargeid,charge_state,create_date,endtime);

			PageBean<ChannelChargeOrder> pageBean = chargeOrderService.selectChannelChargeOrderBy(lastLoginFrom,registerChannel,memberName,memberId,chargeid,charge_state,create_date,endtime,page, pageSize);
			List<ChargeRules> chargeRules = chargeRulesService.selectChargeRules();
			logger.info("查询渠道充值列表结果:{}",pageBean.getList().toString());
			logger.info("查询渠道充值规则列表结果:{}",chargeRules.toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("chargeRules", chargeRules);
			request.setAttribute("memberName", memberName);
			request.setAttribute("memberId", memberId);
			request.setAttribute("chargeName", chargeName);
			request.setAttribute("charge_state", charge_state);
			request.setAttribute("create_date", create_date);
			request.setAttribute("endtime", endtime);
			request.setAttribute("registerChannel", registerChannel);
			request.setAttribute("memberList", memberList);
			request.setAttribute("allNum", allNum);
			request.setAttribute("allPrice", allPrice);
			request.setAttribute("lastLoginFrom", lastLoginFrom);
			return "channel/channel_charge_order_list";
		} catch (Exception e) {
			logger.error("渠道查询充值列表SystemError:"+e);
			throw e;
		}
	}

	//某个充值记录
	@RequestMapping("/listCharge")
	public String listCharge(Integer id,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="50")Integer pageSize,HttpServletRequest request)throws Exception {
		logger.info("查询用户列表输入参数:id={},page={},pageSize={}",id,page,pageSize);
		try {

			PageBean<ChargeOrder> pageBean = chargeOrderService.selectChargeOrderByUserid(page, pageSize,id);
			logger.info("查询用户充值列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("id", id);
			return "user/user_charge_list";
		} catch (Exception e) {
			logger.error("查询用户充值列表SystemError:"+e);
			throw e;
		}
	}

	//抓取记录
	@RequestMapping("/listCatch")
	public String listCatch(Integer id, @RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="50")Integer pageSize,HttpServletRequest request)throws Exception {
		logger.info("查询用户列表输入参数:id={},page={},pageSize={}",id,page,pageSize);
		try {

			PageBean<CatchHistory> pageBean = memberService.getCatchHistory(id,page, pageSize);
			logger.info("查询用户抓取列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("id", id);
			return "user/user_catch_list";
		} catch (Exception e) {
			logger.error("查询用户抓取列表SystemError:"+e);
			throw e;
		}
	}


	@RequestMapping(value="/memberUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String memberUpdate(Member member,HttpServletRequest request) throws Exception{
		logger.info("更新用户传入参数member：{}",member!=null?member.toString():null);
		try {
			int result = memberService.updateByPrimaryKeySelective(member,request);
			logger.info("更新用户结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("更新用户SystemError："+e);
			throw e;
		}
	}


	@RequestMapping(value="/deductDel",method=RequestMethod.POST)
	@ResponseBody
	public String dollDel(Integer id) throws Exception{
		logger.info("删除扣量id：{}",id);
		try {
			int result = memberChannerDeductService.deleteByid(id);
			logger.error("删除扣量结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除扣量SystemError："+e);
			throw e;
		}
	}

	@RequestMapping("/deductList")
	public String deductList(String endDate,String registerDate,String lastLoginFrom, String memberid, String name, @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="50")Integer pageSize, HttpServletRequest request)throws Exception {
		logger.info("查询用户列表输入参数:name={},page={},pageSize={}",name,page,pageSize);
		try {
			if("".equals(endDate)){
				endDate = null;
			}
			if("".equals(registerDate)){
				registerDate = null;
			}
			if("".equals(lastLoginFrom)){
				lastLoginFrom = null;
			}
			if("".equals(memberid)){
				memberid = null;
			}
			if("".equals(name)){
				name = null;
			}
			PageBean<MemberChannelDeduct> pageBean = memberChannerDeductService.getUserList(page, pageSize,name,memberid,lastLoginFrom,registerDate,endDate);
			logger.info("查询扣量列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("name", name);
			request.setAttribute("memberid", memberid);
			request.setAttribute("lastLoginFrom", lastLoginFrom);
			request.setAttribute("registerDate", registerDate);
			request.setAttribute("endDate", endDate);
			return "channel/channel_deduct_list";
		} catch (Exception e) {
			logger.error("查询扣量列表SystemError:"+e);
			throw e;
		}
	}
	/**
	 * 扣量
	 * @param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/channelDeduct",method=RequestMethod.POST)
	@ResponseBody
	public String memberChanner(String ids, HttpServletRequest request) throws Exception{
		logger.info("扣量传入参数member：{}",ids!=null?ids.toString():null);
		String[] idsAll = null;
		Integer result = 0;
		//存放id集合
		List<String> idsString = new ArrayList<>();
		if(ids != null) {
			idsAll = ids.split(",");
		}
		try {
			Integer id = null;
			//id集合
//			List<MemberChannelDeduct> channelDeduct = new ArrayList<>();
			//获取扣量信息
			for (String idd:idsAll) {
				if(ids != null){
					id = Integer.parseInt(idd);
					//去除已扣量的用户
					Integer resultid = memberChannerDeductService.selectByUserid(id);
					if (resultid <= 0){
						Member member = memberManageService.getMemberById(id);
						MemberChannelDeduct memberChannelDeduct = this.channelDeduct(member);
//					channelDeduct.add(memberChannelDeduct);
						result = memberChannerDeductService.insertSelective(memberChannelDeduct);
					}
				}
			}
			logger.info("更新用户结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("更新用户SystemError："+e);
			throw e;
		}

	 }

	public MemberChannelDeduct channelDeduct(Member member) {
		MemberChannelDeduct  memberChannelDeduct = new MemberChannelDeduct();
		memberChannelDeduct.setUserId(member.getId());
		memberChannelDeduct.setMemberID(member.getMemberID());
		memberChannelDeduct.setName(member.getName());
		memberChannelDeduct.setMobile(member.getMobile());
		memberChannelDeduct.setWeixinId(member.getWeixinId());
		memberChannelDeduct.setGender(member.getGender());
		memberChannelDeduct.setRegisterDate(member.getRegisterDate());
		memberChannelDeduct.setLastLoginDate(member.getLastLoginDate());
		memberChannelDeduct.setRegisterFrom(member.getRegisterFrom());
		memberChannelDeduct.setLastLoginFrom(member.getLastLoginFrom());
		memberChannelDeduct.setRegisterChannel(member.getRegisterChannel());
		memberChannelDeduct.setLoginChannel(member.getLoginChannel());
		memberChannelDeduct.setPhoneModel(member.getPhoneModel());
		memberChannelDeduct.setOnlineFlg(member.isOnlineFlg());
		return memberChannelDeduct;
	}


}

