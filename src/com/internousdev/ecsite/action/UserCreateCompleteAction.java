package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String errorMessage;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

		int i = userCreateCompleteDAO.searchUser(session.get("loginUserId").toString());

		if(i == 1) {
			setErrorMessage("既に登録されているログインIDです。");
			result = ERROR;

		} else if(i == 0) {
			userCreateCompleteDAO.createUser(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString(), session.get("adminFlg").toString());
			result = SUCCESS;

		}

		return result;

	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
