package com.bfei.icrane.backend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bfei.icrane.core.models.SystemPref;

public interface PrefSetService {
	public List<SystemPref> selectAll();
	public SystemPref selectByPrimaryKey(String code);
	public int updateByPrimaryKeySelective(SystemPref record,HttpServletRequest request);
	public int insertSelective(SystemPref record,HttpServletRequest request);
	public int deleteByPrimaryKey(String code);
}	
