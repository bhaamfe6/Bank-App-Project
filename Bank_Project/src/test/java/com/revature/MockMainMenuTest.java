package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.MockUser;
import com.revature.ui.Menu;
import com.revature.ui.MockMenu;

public class MockMainMenuTest {

	public MockMainMenuTest mockMainMenuTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Create fake objects (mock objects)

//				mockedStatic = Mockito.mockStatic(ConnectionUtil.class);
//				mockedStatic.when(ConnectionUtil::getConnection).thenReturn(mockConnection);

		// Instruct the methods from these fake objects on what to return when certain
		// parameters are passed into them
		// utilize matchers from org.mockito.ArgumentMatchers

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//				mockedStatic.close();
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	// Actually test those methods
	@Test
	public void MainMenuFunctionsProperly() {
		

		MockUser actual = new MockUser("UserFelicia", "Felicia", "password");

		MockUser expected = new MockUser("UserFelicia", "Felicia", "password");

		assertEquals(expected, actual);
	
		int choice = 0;

		
			System.out.println("\n===================================");
			System.out.println("(1.) LOG IN WITH EXISTING USER NAME");
			System.out.println("(2.) EXIT");


			switch (choice) {
			case 1:
				String mockusername = getMockUsernameInput();
				String mockpassword = getMockPasswordInput();
				break;
			case 2:
				break;
			default:
				System.out.println("No valid choice entered, please try again");
				break;
			}
	}
	

		private String getMockUsernameInput() {
		System.out.println("Enter Username");
		String mockusername = "UserFelicia";

		return mockusername;
	}

	 private String getMockPasswordInput() {
		System.out.println("Enter Password");
		String password = "password";

		return password;

	
	}	
					
			 




}