package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCreateEntryTest {
	private WebDriver driver;

	@Test
	public void postIsSuccessfull() {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("admin1");
		driver.findElement(By.id("btn-submit")).click();
		
		driver.get("localhost:5000/entries");
		String currentMessage2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/span")).getText();
		System.out.println(currentMessage2);
		driver.get("localhost:5000");
		
		driver.findElement(By.id("create_post")).click();
		driver.findElement(By.id("title")).sendKeys("My MB newest post 2");
		driver.findElement(By.id("body")).sendKeys("This MB is a post.2 ");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form/div[5]/div/button")).click();
		
		String currentMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/span")).getText();
		System.out.println(currentMessage);
		
		assertTrue(currentMessage.contains("Entry 'My MB newest post 2' created successfully."));
	}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}

	@After
	public void teardDown() {
		driver.quit();
	}
}
