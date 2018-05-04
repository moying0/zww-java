package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.Banner;

import javax.servlet.http.HttpServletRequest;

public interface BannerService {
	PageBean<Banner> selectBannerList(int page,int pageSize);
	
	int insertSelective(Banner record);
	int bannerDel(Integer id);
	Banner selectBannerById(Integer id);

	int updateByPrimaryKeySelective(Banner record);
	Banner selectById(Banner record);//查询图片
}
