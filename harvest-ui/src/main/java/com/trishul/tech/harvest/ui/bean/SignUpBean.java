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

@ManagedBean(name = "signUpBean", eager = true)
@SessionScoped
public class SignUpBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String uname;
	private String pword;
	private String confirmpword;

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname
	 *            the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}

	/**
	 * @param mname
	 *            the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname
	 *            the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname
	 *            the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the pword
	 */
	public String getPword() {
		return pword;
	}

	/**
	 * @param pword
	 *            the pword to set
	 */
	public void setPword(String pword) {
		this.pword = pword;
	}

	/**
	 * @return the confirmpword
	 */
	public String getConfirmpword() {
		return confirmpword;
	}

	/**
	 * @param confirmpword
	 *            the confirmpword to set
	 */
	public void setConfirmpword(String confirmpword) {
		this.confirmpword = confirmpword;
	}

	public String signUp() {
		String loginRedirect1 = null;
		boolean result = CredentialsValidationBean.validateSignUp(fname, mname, lname, email, pword, confirmpword);
		try {
			if (result) {
				// get Http Session and store username
				HttpSession session = LoginUtility.getSession();
				session.setAttribute("username", uname);

				loginRedirect1 = "home";
			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Invalid Sign Up Credentials!", "Please Try Again!"));
				loginRedirect1 = "signUp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginRedirect1;
	}

}
