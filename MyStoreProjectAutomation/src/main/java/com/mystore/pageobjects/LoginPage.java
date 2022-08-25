/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class LoginPage extends BaseClass {
	
//	Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	 WebElement password;

	@FindBy(id="SubmitLogin")
	 WebElement signInBtn;
	
	@FindBy(name="email_create")
	 WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	 WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.JSClick(driver, signInBtn);
		Thread.sleep(2000);
		return new  HomePage();
		
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}






