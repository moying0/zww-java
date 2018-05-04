package com.bfei.icrane.api.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfei.icrane.api.service.ProblemTemplateService;
import com.bfei.icrane.common.util.Enviroment;
import com.bfei.icrane.common.util.IcraneResult;
import com.bfei.icrane.core.models.ComplaintProblem;
import com.bfei.icrane.core.models.MemberComplaint;
import com.bfei.icrane.core.models.ProblemTemplate;
import com.bfei.icrane.core.models.vo.MemberComplaintAll;
import com.bfei.icrane.core.service.ComplaintProblemService;
import com.bfei.icrane.core.service.MemberComplaintService;
import com.bfei.icrane.core.service.ValidateTokenService;

/**
 * 用户申诉
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/complain")
@CrossOrigin
public class ComplainController {
    private static final Logger logger = LoggerFactory.getLogger(ComplainController.class);
    @Autowired
    ComplaintProblemService complaintProblemService;
    @Autowired
    MemberComplaintService memberComplaintService;
    @Autowired
    ValidateTokenService validateTokenService;

    @RequestMapping(value = "/problems", method = RequestMethod.POST)
    @ResponseBody
    public IcraneResult complainProblems() throws Exception {
        List<ComplaintProblem> list = complaintProblemService.queryList();
        if (list != null && list.size() > 0) {
            logger.info("获取问题类别:" + list.toString());
            return IcraneResult.ok(list);
        }
        logger.info("获取问题类别出错:list为空");
        return IcraneResult.build(Enviroment.RETURN_FAILE, Enviroment.RETURN_FAILE_CODE, "操作失败");
    }

    @RequestMapping(value = "/commitProblem", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public IcraneResult commitProblem(String gameNum, Integer userId, String memberId, Integer dollId, Integer historyId, String complaintReason, String token) throws Exception {
        try {
            //验证token有效性
            if (token == null || "".equals(token) ||
                    !validateTokenService.validataToken(token, userId)) {
                return IcraneResult.build(Enviroment.RETURN_FAILE, Enviroment.RETURN_UNAUTHORIZED_CODE, Enviroment.RETURN_UNAUTHORIZED_MESSAGE);
            }
            if (memberComplaintService.selectMemberComplaintByHistoryId(historyId) > 0) {
                logger.info("提交申诉出错:重复提交申诉");
                return IcraneResult.build(Enviroment.RETURN_FAILE, Enviroment.RETURN_FAILE_CODE, "请勿重复申诉");
            }
            MemberComplaint complaint = new MemberComplaint();
            complaint.setGameNum(gameNum);
            complaint.setMemberId(userId);
            complaint.setMemberNum(memberId);
            complaint.setDollId(dollId);
            complaint.setMemberCatchId(historyId);
            complaint.setComplaintReason(complaintReason);
            complaint.setCreatDate(new Date());
            complaint.setCheckState(0);
            Integer result = memberComplaintService.insert(complaint);
            if (result > 0) {
                return IcraneResult.ok();
            }
            logger.info("获取问题类别出错:list为空");
            return IcraneResult.build(Enviroment.RETURN_FAILE, Enviroment.RETURN_FAILE_CODE, "操作失败");
        } catch (Exception e) {
            logger.error("提交申诉异常", e);
            throw e;
        }
    }
}
