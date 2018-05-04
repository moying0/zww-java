package com.bfei.icrane.core.dao;

import java.util.List;

import com.bfei.icrane.core.models.ScrollingBanner;
import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.Banner;

/**
 * @author lgq
 *         Version: 1.0
 *         Date: 2017/9/25
 *         Description: 用户Dao接口类.
 *         Copyright (c) 2017 伴飞网络. All rights reserved.
 */
public interface BannerDao {

    List<Banner> selectBannerList(@Param("begin") int begin, @Param("pageSize") int pageSize);

    int totalCount();

    int insertSelective(Banner record);

    int bannerDel(Integer id);

    Banner selectBannerById(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    Banner selectById(Banner record);

    List<ScrollingBanner> selectscrollingBanner();

    /**
     * 根据类型查询有效banner
     *
     * @return
     */
    List<Banner> selectActiveBannerByTypeAndPackageName(@Param("packageName") int packageName, @Param("type") String[] type);

}
