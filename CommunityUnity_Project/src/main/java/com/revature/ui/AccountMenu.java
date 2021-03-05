package com.revature.ui;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Account;
import com.revature.services.AccountService;
import com.sun.tools.javac.code.Type;

public class AccountMenu implements Menu {
	
	private static Logger log = Logger.getLogger(AccountMenu.class);

	public AccountService accountService;
	
	public AccountMenu() {
		
		this.accountService = new AccountService();
	}
	
	public void display() {
		int choice = 0;
		
		do {
			System.out.println("\n=== ACCOUNT MENU ===");
			System.out.println("\nPlease select an option below: ");
			System.out.println("(1.) Back ");
			System.out.println("(2.) New Account");
			System.out.println("(3.) View Account");
			
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
				case 1:
					Menu userMenu = new UserMenu();
					userMenu.display();
					break;
				case 2:
					String username = getUsernameInput();
					String password = getPasswordInput();
					String firstname = getFirstnameInput();
					String lastname = getLastnameInput();
					String acct_type_descrip = getAccountTypeInput();
					double balance = getBalanceForAccountInput();
					
					
					//Account account = new Account(username, account, con);
				//	try {
						
					//	account = this.accountService.createAccount(username, account);
						//System.out.println("Post created successfully: " + account);
						
			//		} catch (SQLException | UserNotFoundException e) {
				//		System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
					//}
					log.error("Account object and try/catch block caused error messages.");	
					break;
					
				case 3:
					Menu transactiontMenu = new TransActionMenu();
					transactiontMenu.display();
				default:
					System.out.println("No valid choice entered, please try again");
			}
			
		} while(choice != 1);
	}
	
	private String getUsernameInput() {
		System.out.println("Create a New Username: ");
		String input = Menu.sc.nextLine().trim();
		
		return input;
	
	}
	
	private String getPasswordInput() {
		System.out.println("Create a New Password: ");
		String input = Menu.sc.nextLine().trim();
		
		return input;
	}
	
	private String getFirstnameInput() {
		System.out.println("Enter your  First name: ");
		String input = Menu.sc.nextLine().trim();
		
		return input;
	}
	
	private String getLastnameInput() {
		System.out.println("Enter your  Last name: ");
		String input = Menu.sc.nextLine().trim();
		
		return input;
		
	}
	
	private String getAccountTypeInput() {
		System.out.println("Choose Account Type: checking OR savings");
		String input = Menu.sc.nextLine().trim();
		
		boolean valid = false;
		
		
		while(!valid)	{
			
			if (input.equalsIgnoreCase("checking") || input.equalsIgnoreCase("savings")) {
				valid = true;
				System.out.println("Thank you for your selection.");
			} else {
				log.error("if condition works BUT the 'Invalid account Type...' message runs in infinite loop");
				System.out.println("Invalid account type selection. Please enter checking or savings.");

			}
		}
	

	return input;
	
	
	}
	
	private double getBalanceForAccountInput() {
		System.out.println("How much would you like your initial deposit to be? ");
		double input = Menu.sc.nextDouble();
		
		return input;

	}

}
