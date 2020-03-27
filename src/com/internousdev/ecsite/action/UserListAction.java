package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	private UserListDAO dao = new UserListDAO();
	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();

	public String execute() throws SQLException{
		String result = SUCCESS;
		setUserList(dao.getUserInfo());

		return result;
	}

	public ArrayList<UserInfoDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList) {
		this.userList = userList;
	}

}
