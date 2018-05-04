package com.bfei.icrane.weixin.service;


import com.bfei.icrane.core.models.Client;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface IClientService {

    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    //PageResult query(QueryObject qo);
    //取消关注
    void unConcerned(String openid);

    Client selectByOpenId(String openid);

    void deleteByFromUserName(String fromUserName);
}
