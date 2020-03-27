package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageEditAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		if(session.containsKey("oldLoginId")) {
			result = SUCCESS;
			return result;
		}
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		if(loginDTO.getLoginFlg()) {
			result = SUCCESS;
			session.put("oldLoginId",loginDTO.getLoginId());
			session.put("loginPassword",loginDTO.getLoginPassword());
			session.put("userName",loginDTO.getUserName());
			session.put("id",loginDTO.getId());
		}
		return result;
	}



	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
