package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	public String execute() {
		String result = "login";
		if(session.containsKey("login_user_id")) {
			//containsKeyメソッドは、指定したキーが存在する場合はtrueを返す。
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			buyItemList = buyItemDAO.getBuyItemInfo();

			session.put("buyItemList", buyItemList);

			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	public ArrayList<BuyItemDTO> getBuyItemList(){
		return this.buyItemList;
	}

	public void setBuyItemList(ArrayList<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

}
