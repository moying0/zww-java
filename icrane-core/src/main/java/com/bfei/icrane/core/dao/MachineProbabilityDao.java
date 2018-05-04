package com.bfei.icrane.core.dao;

import org.apache.ibatis.annotations.Param;

import com.bfei.icrane.core.models.MachineProbability;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author konghuanhuan
 * @since 2018-01-29
 */
public interface MachineProbabilityDao {

	MachineProbability findByDollId(@Param("dollId") Integer dollId);
	
	Integer findMemberCharge(@Param("userId") Integer userId);

}