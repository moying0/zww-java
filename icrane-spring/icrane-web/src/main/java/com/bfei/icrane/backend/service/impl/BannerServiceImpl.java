package com.bfei.icrane.backend.service.impl;

import java.util.Date;
import java.util.List;


import com.bfei.icrane.core.models.User;
import com.bfei.icrane.web.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfei.icrane.backend.service.BannerService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.BannerDao;
import com.bfei.icrane.core.models.Banner;

import javax.servlet.http.HttpServletRequest;

@Service("BannerService")
public class  BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDao bannerDao;

	@Override
	public PageBean<Banner> selectBannerList(int page,int pageSize) {
		PageBean<Banner> pageBean = new PageBean<Banner>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=bannerDao.totalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Banner> list = bannerDao.selectBannerList(begin, pageSize);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}

	@Override
	public int insertSelective(Banner record) {
		// TODO Auto-generated method stub
		record.setImageUrl("1");
		record.setActiveFlg(true);
		record.setCreatedDate(new Date());
		record.setModifiedDate(new Date());
		return bannerDao.insertSelective(record);
	}


	@Override
	public int bannerDel(Integer id) {
		return bannerDao.bannerDel(id);
	}

	@Override
	public Banner selectBannerById(Integer id) {
		return bannerDao.selectBannerById(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Banner record) {
		return bannerDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Banner selectById(Banner record) {
		return bannerDao.selectById(record);
	}
}
