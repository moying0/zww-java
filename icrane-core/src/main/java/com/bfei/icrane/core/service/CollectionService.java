package com.bfei.icrane.core.service;

import com.bfei.icrane.core.models.DollInfo;

import java.util.List;

/**
 * Created by SUN on 2018/3/2.
 * 收藏相关服务类接口
 */
public interface CollectionService {

    int like(Integer memberId, String dollCode);

    int disLike(Integer memberId, String[] dollCode);

    List<DollInfo> likeList(Integer memberId);
}
