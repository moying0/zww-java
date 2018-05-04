package com.bfei.icrane.core.dao;


import com.bfei.icrane.core.models.Client;

import java.util.List;

public interface ClientDao {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    //int query4count(QueryObject qo);

    //List<Client> query4list(QueryObject qo);


    void deleteByFromUserName(String fromUserName);

    void unConcerned(Client c);

    Client selectByOpenId(String openid);


}