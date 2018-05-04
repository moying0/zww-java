package com.bfei.icrane.core.dao;

import com.bfei.icrane.core.models.TModifyRecord;
import com.bfei.icrane.core.models.TModifyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TModifyRecordMapper {
    int countByExample(TModifyRecordExample example);

    int deleteByExample(TModifyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TModifyRecord record);

    int insertSelective(TModifyRecord record);

    List<TModifyRecord> selectByExample(TModifyRecordExample example);

    TModifyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TModifyRecord record, @Param("example") TModifyRecordExample example);

    int updateByExample(@Param("record") TModifyRecord record, @Param("example") TModifyRecordExample example);

    int updateByPrimaryKeySelective(TModifyRecord record);

    int updateByPrimaryKey(TModifyRecord record);
}