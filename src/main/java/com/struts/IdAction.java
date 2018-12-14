package com.struts;

import com.opensymphony.xwork2.ActionSupport;

public class IdAction extends ActionSupport{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String execute() {
		System.out.println("struts与maven整合"+id);
		return SUCCESS;
	}

}
