package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositiveScenario {
	WebDriver driver;
	Faker faker = new Faker();
	String email = faker.internet().emailAddress();
	String firstName= faker.name().firstName();
	String lastName= faker.name().lastName();
	String password = faker.internet().password();
	String address = faker.address().fullAddress();
	String city = faker.address().city();
	String state = faker.address().state();
	String zipCode = "12322";
	String phoneNumb = faker.finance().creditCard();
	
	
	@BeforeMethod
	public void setUP() {
	WebDriverManager.chromedriver().setup();	
	driver = new ChromeDriver();
	driver.manage().window().fullscreen();
	
	}
	@Test
	public void loginTest() throws InterruptedException {
		driver.get("http://automationpractice.com");

		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email_create")).sendKeys(email+ Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("address1")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("postcode")).sendKeys(zipCode);
		driver.findElement(By.id("id_state")).sendKeys(state+ Keys.ENTER);
		driver.findElement(By.id("phone_mobile")).sendKeys(phoneNumb+ Keys.ENTER);
		
		driver.findElement(By.linkText("Sign out")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText().contains(firstName+" "+lastName));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
