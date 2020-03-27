package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemSearchCompleteDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemSearchCompleteAction extends ActionSupport implements SessionAware{

	private ArrayList<BuyItemDTO> searchItemList = new ArrayList<BuyItemDTO>();
	private Map<String, Object> session;
	private ItemSearchCompleteDAO itemSearchCompleteDAO = new ItemSearchCompleteDAO();
	private String priceAbove;
	private String priceBelow;
	private String itemName;

	public String execute() {
		int newPriceAbove;
		int newPriceBelow;

		if(priceAbove.equals("")) {
			priceAbove = "0";
			newPriceAbove = Integer.parseInt(priceAbove);
		} else {
			newPriceAbove = Integer.parseInt(priceAbove);
		}

		if(priceBelow.equals("")) {
			priceBelow = "999999";
			newPriceBelow = Integer.parseInt(priceBelow);
		} else {
			newPriceBelow = Integer.parseInt(priceBelow);
		}

		if(itemName.equals("")) {
			searchItemList = itemSearchCompleteDAO.getBuyItemInfo(newPriceAbove, newPriceBelow);
			session.put("searchItemList", searchItemList);
		} else {
			searchItemList = itemSearchCompleteDAO.getBuyItemInfo(newPriceAbove, newPriceBelow, itemName);
			session.put("searchItemList", searchItemList);
		}
		session.put("newPriceAbove", newPriceAbove);
		session.put("newPriceBelow", newPriceBelow);
		session.put("itemName", itemName);

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<BuyItemDTO> getSearchItemList(){
		return this.searchItemList;
	}

	public void setSearchItemList(ArrayList<BuyItemDTO> searchItemList) {
		this.searchItemList = searchItemList;
	}

	public String getPriceAbove() {
		return priceAbove;
	}

	public void setPriceAbove(String priceAbove) {
		this.priceAbove = priceAbove;
	}

	public String getPriceBelow() {
		return priceBelow;
	}

	public void setPriceBelow(String priceBelow) {
		this.priceBelow = priceBelow;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



}
