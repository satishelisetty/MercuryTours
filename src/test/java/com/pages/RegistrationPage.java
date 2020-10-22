package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.utility.ExcelDataProvider;

public class RegistrationPage {
	WebDriver driver;
	
	public RegistrationPage(WebDriver ldriver){
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]") WebElement Register;
	@FindBy(xpath="//input[@name='firstName']") WebElement FirstName;
	@FindBy(xpath="//input[@name='lastName']") WebElement LastName;
	@FindBy(xpath="//input[@name='phone']") WebElement Phone;
	@FindBy(xpath="//input[@name='userName']") WebElement Email;
	@FindBy(xpath="//input[@name='address1']") WebElement Address;
	@FindBy(xpath="//input[@name='city']") WebElement City;
	@FindBy(xpath="//input[@name='state']") WebElement State;
	@FindBy(xpath="//input[@name='postalCode']") WebElement PostalCode;
	@FindBy(xpath="//select[@name='country']") WebElement Country;
	@FindBy(xpath="//input[@name='email']") WebElement UserName	;
	@FindBy(xpath="//input[@name='password']") WebElement Password;
	@FindBy(xpath="//input[@name='confirmPassword']") WebElement ConfirmPassword;
	@FindBy(xpath="//input[@name='submit']") WebElement SubmitBtn;
	
	public void registration() throws IOException{
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fis=new FileInputStream("./testdata/Registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh=wb.getSheet("Registration");
		
		int noOfRows=sh.getLastRowNum();
		System.out.println("Total no of Rows is: "+noOfRows);
		
		for(int row=1;row<=noOfRows;row++){
			
			XSSFRow currentRow=sh.getRow(row);
			
			Register.click();
			
			String firstName=currentRow.getCell(0).getStringCellValue();
			String lastName=currentRow.getCell(1).getStringCellValue();
			String phone=currentRow.getCell(2).toString();
			String email=currentRow.getCell(3).getStringCellValue();
			String address=currentRow.getCell(4).getStringCellValue();
			String city=currentRow.getCell(5).getStringCellValue();
			String state=currentRow.getCell(6).getStringCellValue();
			String postalCode=currentRow.getCell(7).toString();
			String country=currentRow.getCell(8).getStringCellValue();
			String userName=currentRow.getCell(9).getStringCellValue();
			String password=currentRow.getCell(10).getStringCellValue();
			String confirmPassword=currentRow.getCell(11).getStringCellValue();
			
			FirstName.sendKeys(firstName);
			LastName.sendKeys(lastName);
			Phone.sendKeys(phone);
			Email.sendKeys(email);
			Address.sendKeys(address);
			City.sendKeys(city);
			State.sendKeys(state);
			PostalCode.sendKeys(postalCode);
			
			Select se=new Select(Country);
			se.selectByVisibleText(country);
			
			UserName.sendKeys(userName);
			Password.sendKeys(password);
			ConfirmPassword.sendKeys(confirmPassword);
			
			SubmitBtn.click();
			
		}
		
	}
}
		
		
