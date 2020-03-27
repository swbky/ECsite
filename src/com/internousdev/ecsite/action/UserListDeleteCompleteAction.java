package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	private String loginId;

	public String execute() {

		if( loginId == null) {
			UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();
			dao.DeleteUser();

		} else {
			UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();
			dao.DeleteUserDetail(loginId);
		}
		return SUCCESS;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


}
