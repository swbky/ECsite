package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAdminAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		if(session.containsKey("confirm")) {
			result = SUCCESS;
		}
		return result;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}


}
