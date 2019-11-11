package com.inetbanking.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test(testName = "Verify the URl")
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName(randomestring());
		addcust.custgender("male");
		Thread.sleep(3000);
		try {
			addcust.custdob("10", "10", "1985");
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("AHE");
		addcust.custstate("guj");
		Thread.sleep(300);
		addcust.custpinno("352275");
		addcust.custtelephoneno(randomeNum());

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("123456");
		Thread.sleep(4000);

		addcust.custsubmit();

		Thread.sleep(6000);

		try {
			WebElement customID = addcust.getAccoutIDFromAccountCreatedPage();

			// Storing the added customer Id in string
			String customIdText = customID.getText();

			// Calling construtor of Class "TC_EditCustomer_004" and setting the value of
			// with local customIdText
			new TC_EditCustomer_004(customIdText);

		} catch (NoSuchElementException e) {
			logger.error("NoSuchElementException, Element not found");
			// e.printStackTrace();
		}

		System.out.println(4);

		logger.info("validation started....");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
			captureScreen(driver, "addNewCustomer");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}
