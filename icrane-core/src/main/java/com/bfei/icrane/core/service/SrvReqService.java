package com.bfei.icrane.core.service;

import java.util.List;

import com.bfei.icrane.core.models.MemberFeedback;
import com.bfei.icrane.core.models.vo.MemberFeedbackAll;
import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.SrvReq;

/**
 * @ClassName: SrvReqService 
 * @Description: 工单Service
 * @author perry 
 * @date 2017年9月27日 下午2:20:41 
 * @version V1.0
 */
public interface SrvReqService {
	public int insert(SrvReq sr);
	public int insertSelective(SrvReq sr);
	public int deleteByPrimaryKey(Integer id);
	public int updateByPrimaryKeySelective(SrvReq sr);
	public int updateByPrimaryKey(SrvReq sr);
	public PageBean<SrvReq> select(int createdBy,int page,int pageSize);
	public PageBean<MemberFeedbackAll> selectAll(String memberId, int page, int pageSize);
	public SrvReq selectByPrimaryKey(Integer id);
	public int count();

}
