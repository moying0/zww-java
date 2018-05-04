package com.bfei.icrane.core.dao;
import java.util.List;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.vo.MemberFeedbackAll;
import org.apache.ibatis.annotations.Param;
import com.bfei.icrane.core.models.SrvReq;
/**
 * @ClassName: SrvReqDao 
 * @Description: 工单Dao
 * @author perry 
 * @date 2017年9月27日 下午2:15:51 
 * @version V1.0
 */
public interface SrvReqDao {
	int insert(SrvReq sr);
	int insertSelective(SrvReq sr);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(SrvReq sr);
	int updateByPrimaryKey(SrvReq sr);
	List<SrvReq> select(@Param("createdBy") int createdBy,@Param("page") int page, @Param("pageSize") int pageSize);
	SrvReq selectByPrimaryKey(Integer id);
	int count();

	List<MemberFeedbackAll> selectAll(@Param("memberId") String memberId, @Param("page") int page, @Param("pageSize") int pageSize);
	int totalCount(@Param("memberId") String memberId);
}
