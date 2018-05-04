package com.bfei.icrane.core.service;

import com.bfei.icrane.core.models.DollInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by SUN on 2018/3/6.
 */
public interface DollInfoService {

    List<DollInfo> selectByLikeDollCode(Set<String> likeDollCode);

}
