package com.inetbanking.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;


	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	//#customer > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)
	//#customer > tbody > tr:nth-child(4) > td:nth-child(2)
	@CacheLookup 
	@FindBy(css = "#customer > tbody > tr:nth-child(4) > td:nth-child(2)")
	WebElement acountIDLoctor;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm, String dd, String yy) throws AWTException, Exception {
		Thread.sleep(2000);

		txtdob.sendKeys(mm);
		
		Robot robot = new Robot();
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_LEFT);
		
		robot.keyPress(KeyEvent.VK_LEFT);
		
		robot.keyPress(KeyEvent.VK_UP);






		
		//txtdob.sendKeys(mmddyyyy);

		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	public WebElement getAccoutIDFromAccountCreatedPage() {
		WebElement accountID = acountIDLoctor;
		return accountID;
	}
	
	
	
}
