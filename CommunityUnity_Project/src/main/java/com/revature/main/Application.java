package com.revature.main;

import org.apache.log4j.Logger;

import com.revature.ui.MainMenu;
import com.revature.ui.Menu;

public class Application {

	public static void main(String[] args) {

		Logger log = Logger.getLogger(Application.class);

		Menu mainMenu = new MainMenu(); // shortcut for importing is ctrl + shift + o
		mainMenu.display();

		System.out.println("A Connection has been established");

		log.info("Log connection INFO");
		Menu.sc.close();
		System.out.println("Application closing!");

	}

}
