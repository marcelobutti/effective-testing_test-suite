package com.effectivetesting.user;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.entities.User;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestCreateUserLayer {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	private static final String ID = "13";
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Test
	public void postUser() {
		loginPage = new LoginPageObject(driver);
		String currentMessage = loginPage
				.login("usermb@gmail.com", "usermb")
				.goToCreateEntry()
				.createEntry("My newest post usermb", "This is a post.")
				.getResultMessage();
		
		assertTrue(currentMessage.contains("Entry 'My newest post usermb' created successfully."));
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
		
		User user = createTestUser();
		
        given()
        	.contentType("application/json")
        	.body(user)
        	
        .when()
        	.post(DEFAULT_BASE_URL + "/user");
        	        	
	}
	
	
	@After
    public void tearDown() {
        delete(DEFAULT_BASE_URL + "/user/" + ID);
    }
	
	private User createTestUser() {

		User user = new User();

		user.setId(ID);
		user.setEmail("usermb@gmail.com");
		user.setpassword_hash("usermb");
		user.setName("John Doe 13");
		
		return user;

	}
}
