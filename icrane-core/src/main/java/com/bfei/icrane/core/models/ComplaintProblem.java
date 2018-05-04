package com.bfei.icrane.core.models;

import java.io.Serializable;

public class ComplaintProblem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String problemName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName == null ? null : problemName.trim();
    }
	@Override
	public String toString() {
		return "ProblemTemplate [id=" + id + ", problemName=" + problemName + "]";
	}
}
