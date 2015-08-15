/**
 * Copyright © 2015 Trishul Technologies pvt Ltd.
 * This file is part of Harvest project.
 * Harvest project can not be copied and/or distributed without the express
 * permission of Trishul Techologies pvt Ltd. 
 */
package com.trishul.tech.harvest.ui.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.trishul.tech.harvest.ui.utilities.LoginUtility;

@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uname,password;
	private String message; 

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String login() {
		String loginRedirect = null;
		boolean result = CredentialsValidationBean.validateLogin(uname, password);
		try {
			if (result) {
				// get Http Session and store username
				HttpSession session = LoginUtility.getSession();
				session.setAttribute("username", uname);

				loginRedirect = "home";
			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Invalid Login Credentials!", "Please Try Again!"));
				loginRedirect = "login";
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginRedirect;
	}

	public String logout() {
		return "logout";
	}

}
