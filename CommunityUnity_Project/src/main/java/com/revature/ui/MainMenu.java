package com.revature.ui;

import org.apache.log4j.Logger;

public class MainMenu implements Menu{
	
	Logger log = Logger.getLogger(MainMenu.class);
	
	public void display() {
		System.out.println("Welcome to the application!");
		
		int choice = 0;
		
		do {
			System.out.println("+=========================+");
			System.out.println("|      WELCOME TO         |");            
			System.out.println("|     COMMUNITY UNITY     |");
			System.out.println("|       BANK              |");
			System.out.println("+=========================+");
			System.out.println("\nPLEASE SELECT FROM THE MENU OPTIONS");
			System.out.println("\n===================================");
			System.out.println("(1.) LOG IN WITH EXISTING USER NAME");
			System.out.println("(2.) APPLY FOR NEW ACCOUNT");
			System.out.println("(3.) EXIT");
			
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
				Menu accountMenu = new AccountMenu();
				accountMenu.display();
				break;
			case 3:
				log.info("Choice 3 Successfully exits application");
				break;
				
			default:
				System.out.println("No valid choice entered, please try again");
			}
			
		} while(choice != 3);
		
	}

		}

