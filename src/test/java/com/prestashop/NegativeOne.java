package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeOne {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@AfterMethod
	public void cleanUP() {
		driver.close();
	}
	
	@Test
	public void  wrongCredentialsTest() {
	driver.get("http://automationpractice.com");

	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("email")).sendKeys("asd123@mail.com");
	driver.findElement(By.id("passwd")).sendKeys("asd123");
	driver.findElement(By.id("SubmitLogin")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Authentication failed."));
	}
	
	@Test
	public void  InvalidEmailTest() {
	driver.get("http://automationpractice.com");

	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("email")).sendKeys("asd123");
	driver.findElement(By.id("passwd")).sendKeys("asd123");
	driver.findElement(By.id("SubmitLogin")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Invalid email address."));
	}
	
	@Test
	public void  BlankEmailTest() {
	driver.get("http://automationpractice.com");

	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("passwd")).sendKeys("asd123");
	driver.findElement(By.id("SubmitLogin")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("An email address required."));
	}
	
	@Test
	public void   BlankPasswordTest() {
	driver.get("http://automationpractice.com");

	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("email")).sendKeys("asd123@mail.com");
	driver.findElement(By.id("passwd")).sendKeys("");
	driver.findElement(By.id("SubmitLogin")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Password is required."));
	}

}
