package com.inetbanking.testCases;

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

	@Test
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
		addcust.custdob("06", "12", "1989");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("AHE");
		addcust.custstate("guj");
		addcust.custpinno("352275");
		addcust.custtelephoneno(randomeNum());

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("123456");
		System.out.println(1);

		addcust.custsubmit();

		System.out.println(2);

		System.out.println(3);
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
