package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteConfirmAction extends ActionSupport{

	private String id;

	public String execute() {
		if(id == null) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
