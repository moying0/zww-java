package com.bfei.icrane.backend.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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

import com.bfei.icrane.backend.service.DollImageService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.common.util.PropFileManager;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollImage;
import com.bfei.icrane.core.service.DollService;
import com.bfei.icrane.core.service.impl.AliyunServiceImpl;


@Controller
@RequestMapping("/dollImageManage")
public class DollImageController {
	private static final Logger logger = LoggerFactory.getLogger(DollImageController.class);
	@Autowired
	private DollImageService dollImageService;
	@Autowired
	private DollService dollService;
	
	private static PropFileManager prop=new PropFileManager("interface.properties");
	@RequestMapping("/list")
	public String list(Integer doll_id,String name,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer pageSize,HttpServletRequest request) throws Exception{
		logger.info("查询娃娃机背景图列表输入参数:doll_id={},name={},page={},pageSize={}",doll_id,name,page,pageSize);
		//查询所有娃娃机
		try {
			PageBean<DollImage> pageBean = dollImageService.getImageList(page, pageSize,name);
			logger.info("查询结果:{}",pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("name", name);
			request.setAttribute("doll_id", doll_id==null?0:doll_id);
			return "doll/doll_image_list";
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询娃娃机背景图系统错误:"+e);
			throw e;
		}
	}
	
	@RequestMapping("/newImageToAdd")
	public String toAdd(Integer doll_id,String name,HttpServletRequest request)throws Exception{
		logger.info("doll_id={},name={}",doll_id,name);
		try {
			 List<Doll> allDollList = dollService.allDollList();
			 logger.info("查询所有娃娃机名字:{}",allDollList.toString());
			 request.setAttribute("dollList", allDollList);
			 request.setAttribute("name", name);
			 request.setAttribute("doll_id", doll_id==null?0:doll_id);
			 return "doll/doll_image_add";
		} catch (Exception e) {
			logger.error("新增图片查询娃娃机系统错误:"+e);
			throw e;
		}
	}
	
	/**
	 * 娃娃机头像上传
	 */
	@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("file") MultipartFile[] files,Integer dollId,HttpServletRequest request) throws Exception{
		logger.info("上传头像输入参数:{}",dollId);
		int result = 0;
		DollImage dollImage = new DollImage();
		if(dollId==null) {
			return "0";
		}
		if(files != null){
			for (MultipartFile file:files) {
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
				Doll doll = new Doll();
				doll.setId(dollId);
				dollImage.setDoll(doll);
				String newFileUrl = AliyunServiceImpl.getInstance().generatePresignedUrl(bukectName, NewFileKey, 1000000).toString();
				dollImage.setImgRealPath(newFileUrl);
				result = dollImageService.insertSelective(dollImage,request);
				logger.info("添加娃娃机背景图结果:{}",result>0?"success":"fail");
			}
		}
		if(result>0) {
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value="/imageDel",method=RequestMethod.POST)
	@ResponseBody
	public String imageDel(Integer id) throws Exception{
		if(id==null) {
			return "0";
		}
		logger.info("删除娃娃机背景图id：{}",id);
		try {
			DollImage image = dollImageService.getImageById(id);
			logger.info("查询图片地址结果:{}",image.getImgRealPath());
			int result = dollImageService.deleteById(id);
			logger.error("删除娃娃机背景图片结果：{}",result>0?"success":"fail");
			if(result>0) {
				String bukectName=prop.getProperty("aliyun.ossBucketName");
				logger.info("bukectName:{}",bukectName);
				if(image.getImgRealPath()!=null&&image.getImgRealPath().equals("")==false&&image.getImgRealPath().length()>10) {
					String oldFileKey=image.getImgRealPath().substring(image.getImgRealPath().lastIndexOf("/")+1, image.getImgRealPath().lastIndexOf("."));
					//如果有则删除原来的头像
					if(!"".equals(oldFileKey) && oldFileKey!=null) {
						logger.info("删除娃娃机image: "+id+"原来的头像从阿里云OSS:"+ bukectName+"文件名:"+oldFileKey);
						AliyunServiceImpl.getInstance().deleteFileFromOSS(bukectName, oldFileKey);
					}
				}
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除娃娃机SystemError："+e);
			throw e;
		}
	}

	@RequestMapping(value="/imageDelAll",method=RequestMethod.POST)
	@ResponseBody
	public String imageDelAll(String ids) throws Exception{
		String[] idsAll = null;
		//存放id集合
		List<String> idsString = new ArrayList<>();
		if(ids != null) {
			 idsAll = ids.split(",");
		}
		logger.info("删除娃娃机背景图id：{}",ids);
		try {
			Integer id = null;
			//图片路径集合
			List<DollImage> images = new ArrayList<>();
			for (String imgId : idsAll) {
				idsString.add(imgId);
				if (imgId != null){
					id = Integer.parseInt(imgId);
					DollImage image = dollImageService.getImageById(id);
					logger.info("查询图片地址结果:{}",image.getImgRealPath());
					images.add(image);
				}
			}
			//批量删除id的数据
			int result = dollImageService.deleteAllById(idsString);
			logger.error("删除娃娃机背景图片结果：{}",result>0?"success":"fail");
			if(result>0) {
				for (DollImage image : images) {
					String bukectName=prop.getProperty("aliyun.ossBucketName");
					logger.info("bukectName:{}",bukectName);
					if(image.getImgRealPath()!=null&&image.getImgRealPath().equals("")==false&&image.getImgRealPath().length()>10) {
						String oldFileKey=image.getImgRealPath().substring(image.getImgRealPath().lastIndexOf("/")+1, image.getImgRealPath().lastIndexOf("."));
						//如果有则删除原来的头像
						if(!"".equals(oldFileKey) && oldFileKey!=null) {
							logger.info("删除娃娃机image: "+id+"原来的头像从阿里云OSS:"+ bukectName+"文件名:"+oldFileKey);
							AliyunServiceImpl.getInstance().deleteFileFromOSS(bukectName, oldFileKey);
						}
					}
				}
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除娃娃机SystemError："+e);
			throw e;
		}
	}
	
	/**
	 * 跳转修改图片
	 */
	@RequestMapping("/toUpload")
	public String toUpload(Integer id,HttpServletRequest request)throws Exception{
		if(id==null) {
			return "404";
		}
		logger.info("跳转修改图片页面:id={}",id);
		try {
			DollImage image = dollImageService.getImageById(id);
			logger.info("娃娃机背景图查询:{}",image.getImgRealPath());
			if(image.getImgRealPath().length()<10) {
				request.setAttribute("imgPath", "1");
			}else {
				request.setAttribute("imgPath", image.getImgRealPath());
			}
			request.setAttribute("imageId",id);
			return "doll/doll_image_upload";
		} catch (Exception e) {
			logger.error("跳转修改图片页面SystemError："+e);
			throw e;
		}
	}
	
	/**
	 * 娃娃机头像上传
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("file") MultipartFile file,DollImage dollImage,HttpServletRequest request) throws Exception{
		logger.info("上传娃娃机背景图输入参数:id={},img={}",dollImage.getId(),dollImage.getImgRealPath());
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
		/*Doll d = dollService.selectById(doll);*/
		if(dollImage.getImgRealPath()!=null&&dollImage.getImgRealPath().equals("")==false&&dollImage.getImgRealPath().length()>10) {
		String oldFileKey=dollImage.getImgRealPath().substring(dollImage.getImgRealPath().lastIndexOf("/")+1,dollImage.getImgRealPath().lastIndexOf("."));
			//如果有则删除原来的头像
			if(!"".equals(oldFileKey) && oldFileKey!=null) {
				logger.info("删除娃娃机背景图image: "+dollImage.getId()+"原来的头像从阿里云OSS:"+ bukectName+"文件名:"+oldFileKey);
				AliyunServiceImpl.getInstance().deleteFileFromOSS(bukectName, oldFileKey);
			}
		}
		String newFileUrl = AliyunServiceImpl.getInstance().generatePresignedUrl(bukectName, NewFileKey, 1000000).toString();
		dollImage.setImgRealPath(newFileUrl);
		int result = dollImageService.updateImage(dollImage, request);
		logger.info("更新娃娃机背景图结果:{}",result>0?"success":"fail");
		if(result>0) {
			return "1";
		}
		return "0";
	}
	
}
