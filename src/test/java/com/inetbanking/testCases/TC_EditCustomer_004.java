package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass {

	String customIdText;

	public TC_EditCustomer_004(String customIdText) {
		this.customIdText = customIdText;
	}

	@Test
	public void editCustomer() throws Exception {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickSubmit();

		Thread.sleep(4000);

		EditCustomerPage ed = new EditCustomerPage(driver);
		ed.clickEditCutomerFromMenu();
		ed.enterCustomerID(customIdText);


		ed.clickOnSubmit();

	}

}
