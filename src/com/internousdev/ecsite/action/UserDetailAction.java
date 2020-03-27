package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserDetailDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailAction extends ActionSupport{

	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
	private String loginId;

	public String execute() throws SQLException{
		UserDetailDAO dao = new UserDetailDAO();
		userList = dao.userDetail(loginId);
		return SUCCESS;
	}

	public ArrayList<UserInfoDTO> getUserList(){
		return this.userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList) {
		this.userList = userList;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}
