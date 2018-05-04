package com.bfei.icrane.core.models;

import java.io.Serializable;

public class RepairsProblem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String problem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
	public String toString() {
		return "ProblemTemplate [id=" + id + ", problem=" + problem + "]";
	}
}
