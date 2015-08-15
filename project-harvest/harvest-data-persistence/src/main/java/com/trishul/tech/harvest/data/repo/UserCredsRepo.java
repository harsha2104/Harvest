package com.trishul.tech.harvest.data.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.trishul.tech.harvest.data.model.Credentials;

public class UserCredsRepo{

	@Autowired
	public MongoOperations mongoOperation;
	private static final Logger logger = LoggerFactory.getLogger( UserCredsRepo.class );

	
	public Credentials findByUserName(String userName){
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		Credentials credentials = mongoOperation.findOne(searchUserQuery, Credentials.class);
		return credentials;
	}
	
	public List<Credentials> getAllUsers(){
		List<Credentials> creds = mongoOperation.findAll(Credentials.class);		
		return creds;
	}
	
	public boolean saveUser(Credentials credentials){
		mongoOperation.save(credentials);
		return true;
	}
}
