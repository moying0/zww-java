package com.bfei.icrane.weixin.service.impl;


import com.bfei.icrane.core.dao.ClientDao;
import com.bfei.icrane.core.models.Client;
import com.bfei.icrane.weixin.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientDao clientMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Client record) {
        return clientMapper.insert(record);
    }

    @Override
    public Client selectByPrimaryKey(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Client> selectAll() {
        return clientMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Client record) {
        return clientMapper.updateByPrimaryKey(record);
    }

    /*@Override
    public PageResult query(QueryObject qo) {
        int count = clientMapper.query4count(qo);
        if (count ==0){
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Client> list = clientMapper.query4list(qo);
        return new PageResult(count,list);
    }*/

    @Override
    public void unConcerned(String openid) {
        Client c = new Client();
        c.setCancelconcerntime(new Date());
        c.setStatus(false);
        c.setOpenid(openid);
        clientMapper.unConcerned(c);
    }

    @Override
    public void deleteByFromUserName(String fromUserName) {
        clientMapper.deleteByFromUserName(fromUserName);
    }
    @Override
    public Client selectByOpenId(String openid) {
        return clientMapper.selectByOpenId(openid);
    }


}
