package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.common.util.StringUtils;
import com.bfei.icrane.common.util.TimeUtil;
import com.bfei.icrane.core.dao.*;
import com.bfei.icrane.core.models.*;
import com.bfei.icrane.core.models.vo.MemberComplaintAll;
import com.bfei.icrane.core.service.ComplaintProblemService;
import com.bfei.icrane.core.service.MemberComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 申诉列表 on 2017-12-03.
 */

@Service("ComplaintProblemService")
public class ComplaintPromblemServiceImpl implements ComplaintProblemService {

    @Autowired
    private ComplaintProblemDao complaintProblemDao;

    @Override
    public PageBean<ComplaintProblem> getComplaintProblemList(int page, int pageSize) {
        PageBean<ComplaintProblem> pageBean = new PageBean<ComplaintProblem>();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        totalCount=complaintProblemDao.count();
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page - 1) * pageSize;
        List<ComplaintProblem> list = complaintProblemDao.queryList();
        pageBean.setList(list);
        int start=page%10==0?(page-1)/10*10+1:page/10*10+1;
        int end=page%10==0?((page-1)/10*10+10>totalPage?totalPage:(page-1)/10*10+10):(page/10*10+10>totalPage?totalPage:page/10*10+10);
        pageBean.setStart(start);
        pageBean.setEnd(end);
        return pageBean;
    }

    @Override
    public Integer updateComplaintResult(ComplaintProblem complaintProblem) {
        return complaintProblemDao.updateByPrimaryKeySelective(complaintProblem);
    }

    @Override
    public Integer insertComplaintResult(ComplaintProblem complaintProblem) {
        return complaintProblemDao.insertService(complaintProblem);
    }

    @Override
    public Integer deleteByid(Integer id) {
        return complaintProblemDao.deleteByPrimaryKey(id);
    }

    @Override
    public ComplaintProblem selectByPrimaryKey(Integer id) {
        return complaintProblemDao.selectByPrimaryKey(id);
    }

	@Override
	public List<ComplaintProblem> queryList() {
		return complaintProblemDao.queryList();
	}
}
