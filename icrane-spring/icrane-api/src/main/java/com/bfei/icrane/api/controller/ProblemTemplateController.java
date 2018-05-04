package com.bfei.icrane.api.controller;

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
import com.bfei.icrane.core.models.ProblemTemplate;

@Controller
@RequestMapping("/proTemp")
@CrossOrigin
public class ProblemTemplateController {
	private static final Logger logger = LoggerFactory.getLogger(ProblemTemplateController.class);
	@Autowired
	private ProblemTemplateService problemTemplateService;
	@RequestMapping(value="/getProblems",method=RequestMethod.POST)
	@ResponseBody
	public IcraneResult getProblems() throws Exception{
		List<ProblemTemplate> list = problemTemplateService.select();
		if(list!=null&&list.size()>0) {
			logger.info("获取问题类别:"+list.toString());
			return IcraneResult.ok(list);
		}
		logger.info("获取问题类别出错:list为空");
		return IcraneResult.build(Enviroment.RETURN_FAILE, Enviroment.RETURN_FAILE_CODE, "操作失败");
	}
}
