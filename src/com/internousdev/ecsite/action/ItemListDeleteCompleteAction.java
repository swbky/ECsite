package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	private String id;

	public String execute() {


		if(id == null) {
			ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();
			dao.DeleteItem();
		} else {
			ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();
			dao.DeleteDetailItem(id);
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
