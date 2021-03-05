package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class AccountService {
		
	private static Logger log = Logger.getLogger(AccountService.class);

		public AccountDAO accountDAO;
		public UserDAO userDAO;
		
		public AccountService() {
			this.accountDAO = new AccountDAOImpl();
			this.userDAO = new UserDAOImpl();
		}
		
		public Account createAccount(String username, Account account, Connection connection) throws SQLException, UserNotFoundException {
			try (Connection con = ConnectionUtil.getConnection()) {
				con.setAutoCommit(false); // By default, autocommit is on, so here I'm turning it off so I can control it myself
				
				User user = userDAO.getUserByUsername(username, con);
				
				if (user == null) {
					throw new UserNotFoundException("User with username '" + username + "' was not found!");
				}
				
				Account accountWithID = accountDAO.insertAccount(account, con, username);
				
				con.commit();
				log.info("createAccount() invoked and finished successfully");
				return accountWithID;
			}
		}
		
}


