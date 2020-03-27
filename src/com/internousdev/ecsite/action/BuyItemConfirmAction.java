package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String errorMessage;

	public String execute() throws SQLException{

		String result;
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();


		int totalStock = buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("itemName").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());

		if(totalStock >= 0) {
			result = SUCCESS;
		} else {
			setErrorMessage("在庫がありません。");
			result = ERROR;
		}


		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
