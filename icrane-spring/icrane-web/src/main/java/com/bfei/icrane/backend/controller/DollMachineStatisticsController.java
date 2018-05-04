package com.bfei.icrane.backend.controller;

import com.bfei.icrane.backend.service.DollOrderItemService;
import com.bfei.icrane.backend.service.StatisticsService;
import com.bfei.icrane.common.util.*;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.vo.DollMachineStatistics;
import com.bfei.icrane.core.service.DollService;
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

/**
 * @ClassName: DollManageController 
 * @Description: 娃娃机管理控制层
 * @author perry 
 * @date 2017年10月19日 上午9:33:35 
 * @version V1.0
 */
@Controller
@RequestMapping("/dollMachineStatisticsManage")
public class DollMachineStatisticsController {
	private static final Logger logger = LoggerFactory.getLogger(DollMachineStatisticsController.class);
	@Autowired
	private StatisticsService statisticsService;


	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer pageSize,HttpServletRequest request)throws Exception {
		logger.info("查询娃娃机统计列表输入参数:page={},pageSize={}",page,pageSize);
		try {
			PageBean<DollMachineStatistics> pageBean = statisticsService.getMachineStatisticsList(page, pageSize);
			logger.info("查询娃娃机统计列表结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean",pageBean);
			return "statistics/doll_machine_statistics_list";
		} catch (Exception e) {
			logger.error("查询娃娃机统计列表SystemError:"+e);
			throw e;
		}
	}


//	@RequestMapping("/newDollToAdd")
//	public String toAdd()throws Exception{
//		return "doll/doll_add";
//	}
//	@RequestMapping(value="/dollInsert",method=RequestMethod.POST)
//	@ResponseBody
//	public String dollInsert(Doll doll)throws Exception{
//		logger.info("新增娃娃机传入参数：{}",doll.toString());
//		try {
//			int result = dollService.insertSelective(doll);
//			logger.info("新增娃娃机结果:{}",result>0?"success":"fail");
//			if(result>0) {
//				return "1";
//			}else {
//				return "0";
//			}
//		} catch (Exception e) {
//			logger.error("新增娃娃机SystemError："+e);
//			throw e;
//		}
//	}
//	/**
//	* @Title: dollDel
//	* @Description: 删除娃娃机
//	 */
//	@RequestMapping(value="/dollDel",method=RequestMethod.POST)
//	@ResponseBody
//	public String dollDel(Doll doll) throws Exception{
//		logger.info("删除娃娃机id：{}",doll.getId());
//		try {
//			int result = dollService.dollDel(doll);
//			logger.error("删除娃娃机结果：{}",result>0?"success":"fail");
//			if(result>0) {
//				return "1";
//			}else {
//				return "0";
//			}
//		} catch (Exception e) {
//			logger.error("删除娃娃机SystemError："+e);
//			throw e;
//		}
//	}
//	@RequestMapping("/toEditDoll")
//	public String toEditDoll(Integer id,HttpServletRequest request) throws Exception{
//		logger.info("跳转编辑娃娃机id:{}",id);
//		try {
//			Doll d = new Doll();
//			d.setId(id);
//			Doll doll = dollService.selectById(d);
//			logger.info("编辑娃娃机查询娃娃机:{}",doll.toString());
//			request.setAttribute("doll", doll);
//			return "doll/doll_edit";
//		} catch (Exception e) {
//			logger.error("编辑娃娃机SystemError："+e);
//			throw e;
//		}
//
//	}
//	/**
//	 * 更新娃娃机
//	 */
//	@RequestMapping(value="/dollUpdate",method=RequestMethod.POST)
//	@ResponseBody
//	public String dollUpdate(Doll doll) throws Exception{
//		logger.info("更新娃娃机传入参数doll：{}",doll.toString());
//		try {
//			int result = dollService.updateByPrimaryKeySelective(doll);
//			logger.info("更新娃娃机结果：{}",result>0?"success":"fail");
//			if(result>0) {
//				redisUtil.setString(RedisKeyGenerator.getRoomStatusKey(doll.getId()),doll.getMachineStatus());
//				return "1";
//			}else {
//				return "0";
//			}
//		} catch (Exception e) {
//			logger.error("更新娃娃机SystemError："+e);
//			throw e;
//		}
//	}
//	/**
//	 * 跳转上传头像
//	 */
//	@RequestMapping("/toUpload")
//	public String toUpload(Doll doll,HttpServletRequest request)throws Exception{
//		logger.info("跳转上传头像页面");
//		try {
//			Doll d = dollService.selectById(doll);
//			logger.info("娃娃机头像查询:{}",doll.toString());
//			if(d.getTbimgRealPath().length()<10) {
//				request.setAttribute("imgPath", "1");
//			}else {
//				request.setAttribute("imgPath", d.getTbimgRealPath());
//			}
//
//			request.setAttribute("dollId", doll.getId());
//			return "doll/doll_upload";
//		} catch (Exception e) {
//			logger.error("跳转上传头像页面SystemError："+e);
//			throw e;
//		}
//	}
//	/**
//	 * 娃娃机头像上传
//	 */
//	@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
//	@ResponseBody
//	public String uploadImage(@RequestParam("file") MultipartFile file,Doll doll) throws Exception{
//		logger.info("上传头像输入参数:{}",doll.toString());
//		String originalFileName = file.getOriginalFilename();
//		// 获取后缀
//		String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//		// 修改后完整的文件名称
//		String fileKey = StringUtils.getRandomUUID();
//		String NewFileKey = fileKey + "." + suffix;
//		byte[] bytes = file.getBytes();
//		InputStream fileInputStream = new ByteArrayInputStream(bytes);
//		String bukectName=prop.getProperty("aliyun.ossBucketName");
//		logger.info("bukectName:{}",bukectName);
//		if(!AliyunServiceImpl.getInstance().putFileStreamToOSS(bukectName, NewFileKey, fileInputStream)) {
//			return "0";
//		}
//		Doll d = dollService.selectById(doll);
//		if(d.getTbimgRealPath()!=null&&d.getTbimgRealPath().equals("")==false&&d.getTbimgRealPath().length()>10) {
//		String oldFileKey=d.getTbimgRealPath().substring(d.getTbimgRealPath().lastIndexOf("/")+1, d.getTbimgRealPath().lastIndexOf("."));
//			//如果有则删除原来的头像
//			if(!"".equals(oldFileKey) && oldFileKey!=null) {
//				logger.info("删除娃娃机doll: "+d.getId()+"原来的头像从阿里云OSS:"+ bukectName+"文件名:"+oldFileKey);
//				AliyunServiceImpl.getInstance().deleteFileFromOSS(bukectName, oldFileKey);
//			}
//		}
//		String newFileUrl = AliyunServiceImpl.getInstance().generatePresignedUrl(bukectName, NewFileKey, 1000000).toString();
//		d.setTbimgRealPath(newFileUrl);
//		int result = dollService.updateByPrimaryKeySelective(d);
//		logger.info("更新娃娃机头像结果:{}",result>0?"success":"fail");
//		if(result>0) {
//			return "1";
//		}
//		return "0";
//	}
}
