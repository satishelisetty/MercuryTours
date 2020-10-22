package com.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.RegistrationPage;
import com.utility.BrowserFactory;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class RegistrationTest extends BaseClass{
	
	@Test
	public void registration() throws IOException{
			
		logger=report.createTest("Registration to CRM");
		
		RegistrationPage registration=PageFactory.initElements(driver, RegistrationPage.class);
		
		logger.info("Starting application");
		try{
		
		//registration.registration();
			Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		
		if(driver.getTitle().equals("Register: Mercury Tours")){
				Assert.assertTrue(true);
		}
		else{
			Helper.captureScreenshot(driver);
			Assert.assertTrue(false);
		}
		}
		catch(Exception e){
			System.out.println("Exception in registration test");
			
			
		}
		
		logger.pass("Registration Done successfully");
	}

	
	

}