package com.revature.ui;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class UserMenu implements Menu {

	Logger log = Logger.getLogger(UserMenu.class);
		
		public UserService userService;
		
		public UserMenu() {
			
			
			this.userService = new UserService();
		}
		
		public void display() {
			int choice = 0;
			
			do {
				System.out.println("\n=====USER MENU=====");
				System.out.println("\nPlease Make a Selection");
				System.out.println("\n=======================");
				System.out.println("(1.) Access Account User By Username");
				System.out.println("(2.) View Account Menu");
				System.out.println("(3.) Back to Main Menu");
				
				try {
					choice = Integer.parseInt(Menu.sc.nextLine());
				} catch (NumberFormatException e) {
				}
				
				switch (choice) {
					case 1:
						log.info("Test Choice 1 received SQLException message url cannot be null when ENTERED VALID  PASSWORD");
						String username = getUsernameInput();
						String password = getPasswordInput();
						
						try {
							User user = userService.getUserByUsername(username);
							System.out.println(user);
						} catch (SQLException | UserNotFoundException e) {
							System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
						}
						break;
					case 2:
						log.info("Test Choice 2 again. Should take user to Main Menu");
						
						Menu accountMenu = new AccountMenu();
						accountMenu.display();
						
		
						break;
						
					case 3:
						Menu mainMenu = new MainMenu();
						mainMenu.display();
						break;
					default:
						System.out.println("No valid choice entered, please try again");
				}
				
			} while(choice != 3);
		}

		private String getUsernameInput() {
			System.out.println("Enter Username");
			String input = Menu.sc.nextLine().trim();
			
			return input;
		}
		
		private String getPasswordInput() {
			System.out.println("Enter Password");
			String input = Menu.sc.nextLine().trim();
			
			return input;
		

		

}
		
}