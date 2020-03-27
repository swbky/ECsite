package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteConfirmAction extends ActionSupport{

	private String loginId;

	public String execute() {
		if(loginId == null) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}
