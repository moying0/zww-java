package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.ComplaintProblem;
import com.bfei.icrane.core.models.ProblemTemplate;

import java.util.List;

public interface ComplaintProblemDao {
	List<ComplaintProblem> queryList();
	int count();
	int insertService(ComplaintProblem complaintProblem);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(ComplaintProblem complaintProblem);
	ComplaintProblem selectByPrimaryKey(Integer id);
}
