package com.bfei.icrane.core.models;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class MachineProbability implements Serializable  {
	private static final long serialVersionUID = 996437218228835315L;
	/**
     * id
     */
	private Integer id;
    /**
     * 概率规则id
     */
	private Integer probabilityRulesId;
    /**
     * 机器id
     */
	private Integer dollId;
    /**
     * 概率1
     */
	private Double probability1;
    /**
     * 概率2
     */
	private Double probability2;
    /**
     * 概率3
     */
	private Double probability3;
	
	private Integer baseNum;
    /**
     * 创建时间
     */
	private Date createdDate;
    /**
     * 修改时间
     */
	private Date modifiedDate;
    /**
     * 创建人
     */
	private Integer createdBy;
    /**
     * 修改人
     */
	private Integer modifiedBy;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getProbabilityRulesId() {
		return probabilityRulesId;
	}


	public void setProbabilityRulesId(Integer probabilityRulesId) {
		this.probabilityRulesId = probabilityRulesId;
	}


	public Integer getDollId() {
		return dollId;
	}


	public void setDollId(Integer dollId) {
		this.dollId = dollId;
	}


	public Double getProbability1() {
		return probability1;
	}


	public void setProbability1(Double probability1) {
		this.probability1 = probability1;
	}


	public Double getProbability2() {
		return probability2;
	}


	public void setProbability2(Double probability2) {
		this.probability2 = probability2;
	}


	public Double getProbability3() {
		return probability3;
	}


	public void setProbability3(Double probability3) {
		this.probability3 = probability3;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public Integer getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public Integer getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Integer getBaseNum() {
		return baseNum;
	}


	public void setBaseNum(Integer baseNum) {
		this.baseNum = baseNum;
	}


	@Override
	public String toString() {
		return "MachineProbability{" +
			"id=" + id +
			", probabilityRulesId=" + probabilityRulesId +
			", dollId=" + dollId +
			", probability1=" + probability1 +
			", probability2=" + probability2 +
			", probability3=" + probability3 +
			", createdDate=" + createdDate +
			", modifiedDate=" + modifiedDate +
			", createdBy=" + createdBy +
			", modifiedBy=" + modifiedBy +
			"}";
	}
}
