package com.inetbanking.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditCustomerPage {
	
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver,this);
	}
	
	@FindBy(linkText = "Edit Customer")
	WebElement clickEditCustomer;
	
	@FindBy(name = "cusid")
	WebElement clickOnCutomerTextFiled;
	
	@FindBy(name = "AccSubmit")
	WebElement clickSubmit;
	
	
	public void clickEditCutomerFromMenu() {
		clickEditCustomer.click();
	}
	
	public void enterCustomerID(String customerID) {
		clickOnCutomerTextFiled.sendKeys(customerID);
	}
	
	public void clickOnSubmit() {
		clickSubmit.click();
	}


}
