package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.core.dao.DivinationDao;
import com.bfei.icrane.core.models.DivinationImage;
import com.bfei.icrane.core.models.DivinationTopic;
import com.bfei.icrane.core.service.DivinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SUN on 2018/2/6.
 */
@Service("DivinationService")
@Transactional
public class DivinationServiceImpl implements DivinationService {

    @Autowired
    private DivinationDao divinationDao;

    @Override
    public Integer getDivinationIdByDollId(Integer dollId) {
        return divinationDao.getDivinationIdByDollId(dollId);
    }

    @Override
    public DivinationTopic getByDollId(Integer dollId) {
        return divinationDao.getByDollId(dollId);
    }

    @Override
    public DivinationImage divination(int id) {
        return divinationDao.divination(id);
    }

}
