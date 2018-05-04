package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.vo.OutGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by webrx on 2017-12-08.
 */
public interface OutGoodsListDao {

    List<OutGoods> getOrdersByStatus(@Param("begin")int begin, @Param("pageSize")int pageSize, @Param("phone")String phone, @Param("memberId")String memberId);
    Integer totalCount(@Param("phone")String phone, @Param("memberId")String memberId);

    Integer dollOrderTotalCount(@Param("phone") String phone, @Param("outGoodsId") Integer outGoodsId);
    List<OutGoods> getOutOrdersByStatus(@Param("begin")int begin, @Param("pageSize")int pageSize, @Param("phone")String phone, @Param("outGoodsId")int outGoodsId);
}
