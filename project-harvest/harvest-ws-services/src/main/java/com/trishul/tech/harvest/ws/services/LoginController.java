package com.trishul.tech.harvest.ws.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trishul.tech.harvest.data.model.Credentials;
import com.trishul.tech.harvest.data.services.UserCredentialsValidationService;
import com.trishul.tech.harvest.pojos.login.LoginCreds;

/**
 * 
 * @author dinesh
 *
 */
@Controller 
public class LoginController 
{
	private static final Logger logger = LoggerFactory.getLogger( LoginController.class );
	
	@Autowired
	public UserCredentialsValidationService userCredentialsValidationService;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody boolean login(@RequestBody LoginCreds loginCreds){
		return userCredentialsValidationService.validateUserCredentials(loginCreds);
	}
	
	@RequestMapping(value = "/user/getCreds/{userName}", method = RequestMethod.GET)
	public @ResponseBody Credentials getCreds(@PathVariable("userName") String userName) {
		return userCredentialsValidationService.findByUserName(userName);
	}
	
	@RequestMapping(value = "/user/getAllCreds", method = RequestMethod.GET)
	public @ResponseBody List<Credentials> getAllCreds() {
		return userCredentialsValidationService.getAllUserCredentials();
	}
	
	@RequestMapping(value = "/user/saveUser", method = RequestMethod.POST)
	public @ResponseBody boolean saveUser(@RequestBody LoginCreds loginCreds){
		return userCredentialsValidationService.saveUser(loginCreds);
	}

}
