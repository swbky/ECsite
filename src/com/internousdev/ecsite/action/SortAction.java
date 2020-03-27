package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.SortDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SortAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private ArrayList<BuyItemDTO> searchItemList = new ArrayList<BuyItemDTO>();
	private SortDAO sortDAO = new SortDAO();
	private String sort;

	public String execute() {

		if(sort.equals("1")) {
			if(session.get("itemName").toString().equals("")) {
				searchItemList = sortDAO.getBuyItemInfoAsc(Integer.parseInt(session.get("newPriceAbove").toString()), Integer.parseInt(session.get("newPriceBelow").toString()));
				session.put("searchItemList", searchItemList);
			} else {
				searchItemList = sortDAO.getBuyItemInfoAsc(Integer.parseInt(session.get("newPriceAbove").toString()), Integer.parseInt(session.get("newPriceBelow").toString()), session.get("itemName").toString());
				session.put("searchItemList", searchItemList);
			}
		} else if(sort.equals("2")) {
			if(session.get("itemName").toString().equals("")) {
				searchItemList = sortDAO.getBuyItemInfoDesc(Integer.parseInt(session.get("newPriceAbove").toString()), Integer.parseInt(session.get("newPriceBelow").toString()));
				session.put("searchItemList", searchItemList);
			} else {
				searchItemList = sortDAO.getBuyItemInfoDesc(Integer.parseInt(session.get("newPriceAbove").toString()), Integer.parseInt(session.get("newPriceBelow").toString()), session.get("itemName").toString());
				session.put("searchItemList", searchItemList);
			}
		} else if(sort.equals("3")) {
			if(session.get("itemName").toString().equals("")) {
				searchItemList = sortDAO.getBuyItemInfoDateDesc(Integer.parseInt(session.get("newPriceAbove").toString()), Integer.parseInt(session.get("newPriceBelow").toString()));
				session.put("searchItemList", searchItemList);
			} else {
				searchItemList = sortDAO.getBuyItemInfoDateDesc(Integer.parseInt(session.get("newPriceAbove").toString()), Integer.parseInt(session.get("newPriceBelow").toString()), session.get("itemName").toString());
				session.put("searchItemList", searchItemList);
			}
		}
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


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}




}
