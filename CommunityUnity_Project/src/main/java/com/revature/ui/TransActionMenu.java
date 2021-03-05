package com.revature.ui;

import java.sql.SQLException;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class TransActionMenu implements Menu {

		public  void TransactionMenu() {
			
		}
		
	
	public void display() {
		int choice = 0;

		do {
			System.out.println("\n=====TTRANSACTION MENU=====");
			System.out.println("\nPlease Make a Selection");
			System.out.println("\n=======================");
			System.out.println("(1.) Back ");
			System.out.println("(2.) Deposit");
			System.out.println("(3.) Withdrawal");
			System.out.println("(4.) Transfer");

			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
				case 1: Menu accountMenu = new AccountMenu();
				accountMenu.display();
				
					break;
				case 2: //getDepositInput();
					
					break;
				case 3: //getWithdrawalInput();
					break;
				case 4: //getTransferInput();
				default:
					System.out.println("No valid choice entered, please try again");
			}
			
		} while(choice != 1);
	}

	
	

	


	
}