package com.bfei.icrane.backend.controller;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.backend.service.ChargeRulesService;
import com.bfei.icrane.common.util.*;
import com.bfei.icrane.core.models.ChargeRules;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.service.impl.AliyunServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfei.icrane.backend.service.BannerService;
import com.bfei.icrane.core.models.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author perry
 * @version V1.0
 * @ClassName: DollManageController
 * @Description: 娃娃机管理控制层
 * @date 2017年10月19日 上午9:33:35
 */
@Controller
@RequestMapping("/bannerManage")
public class BannerController {
    private static final Logger logger = LoggerFactory.getLogger(BannerController.class);
    @Autowired
    private BannerService bannerService;

    @Autowired
    private ChargeRulesService chargeRulesService;

    private static PropFileManager prop = new PropFileManager("interface.properties");

    RedisUtil redisUtil = new RedisUtil();

    @RequestMapping("/list")
    public String list(String name, @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize, HttpServletRequest request) throws Exception {
        logger.info("查询广告列表输入参数:name={},page={},pageSize={}", name, page, pageSize);
        try {
            PageBean<Banner> pageBean = bannerService.selectBannerList(page, pageSize);
            logger.info("查询广告列表结果:{}", pageBean.getList().toString());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("name", name);
            return "banner/banner_list";
        } catch (Exception e) {
            logger.error("查询广告列表SystemError:" + e);
            throw e;
        }
    }

    @RequestMapping("/bannerToAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        List<ChargeRules> chargeRules = chargeRulesService.selectChargeRules();
        request.setAttribute("chargeRules", chargeRules);
        return "banner/banner_add";
    }

    @RequestMapping(value = "/bannerAdd", method = RequestMethod.POST)
    @ResponseBody
    public String bannerAdd(Integer linkType, Integer payIndex, String description, String type, String hyperlink, Integer sorts, String validStartDate, String validEndDate) throws Exception {
        Banner banner = new Banner();
        banner.setDescription(description);
        banner.setType(type);
        banner.setHyperlink(hyperlink);
        banner.setSorts(sorts);
        banner.setPayIndex(payIndex);
        banner.setLinkType(linkType);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        banner.setValidStartDate(sdf.parse(validStartDate));
        banner.setValidEndDate(sdf.parse(validEndDate));
        System.out.println(hyperlink + ",");
        logger.info("新增广告传入参数：{}", banner.toString());
        System.out.println(hyperlink + "," + validStartDate);
        try {
            int result = bannerService.insertSelective(banner);
            logger.info("新增广告结果:{}", result > 0 ? "success" : "fail");
            if (result > 0) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error("新增广告SystemError：" + e);
            throw e;
        }
    }

    /**
     * @Title: dollDel
     * @Description: 删除娃娃机
     */
    @RequestMapping(value = "/bannerDel", method = RequestMethod.POST)
    @ResponseBody
    public String bannerDel(Integer bannerId) throws Exception {
        logger.info("删除广告id：{}", bannerId);
        try {
            int result = bannerService.bannerDel(bannerId);
            logger.error("删除广告结果：{}", result > 0 ? "success" : "fail");
            if (result > 0) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error("删除广告SystemError：" + e);
            throw e;
        }
    }

    @RequestMapping("/toEditbanner")
    public String toEditDoll(Integer id, HttpServletRequest request) throws
            Exception {
        logger.info("跳转编广告id:{}", id);
        try {
            List<ChargeRules> chargeRules = chargeRulesService.selectChargeRules();
            Banner banner = bannerService.selectBannerById(id);
            logger.info("编辑广告查询:{}", banner.toString());
            request.setAttribute("chargeRules", chargeRules);
            request.setAttribute("banner", banner);
            return "banner/banner_update";
        } catch (Exception e) {
            logger.error("编辑广告SystemError：" + e);
            throw e;
        }
    }

    /**
     * 更新娃娃机
     */
    @RequestMapping(value = "/bannerUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String dollUpdate(Integer linkType, Integer payIndex, String id, String description, String type, Integer sorts, String hyperlink, String validStartDate, String validEndDate) throws Exception {
        Banner banner = new Banner();
        banner.setId(Integer.parseInt(id));
        banner.setDescription(description);
        banner.setType(type);
        banner.setHyperlink(hyperlink);
        banner.setSorts(sorts);
        banner.setPayIndex(payIndex);
        banner.setLinkType(linkType);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        banner.setValidStartDate(sdf.parse(validStartDate));
        banner.setValidEndDate(sdf.parse(validEndDate));
        logger.info("更新广告传入参数doll：{}", banner.toString());
        try {
            int result = bannerService.updateByPrimaryKeySelective(banner);
            logger.info("更新广告结果：{}", result > 0 ? "success" : "fail");
            if (result > 0) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error("更新广告SystemError：" + e);
            throw e;
        }
    }

    /**
     * 跳转上传头像
     */
    @RequestMapping("/toUpload")
    public String toUpload(Banner banner, HttpServletRequest request) throws Exception {
        logger.info("跳转上传广告图片页面");
        try {
            Banner b = bannerService.selectById(banner);
            logger.info("广告图片查询:{}", banner.toString());
            System.out.println(b.getImageUrl().length() < 10);
            if (b.getImageUrl().length() < 10) {
                request.setAttribute("imgPath", "1");
            } else {
                request.setAttribute("imgPath", b.getImageUrl());
            }

            request.setAttribute("bannerId", banner.getId());
            return "banner/banner_upload";
        } catch (Exception e) {
            logger.error("跳转上传广告页面SystemError：" + e);
            throw e;
        }
    }

    /**
     * 广告上传
     */
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file, Banner banner)
            throws Exception {
//	 Banner banner = new Banner();
//	 banner.setId(Integer.parseInt(id));
        logger.info("上传广告输入参数:{}", banner.toString());
        String originalFileName = file.getOriginalFilename();
        // 获取后缀
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")
                + 1);
        // 修改后完整的文件名称
        String fileKey = StringUtils.getRandomUUID();
        String NewFileKey = fileKey + "." + suffix;
        byte[] bytes = file.getBytes();
        InputStream fileInputStream = new ByteArrayInputStream(bytes);
        String bukectName = prop.getProperty("aliyun.ossBucketName");
        logger.info("bukectName:{}", bukectName);
        if (!AliyunServiceImpl.getInstance().putFileStreamToOSS(bukectName,
                NewFileKey, fileInputStream)) {
            return "0";
        }
        Banner d = bannerService.selectById(banner);
        logger.info("广告参数:{}", d.toString());
        if (d.getImageUrl() != null && d.getImageUrl().equals("") == false && d.getImageUrl().length() > 10) {
            String
                    oldFileKey = d.getImageUrl().substring(d.getImageUrl().lastIndexOf("/") + 1,
                    d.getImageUrl().lastIndexOf("."));
            //如果有则删除原来的头像
            if (!"".equals(oldFileKey) && oldFileKey != null) {
                logger.info("删除广告: " + d.getId() + "原来的头像从阿里云OSS:" +
                        bukectName + "文件名:" + oldFileKey);
                AliyunServiceImpl.getInstance().deleteFileFromOSS(bukectName, oldFileKey);
            }
        }
        String newFileUrl =
                AliyunServiceImpl.getInstance().generatePresignedUrl(bukectName, NewFileKey,
                        1000000).toString();
        d.setImageUrl(newFileUrl);
        logger.info("更新广告头像结果:{}", newFileUrl);
        int result = bannerService.updateByPrimaryKeySelective(d);
        logger.info("更新广告头像结果:{}", result > 0 ? "success" : "fail");
        if (result > 0) {
            return "1";
        }
        return "0";
    }
}
