package com.bfei.icrane.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.common.util.RedisUtil;
import com.bfei.icrane.common.util.ResultMap;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.core.models.ScrollingBanner;
import com.bfei.icrane.core.service.DollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.BannerService;
import com.bfei.icrane.core.dao.BannerDao;
import com.bfei.icrane.core.models.Banner;

/**
 * @author lgq Version: 1.0 Date: 2017年9月22日date Description: 用户Service接口实现类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
@Service("BannerService")
public class BannerServiceImpl implements BannerService {
    private static final Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);
    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<Banner> selectActiveBanner(Integer packageName) {
        String[] str = {Enviroment.BANNER0, Enviroment.BANNER1};
        if (packageName == null) {
            packageName = 1;
        }
        return bannerDao.selectActiveBannerByTypeAndPackageName(packageName, str);
    }

    /**
     * 获取滚动banner
     *
     * @return
     */
    @Override
    public ResultMap selectscrollingBanner() {
        RedisUtil redisUtil = new RedisUtil();
        //查询redis中的锁是否还在
        List<String> list = new ArrayList<>();
        if (StringUtils.isEmpty(redisUtil.getString("scrollingBanner"))) {
            //重新加锁
            redisUtil.setString("scrollingBanner", "1", 120);
            //没锁就从数据库中查询10条返回并插入redis
            List<ScrollingBanner> scrollingBanner = bannerDao.selectscrollingBanner();
            for (int i = 0; i < scrollingBanner.size(); i++) {
                list.add(scrollingBanner.get(i).toString());
                redisUtil.setString("scrollingBanner" + i, list.get(i), 36000);
            }
            if (20 - scrollingBanner.size() > 0) {
                for (int i = scrollingBanner.size(); i < 20; i++) {
                    list.add(redisUtil.getString("scrollingBanner" + i));
                }
            }
            logger.info("从数据库中获取滚动横幅成功");
            return new ResultMap(Enviroment.SCROLLINGBANNER_JDBC, list);
        } else {
            //有锁就从redis中读取
            for (int i = 0; i < 20; i++) {
                String s = redisUtil.getString("scrollingBanner" + i);
                list.add(s == null ? "" : s);
            }
            logger.info("滚动横幅成功");
            return new ResultMap(Enviroment.SCROLLINGBANNER_REDIS, list);
        }
    }

    /**
     * 查询启动页
     *
     * @return
     */
    @Override
    public ResultMap selectStartPage(Integer version) {
        String[] str = {Enviroment.STARTPAGE};
        if (version == null) {
            version = 1;
        }
        List<Banner> startPage = bannerDao.selectActiveBannerByTypeAndPackageName(version, str);
        if (startPage.size() > 0) {
            logger.info("查询启动页成功");
            return new ResultMap(Enviroment.RETURN_SUCCESS_MESSAGE, startPage);
        }
        return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.NO_STARTPAGE);
    }

    /**
     * 查询弹窗广告
     *
     * @return
     */
    @Override
    public ResultMap selectPopUpAd(Integer version) {
        String[] str = {Enviroment.POPUPAD};
        if (version == null) {
            version = 1;
        }
        List<Banner> popUpAd = bannerDao.selectActiveBannerByTypeAndPackageName(version, str);
        if (popUpAd.size() > 0) {
            logger.info("查询弹窗广告成功");
            return new ResultMap(Enviroment.RETURN_SUCCESS_MESSAGE, popUpAd);
        }
        return new ResultMap(Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.NO_POPUPAD);
    }
}
