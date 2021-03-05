package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserService {
	
private static Logger log = Logger.getLogger(UserService.class);
	
	public UserDAO userDAO; 
	public AccountDAO accountDAO;
	
	public UserService() {
		this.userDAO = new UserDAOImpl();
		this.accountDAO = new AccountDAOImpl();
	}
	
	// We created and will be using this constructor in order to pass in
	// fake UserDAO and fake AccountDAO objects
	// These fake objects are "mocks" that are mocked using the Mockito framework
	public UserService(UserDAO userDAO, AccountDAO accountDAO) {
		this.userDAO = userDAO;
		this.accountDAO = accountDAO;
	}
	
	public User getUserByUsername(String username) throws UserNotFoundException, SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			User user;
			
			user = userDAO.getUserByUsername(username, con);
			
			if (user == null) {
				log.info("getUserByUsername(): attempted to get User with username " + username + ", but this user was not found");
				throw new UserNotFoundException("User with username '" + username + "' was not found!");
			}
			
			List<Account> userAccounts = accountDAO.getAccountsByUsername(username, con);
			
			user.setAccounts(userAccounts);
			
			log.info("getUserByUsername() invoked and finished successfully");
			return user;
		}
	}

}
