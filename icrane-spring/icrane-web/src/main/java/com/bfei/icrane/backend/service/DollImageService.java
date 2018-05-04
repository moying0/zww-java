package com.bfei.icrane.backend.service;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.DollImage;

import java.util.List;

public interface DollImageService {
	public PageBean<DollImage> getImageList(int page,int pageSize,String name);
	public int totalCount(String name);
	public DollImage getImageById(Integer id);
	public int insertSelective(DollImage dollImage,HttpServletRequest request);
	public int deleteById(Integer id);
	public int updateImage(DollImage dollImage,HttpServletRequest request);

	public int deleteAllById(List<String> id);
}
