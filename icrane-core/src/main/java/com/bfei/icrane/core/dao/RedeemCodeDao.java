package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.Account;
import com.bfei.icrane.core.models.RedeemCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by SUN on 2018/1/10.
 */
public interface RedeemCodeDao {

    /**
     * 根据cdkey查询礼品码信息
     *
     * @param cdkey
     * @return
     */
    RedeemCode selectBycdkey(String cdkey);

    int updateById(RedeemCode redeemCode);

    /**
     * 保存礼品码
     *
     * @param redeemCode
     */
    void insert(RedeemCode redeemCode);

    /**
     * 根据礼包名称和用户id查询礼包信息
     *
     * @param name
     * @param memberId
     * @return
     */
    List<RedeemCode> selectByNameAndMemberId(@Param("name") String name, @Param("memberId") Integer memberId);
}
