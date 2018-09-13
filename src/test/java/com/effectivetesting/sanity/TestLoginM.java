package com.effectivetesting.sanity;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginM {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}
	
	@Test
	public void succesfulLoginMessageShouldAppear() {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("admin1");
		driver.findElement(By.id("btn-submit")).click();
		
		String expectedMessage= "Successfully logged in as admin1@gmail.com.";
		String currentMessage= driver.findElement(By.id("notification")).getText();
		System.out.println("expected1: " + expectedMessage);
		System.out.println("expected2: " + currentMessage);
		assertTrue(currentMessage.contains(expectedMessage));
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
