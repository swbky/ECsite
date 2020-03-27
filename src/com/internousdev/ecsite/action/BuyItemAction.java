package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemPrice;
	private int id;
	private int count;
	private String pay;
	private Map<String, Object> session;
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	public String execute() {
		String result = SUCCESS;

		session.put("count", count);
		session.put("itemName", itemName);
		session.put("itemPrice", itemPrice);
		session.put("id", id);

		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(itemPrice);
		session.put("total_price", intCount * intPrice);

		String payment;
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		}else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}

		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<BuyItemDTO> getBuyItemList(){
		return this.buyItemList;
	}

	public void setBuyItemList(ArrayList<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}


}
