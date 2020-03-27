package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class StockAddConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String errorMessage;
	private String stock;


	public String execute() {
		String result = SUCCESS;

		if(!(stock.equals(""))) {
			session.put("stock", stock);

		} else {
			setErrorMessage ("在庫数を入力して下さい。");
			result = ERROR;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
}
