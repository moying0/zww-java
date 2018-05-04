package com.bfei.icrane.backend.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bfei.icrane.backend.service.PayManageService;
import com.bfei.icrane.backend.service.PrefSetService;
import com.bfei.icrane.common.util.PropFileManager;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.models.ChargeRules;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollImage;
import com.bfei.icrane.core.models.SystemPref;
import com.bfei.icrane.core.service.impl.AliyunServiceImpl;
/**
 * @ClassName: PayManageController 
 * @Description: 充值管理控制层
 * @author perry 
 * @date 2017年10月24日 下午4:46:12 
 * @version V1.0
 */
@Controller
@RequestMapping("/payManage")
public class PayManageController {
	private static final Logger logger = LoggerFactory.getLogger(PayManageController.class);
	private static PropFileManager prop=new PropFileManager("interface.properties");
	@Autowired
	private PayManageService payManageService;
	@Autowired
	private PrefSetService prefSetService;
	@RequestMapping("/list")
	public String list(HttpServletRequest request) throws Exception{
		try {
			List<ChargeRules> list = payManageService.selectChargeRules();
			logger.info("查询充值优惠列表结果:{}",list.toString());
			request.setAttribute("ChargeList", list);
			return "discount/pay_set_list";
		} catch (Exception e) {
			logger.error("查询充值优惠列表系统错误：{}",e);
			throw e;
		}
	}
	
	@RequestMapping("/toEditRule")
	public String toEditRule(Integer id,HttpServletRequest request) throws Exception{
		logger.info("跳转修改充值规则页面输入参数:{}",id);
		try {
			ChargeRules chargeRules = payManageService.selectByPrimaryKey(id);
			//兼容老数据
			if (chargeRules.getChargeType()==null) {
				chargeRules.setChargeType(0);
			}
			if (chargeRules.getChargeDateLimit()==null) {
				chargeRules.setChargeDateLimit(0);
			}
			if (chargeRules.getChargeTimesLimit()==null) {
				chargeRules.setChargeTimesLimit(0);
			}
			if (chargeRules.getOrderby()==null) {
				chargeRules.setOrderby(0);
			}
			if (chargeRules.getCionsFirst()==null) {
				chargeRules.setCionsFirst(0);
			}
			logger.info("根据Id查询充值规则结果:{}",chargeRules.toString());
			request.setAttribute("chargeRules", chargeRules);
			return "discount/pay_set_edit";
		} catch (Exception e) {
			logger.error("跳转修改充值优惠页面系统错误：{}",e);
			throw e;
		}
	}
	
	@RequestMapping(value="/ruleUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String ruleUpdate(ChargeRules chargeRules,HttpServletRequest request) throws Exception{
		logger.info("修改充值规则输入参数:{}",chargeRules.toString());
		try {
			int result = payManageService.updateByPrimaryKeySelective(chargeRules, request);
			logger.info("修改充值规则结果:{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("修改充值优惠列表系统错误：{}",e);
			throw e;
		}
	}
	
	@RequestMapping("/newRuleToAdd")
	public String toAdd()throws Exception{
		return "discount/pay_set_add";
	}
	
	@RequestMapping("/newRuleDetailToAdd")
	public String detailToAdd()throws Exception{
		return "discount/pay_detail_set_add";
	}
	@RequestMapping(value="/payInsert",method=RequestMethod.POST)
	@ResponseBody
	public String payInsert(ChargeRules chargeRules,HttpServletRequest request)throws Exception{
		logger.info("新增充值规则传入参数：{}",chargeRules.toString());
		try {
			int result = payManageService.insertSelective(chargeRules,request);
			logger.info("新增充值规则结果:{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("新增充值规则SystemError："+e);
			throw e;
		}
	}
	
	@RequestMapping(value="/ruleDel",method=RequestMethod.POST)
	@ResponseBody
	public String ruleDel(ChargeRules chargeRules) throws Exception{
		logger.info("删除充值规则id：{}",chargeRules.getId());
		try {
			int result = payManageService.deleteByPrimaryKey(chargeRules.getId());
			logger.error("删除充值规则结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除充值规则SystemError："+e);
			throw e;
		}
	}
	/**
	 * 充值说明
	 * @param file
	 * @param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception{
		String originalFileName = file.getOriginalFilename();
		// 获取后缀
		String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		// 修改后完整的文件名称
		String fileKey = StringUtils.getRandomUUID();
		String NewFileKey = fileKey + "." + suffix;
		byte[] bytes = file.getBytes();
		InputStream fileInputStream = new ByteArrayInputStream(bytes);
		String bukectName=prop.getProperty("aliyun.ossBucketName");
		logger.info("bukectName:{}",bukectName);
		if(!AliyunServiceImpl.getInstance().putFileStreamToOSS(bukectName, NewFileKey, fileInputStream)) {
			return "0";
		}
		String newFileUrl = AliyunServiceImpl.getInstance().generatePresignedUrl(bukectName, NewFileKey, 1000000).toString();
		String code ="PAY_DETAIL";
		String name = "充值说明";
		SystemPref prefSet = prefSetService.selectByPrimaryKey(code);
		int result = 0;
		if(prefSet==null) {
			prefSet = new SystemPref();
			prefSet.setCode(code);
			prefSet.setName(name);
			prefSet.setValue(newFileUrl);
			prefSet.setModifiedDate(new Date());
			result = prefSetService.insertSelective(prefSet, request);
		} else {
			prefSet.setValue(newFileUrl);
			prefSet.setModifiedDate(new Date());
			result = prefSetService.updateByPrimaryKeySelective(prefSet, request);
		}
		logger.info("背景图结果:{}",result>0?"success":"fail");
		if(result>0) {
			return "1";
		}
		return "0";
	}
}
