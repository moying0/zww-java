package com.bfei.icrane.core.service.impl;

import com.bfei.icrane.common.util.RedisKeyGenerator;
import com.bfei.icrane.common.util.RedisUtil;
import com.bfei.icrane.core.dao.DollInfoDao;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollInfo;
import com.bfei.icrane.core.service.CollectionService;
import com.bfei.icrane.core.service.DollInfoService;
import com.bfei.icrane.core.service.DollRoomNewService;
import com.bfei.icrane.core.service.DollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by SUN on 2018/1/10.
 */
@Service("CollectionService")
@Transactional
public class CollectionServiceImpl implements CollectionService {

    private RedisUtil redisUtil = new RedisUtil();
    @Autowired
    private DollRoomNewService dollRoomNewService;
    @Autowired
    private DollInfoService dollInfoService;

    @Override
    public int like(Integer memberId, String dollCode) {
        //检查用户是否已经收藏该娃娃
        boolean contains = redisUtil.sIsMember(RedisKeyGenerator.getLikeDollKey(memberId), dollCode);
        if (contains) {
            return -1;
        }
        DollInfo dollInfo = dollRoomNewService.selectDollInfoByDollCode(dollCode);
        if (dollInfo == null) {
            return -2;
        }
        int result = Math.toIntExact(redisUtil.addSet(RedisKeyGenerator.getLikeDollKey(memberId), dollCode));
        return result;
    }

    @Override
    public int disLike(Integer memberId, String[] dollCode) {
        //检查用户是否收藏该娃娃
        for (String s : dollCode) {
            boolean contains = redisUtil.sIsMember(RedisKeyGenerator.getLikeDollKey(memberId), s);
            if (!contains) {
                return -1;
            }
        }
        int result = Math.toIntExact(redisUtil.remSet(RedisKeyGenerator.getLikeDollKey(memberId), dollCode));
        return result;
    }

    @Override
    public List<DollInfo> likeList(Integer memberId) {
        Set<String> likeDollCodes = redisUtil.getSMembers(RedisKeyGenerator.getLikeDollKey(memberId));
        if (likeDollCodes.size() <= 0) {
            return null;
        }
        List<DollInfo> dollInfos = dollInfoService.selectByLikeDollCode(likeDollCodes);
        return dollInfos;
    }

}
