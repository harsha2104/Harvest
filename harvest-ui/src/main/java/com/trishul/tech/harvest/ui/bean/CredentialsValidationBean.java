/**
 * Copyright © 2015 Trishul Technologies pvt Ltd.
 * This file is part of Harvest project.
 * Harvest project can not be copied and/or distributed without the express
 * permission of Trishul Techologies pvt Ltd. 
 */
package com.trishul.tech.harvest.ui.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "credentials", eager = true)
@RequestScoped
public class CredentialsValidationBean {

	/**
	 * @param uname
	 * @param password
	 * @return
	 */
	public static boolean validateLogin(String uname, String password) {
		boolean validationResult = false;
		if (("user").equals(uname) && ("user123").equals(password)) {
			validationResult = true;
		} else if (("admin").equals(uname) && ("admin123").equals(password)) {
			validationResult = true;
		}
		return validationResult;
	}

	public static boolean validateSignUp(String fname, String mname, String lname, String email, String pword,
			String confirmpword) {
		boolean validationResult1 = false;

		if ((fname.length() >= 0 && fname != null) && (lname.length() >= 0 && lname != null)) {

			if ((email.length() >= 0 && email != null) && (pword.length() >= 0 && pword != null)
					&& (confirmpword.length() >= 0 && confirmpword != null)) {
				if ((pword.equals(confirmpword))) {
					validationResult1 = true;
				}
			}
		}
		return validationResult1;
	}

}
