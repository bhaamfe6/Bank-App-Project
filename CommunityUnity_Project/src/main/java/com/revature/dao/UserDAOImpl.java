package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;

public class UserDAOImpl implements UserDAO {

		@Override
		public User getUserByUsername(String username, Connection con) throws SQLException {
			User user = null;
			
			String sql = "SELECT * FROM account_practice.users LEFT JOIN usersname ON username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String un = rs.getString("username");  //fields from users table
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				
				user = new User(username, firstname, lastname);
			}
			
			return user;
		}


}