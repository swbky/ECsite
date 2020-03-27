package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageEditCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageEditCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String message;
	private String errorMessage;
	private MyPageEditCompleteDAO dao = new MyPageEditCompleteDAO();


	public String execute() {

		String result = ERROR;

		int i = dao.searchUser(session.get("newLoginId").toString(), session.get("oldLoginId").toString());

		if(i == 1) {
			setErrorMessage("既に登録されているログインIDです。");
			result = ERROR;
		}else {


			int res = 0;
			result = SUCCESS;

			res = dao.myPageEdit(session.get("newLoginId").toString(), session.get("loginPassword").toString(), session.get("userName").toString(), session.get("id").toString(),session.get("oldLoginId").toString());

			if(res > 0) {
				setMessage("ユーザー情報の編集が完了しました。");
			} else {
				setMessage("ユーザー情報の編集に失敗しました。");
			}
		}
		return result;

	}


	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}




}
