package com.bfei.icrane.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfei.icrane.api.service.ProblemTemplateService;
import com.bfei.icrane.core.dao.ProblemTemplateDao;
import com.bfei.icrane.core.models.ProblemTemplate;
@Service("ProblemTemplateService")
public class ProblemTemplateServiceImpl implements ProblemTemplateService {
	private static final Logger logger = LoggerFactory.getLogger(ProblemTemplateServiceImpl.class);
	@Autowired
	private ProblemTemplateDao problemTemplateDao;
	@Override
	public List<ProblemTemplate> select() {
		List<ProblemTemplate> list = problemTemplateDao.select();
		logger.info("result list:{}",list);
		return list;
	}

}
