package com.bfei.icrane.backend.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.core.models.*;
import com.bfei.icrane.core.service.ChargeOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bfei.icrane.backend.service.MemberManageService;
import com.bfei.icrane.backend.service.UserService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.common.util.RedisKeyGenerator;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.service.impl.AliyunServiceImpl;

@Controller
@RequestMapping("/memberManage")
public class MemberManageController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private MemberManageService memberService;

    @Autowired
    private ChargeOrderService chargeOrderService;

    @RequestMapping("/searchList")
    public String list(String endDate, String registerDate, String lastLoginFrom, String memberid, String name, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50") Integer pageSize, HttpServletRequest request) throws Exception {
        logger.info("查询用户列表输入参数:name={},page={},pageSize={}", name, page, pageSize);
        try {
            if ("".equals(endDate)) {
                endDate = null;
            }
            if ("".equals(registerDate)) {
                registerDate = null;
            }
            if ("".equals(lastLoginFrom)) {
                lastLoginFrom = null;
            }
            if ("".equals(memberid)) {
                memberid = null;
            }
            if ("".equals(name)) {
                name = null;
            }
            PageBean<Member> pageBean = memberService.getUserList1(page, pageSize, name, memberid, lastLoginFrom, registerDate, endDate);
            logger.info("查询用户列表结果:{}", pageBean.getList().toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("name", name);
            request.setAttribute("memberid", memberid);
            request.setAttribute("lastLoginFrom", lastLoginFrom);
            request.setAttribute("registerDate", registerDate);
            request.setAttribute("endDate", endDate);
            return "user/user_list";
        } catch (Exception e) {
            logger.error("查询用户列表SystemError:" + e);
            throw e;
        }
    }

	/*@RequestMapping("/newDollToAdd")
    public String toAdd()throws Exception{
		return "doll/doll_add";
	}
	@RequestMapping(value="/dollInsert",method=RequestMethod.POST)
	@ResponseBody
	public String dollInsert(Doll doll)throws Exception{
		logger.info("新增娃娃机传入参数：{}",doll.toString());
		try {
			int result = dollService.insertSelective(doll);
			logger.info("新增娃娃机结果:{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("新增娃娃机SystemError："+e);
			throw e;
		}
	}
	*/

    /**
     * @Title: dollDel
     * @Description: 删除娃娃机
     *//*
	@RequestMapping(value="/dollDel",method=RequestMethod.POST)
	@ResponseBody
	public String dollDel(Doll doll) throws Exception{
		logger.info("删除娃娃机id：{}",doll.getId());
		try {
			int result = dollService.dollDel(doll);
			logger.error("删除娃娃机结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除娃娃机SystemError："+e);
			throw e;
		}
	}*/
    @RequestMapping("/toEditMember")
    public String toEditMember(Integer id, HttpServletRequest request) throws Exception {
        logger.info("跳转编辑用户id:{}", id);
        try {
            Member member = memberService.getMemberById(id);
            logger.info("编辑用户查询用户:{}", member != null ? member.toString() : "无此用户");
            request.setAttribute("member", member);
            return "user/user_edit";
        } catch (Exception e) {
            logger.error("编辑用户SystemError：" + e);
            throw e;
        }

    }

    //充值记录
    @RequestMapping("/listCharge")
    public String listCharge(Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50") Integer pageSize, HttpServletRequest request) throws Exception {
        logger.info("查询用户列表输入参数:id={},page={},pageSize={}", id, page, pageSize);
        try {
            Double sumMoney = chargeOrderService.selectChargeNumByUserid(id);
            PageBean<ChargeOrder> pageBean = chargeOrderService.selectChargeOrderByUserid(page, pageSize, id);
            logger.info("查询用户充值列表结果:{}", pageBean.getList().toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("id", id);
            request.setAttribute("sumMoney", sumMoney);
            return "user/user_charge_list";
        } catch (Exception e) {
            logger.error("查询用户充值列表SystemError:" + e);
            throw e;
        }
    }

    @RequestMapping("/listCatch")
    public String listCatch(Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50") Integer pageSize, HttpServletRequest request) throws Exception {
        logger.info("查询用户列表输入参数:id={},page={},pageSize={}", id, page, pageSize);
        try {
            PageBean<CatchHistory> pageBean = memberService.getCatchHistory(id, page, pageSize);
            logger.info("查询用户抓取列表结果:{}", pageBean.getList().toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("id", id);
            return "user/user_catch_list";
        } catch (Exception e) {
            logger.error("查询用户抓取列表SystemError:" + e);
            throw e;
        }
    }


    /**
     * 用户更新
     *
     * @param
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String memberUpdate(Account account, HttpServletRequest request) throws Exception {
        logger.info("更新用户传入参数member：{}", account != null ? account.toString() : null);
        try {
            int result = memberService.updateBySelective(account, request);
            logger.info("更新用户结果：{}", result > 0 ? "success" : "fail");
            if (result > 0) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error("更新用户SystemError：" + e);
            throw e;
        }
    }
	/*
	*//**
     * 跳转上传头像
     *//*
	@RequestMapping("/toUpload")
	public String toUpload(Doll doll,HttpServletRequest request)throws Exception{
		logger.info("跳转上传头像页面");
		try {
			Doll d = dollService.selectById(doll);
			logger.info("娃娃机头像查询:{}",doll.toString());
			if(d.getTbimgRealPath().length()<10) {
				request.setAttribute("imgPath", "1");
			}else {
				request.setAttribute("imgPath", d.getTbimgRealPath());
			}
			
			request.setAttribute("dollId", doll.getId());
			return "doll/doll_upload";
		} catch (Exception e) {
			logger.error("跳转上传头像页面SystemError："+e);
			throw e;
		}
	}
	*//**
     * 娃娃机头像上传
     *//*
	@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("file") MultipartFile file,Doll doll) throws Exception{
		logger.info("上传头像输入参数:{}",doll.toString());
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
		Doll d = dollService.selectById(doll);
		if(d.getTbimgRealPath()!=null&&d.getTbimgRealPath().equals("")==false&&d.getTbimgRealPath().length()>10) {
		String oldFileKey=d.getTbimgRealPath().substring(d.getTbimgRealPath().lastIndexOf("/")+1, d.getTbimgRealPath().lastIndexOf("."));
			//如果有则删除原来的头像
			if(!"".equals(oldFileKey) && oldFileKey!=null) {
				logger.info("删除娃娃机doll: "+d.getId()+"原来的头像从阿里云OSS:"+ bukectName+"文件名:"+oldFileKey);
				AliyunServiceImpl.getInstance().deleteFileFromOSS(bukectName, oldFileKey);
			}
		}
		String newFileUrl = AliyunServiceImpl.getInstance().generatePresignedUrl(bukectName, NewFileKey, 1000000).toString();
		d.setTbimgRealPath(newFileUrl);
		int result = dollService.updateByPrimaryKeySelective(d);
		logger.info("更新娃娃机头像结果:{}",result>0?"success":"fail");
		if(result>0) {
			return "1";
		}
		return "0";
	}*/
}

