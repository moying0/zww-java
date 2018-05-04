package com.bfei.icrane.backend.service;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.DollRepairs;
import com.bfei.icrane.core.models.DollTopic;
import com.bfei.icrane.core.models.vo.DollRepairsAll;

import javax.servlet.http.HttpServletRequest;

public interface DollRepairsService {
	public PageBean<DollRepairsAll> getDollRepairsList(int page, int pageSize);

}
