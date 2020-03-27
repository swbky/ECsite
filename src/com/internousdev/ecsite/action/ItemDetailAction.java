package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport implements SessionAware{

	private ArrayList<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
	private String id;
	private Map<String, Object> session;

	public String execute() throws SQLException{
		ItemDetailDAO dao = new ItemDetailDAO();
		itemInfoDTOList = dao.itemDetail(id);
		session.put("itemInfoDTOList",itemInfoDTOList);
		session.put("id", id);
		return SUCCESS;
	}

	public ArrayList<ItemInfoDTO> getItemInfoDTOList(){
		return this.itemInfoDTOList;
	}

	public void setItemInfoDTOList(ArrayList<ItemInfoDTO> itemInfoDTOList) {
		this.itemInfoDTOList = itemInfoDTOList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
