package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.DivinationImage;
import com.bfei.icrane.core.models.DivinationTopic;

/**
 * Created by SUN on 2018/2/6.
 */
public interface DivinationDao {

    Integer getDivinationIdByDollId(Integer dollId);

    DivinationTopic getByDollId(Integer dollId);

    DivinationImage divination(int id);
}
