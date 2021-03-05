package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public List<Account> getAccountsByUsername(String username, Connection con) throws SQLException;
	public Account insertAccount(Account account, Connection con, String username) throws SQLException;
	

}
