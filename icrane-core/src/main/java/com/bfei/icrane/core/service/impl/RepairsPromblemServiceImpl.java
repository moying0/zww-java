package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.common.util.ResultMap;
import com.bfei.icrane.core.dao.ComplaintProblemDao;
import com.bfei.icrane.core.dao.RepairsProblemDao;
import com.bfei.icrane.core.models.ComplaintProblem;
import com.bfei.icrane.core.models.DollRepairs;
import com.bfei.icrane.core.models.RepairsProblem;
import com.bfei.icrane.core.service.ComplaintProblemService;
import com.bfei.icrane.core.service.RepairsProblemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 申诉列表 on 2017-12-03.
 */

@Service("RepairsPromblemService")
public class RepairsPromblemServiceImpl implements RepairsProblemService {
    private static final Logger logger = LoggerFactory.getLogger(RepairsPromblemServiceImpl.class);

    @Autowired
    private RepairsProblemDao repairsProblemDao;

    @Override
    public PageBean<RepairsProblem> getComplaintProblemList(int page, int pageSize) {
        PageBean<RepairsProblem> pageBean = new PageBean<RepairsProblem>();
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        totalCount = repairsProblemDao.count();
        pageBean.setTotalCount(totalCount);
        int totalPage = 0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page - 1) * pageSize;
        List<RepairsProblem> list = repairsProblemDao.queryList();
        pageBean.setList(list);
        int start = page % 10 == 0 ? (page - 1) / 10 * 10 + 1 : page / 10 * 10 + 1;
        int end = page % 10 == 0 ? ((page - 1) / 10 * 10 + 10 > totalPage ? totalPage : (page - 1) / 10 * 10 + 10) : (page / 10 * 10 + 10 > totalPage ? totalPage : page / 10 * 10 + 10);
        pageBean.setStart(start);
        pageBean.setEnd(end);
        return pageBean;
    }

    @Override
    public Integer updateComplaintResult(RepairsProblem complaintProblem) {
        return repairsProblemDao.updateByPrimaryKeySelective(complaintProblem);
    }

    @Override
    public Integer insertComplaintResult(RepairsProblem complaintProblem) {
        return repairsProblemDao.insertService(complaintProblem);
    }

    @Override
    public Integer deleteByid(Integer id) {
        return repairsProblemDao.deleteByPrimaryKey(id);
    }

    @Override
    public RepairsProblem selectByPrimaryKey(Integer id) {
        return repairsProblemDao.selectByPrimaryKey(id);
    }

    @Override
    public List<RepairsProblem> queryList() {
        return repairsProblemDao.queryList();
    }

    @Override
    public ResultMap insertRepairs(Integer memberId, Integer dollId, String reason) {
        try {
            DollRepairs dollRepairs = new DollRepairs();
            dollRepairs.setUserId(memberId);
            dollRepairs.setDollId(dollId);
            dollRepairs.setRepairsReason(reason);
            dollRepairs.setCreateDate(new Date());
            dollRepairs.setModifyDate(new Date());
            repairsProblemDao.insertRepairs(dollRepairs);
            logger.info("报修接口成功");
            return new ResultMap("报修成功");
        } catch (Exception e) {
            logger.info("报修接口参数异常=" + e.getMessage());
            e.printStackTrace();
            return new ResultMap(Enviroment.ERROR_CODE, Enviroment.PAY_ERROR);
        }
    }
}
