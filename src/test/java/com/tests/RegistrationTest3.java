package com.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.RegistrationPage;
import com.utility.BrowserFactory;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class RegistrationTest3{
	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void registration(String br) throws InterruptedException{
		
		if(br.equalsIgnoreCase("chrome")){
			
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			}
		
		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		
		if(driver.getTitle().equals("Register: Mercury Tours")){
				Assert.assertTrue(true);
		}
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
		
		
}
