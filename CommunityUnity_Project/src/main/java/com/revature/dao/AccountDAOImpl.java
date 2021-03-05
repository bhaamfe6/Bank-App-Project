package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;

public class AccountDAOImpl implements AccountDAO{
	

		@Override
		public List<Account> getAccountsByUsername(String username, Connection con) throws SQLException {
			String sql = "SELECT * FROM account_practice.account WHERE usersname = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Account> accounts = new ArrayList<>();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String usersname = rs.getString("username");
				String accountnum = rs.getString("accountnum");
				String acct_type_descrip = rs.getString("acct_type_descrip");
				double balance = rs.getDouble("balance");
				
				Account account = new Account(id, username, accountnum, acct_type_descrip, balance);
				
				accounts.add(account);
			}
			
			return accounts;
		}

		@Override
		public Account insertAccount(Account account, Connection con, String username) throws SQLException {
			String sql = "INSERT INTO account_practice.account (acct_type_descrip, usersname, balance) VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setDouble(1, account.getBalance());
			pstmt.setString(2, username);
			
			int count = pstmt.executeUpdate();
			
			if (count != 1) {
				throw new SQLException("Did not successfully insert Post " + account);
			}
			
			// Retrieve auto generated ID, and set it on our Post object
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				account.setId(id);
			}
			
			// return post object
			return account;
		}


}
