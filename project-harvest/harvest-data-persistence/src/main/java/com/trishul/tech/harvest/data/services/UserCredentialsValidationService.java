package com.trishul.tech.harvest.data.services;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trishul.tech.harvest.data.model.Credentials;
import com.trishul.tech.harvest.data.repo.UserCredsRepo;
import com.trishul.tech.harvest.pojos.login.LoginCreds;
import org.springframework.data.mongodb.core.MongoOperations;

@Service
public class UserCredentialsValidationService {

	@Autowired
	private UserCredsRepo userCredsRepo;

	@Autowired
	MongoOperations mongoOperation;

	private static final Logger logger = LoggerFactory.getLogger( UserCredentialsValidationService.class );

	/**
	 * Validates user credentials provided by the user to authenticate the usage
	 * @param loginCreds
	 * @return boolean
	 */
	public boolean validateUserCredentials(LoginCreds loginCreds){
		Credentials credentials = userCredsRepo.findByUserName(loginCreds.getUserName());
		if(credentials!=null
				&&credentials.getUserName()!=null
				&&credentials.getPassword()!=null){
			logger.info("Found User Credentails For Given UserName");
			if(!credentials.getUserName().equalsIgnoreCase(loginCreds.getUserName())
					||!credentials.getPassword().equalsIgnoreCase(loginCreds.getPassword())){
				logger.error("Invalid userName/Password Provided!!");
			}else{
				return true;
			}
		}
		return false;
	}
	/**
	 * return all the users list from DB
	 * @return
	 */
	public List<Credentials> getAllUserCredentials(){			
		List<Credentials> users = userCredsRepo.getAllUsers();
		logger.info("Total Users Found In DB:"+users.size());
		for (Iterator<Credentials> iterator = users.iterator(); iterator.hasNext();) {
			Credentials credentials = (Credentials) iterator.next();
			logger.info("User Name:"+credentials.getUserName()+"\t"+"Password:"+credentials.getPassword());
		}
		return users;
	}
	
	public Credentials findByUserName(String userName){
		return userCredsRepo.findByUserName(userName);
	}
	
	public boolean saveUser(LoginCreds loginCreds){
		Credentials creds=new Credentials();
		creds.setPassword(loginCreds.getPassword());
		creds.setUserName(loginCreds.getUserName());
		return userCredsRepo.saveUser(creds);
	}

}
