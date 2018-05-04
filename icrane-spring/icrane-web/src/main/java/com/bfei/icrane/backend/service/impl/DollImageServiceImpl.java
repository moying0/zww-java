package com.bfei.icrane.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfei.icrane.backend.service.DollImageService;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.dao.DollImageDao;
import com.bfei.icrane.core.models.DollImage;
import com.bfei.icrane.core.models.User;
import com.bfei.icrane.web.utils.Const;
@Service("DollImageService")
public class DollImageServiceImpl implements DollImageService {
	@Autowired
	private DollImageDao dollImageDao;
	@Override
	public PageBean<DollImage> getImageList(int page, int pageSize,String name) {
		PageBean<DollImage> pageBean = new PageBean<DollImage>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount = 0;
		totalCount=dollImageDao.totalCount(name);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<DollImage> list = dollImageDao.getImageList(begin, pageSize,name);
		pageBean.setList(list);
		int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
		int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
		pageBean.setStart(start);
		pageBean.setEnd(end);
		return pageBean;
	}
	
	@Override
	public int totalCount(String name) {
		return dollImageDao.totalCount(name);
	}

	@Override
	public DollImage getImageById(Integer id) {
		return dollImageDao.getImageById(id);
	}

	@Transactional
	public int insertSelective(DollImage dollImage,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			dollImage.setCreatedBy(user.getId());
			dollImage.setModifiedBy(user.getId());
		}
		dollImage.setCreatedDate(new Date());
		dollImage.setModifiedDate(new Date());
		return dollImageDao.insertSelective(dollImage);
	}

	@Override
	public int deleteById(Integer id) {
		return dollImageDao.deleteById(id);
	}

	@Override
	public int updateImage(DollImage dollImage,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		if(user!=null) {
			dollImage.setModifiedBy(user.getId());
		}
		dollImage.setModifiedDate(new Date());
		return dollImageDao.updateImage(dollImage);
	}

	@Override
	public int deleteAllById(List<String> id) {
		return dollImageDao.deleteAllById(id);
	}
}
