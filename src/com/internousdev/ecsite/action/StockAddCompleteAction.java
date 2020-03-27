package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.StockAddCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class StockAddCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String message;

	public String execute() {
		int result = 0;
		StockAddCompleteDAO dao = new StockAddCompleteDAO();
		result = dao.stockAdd(session.get("stock").toString(), session.get("id").toString());
		if(result > 0) {
			setMessage ("在庫数の変更が完了しました。");
		} else {
			setMessage ("在庫数の変更に失敗しました。");
		}
		return SUCCESS;
	}






	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
