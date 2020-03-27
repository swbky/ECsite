package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{

	private ItemListDAO dao = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{

		itemInfoDTOList = dao.getItemInfo();

		return SUCCESS;
	}

	public ArrayList<ItemInfoDTO> getItemInfoDTOList(){
		return this.itemInfoDTOList;
	}

	public void setItemInfoDTOList(ArrayList<ItemInfoDTO> itemInfoDTOList) {
		this.itemInfoDTOList = itemInfoDTOList;
	}
}

