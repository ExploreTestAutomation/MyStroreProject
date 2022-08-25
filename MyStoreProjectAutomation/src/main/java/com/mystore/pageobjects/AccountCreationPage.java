/**
 * 
 */
package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class AccountCreationPage extends BaseClass {
	
	//Action action= new Action();
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	 WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	 WebElement mr;
	
	@FindBy(id = "id_gender2")
	 WebElement mrs;

	@FindBy(name = "customer_firstname")
	 WebElement firstName;

	@FindBy(name = "customer_lastname")
	 WebElement lastName;

	@FindBy(name = "passwd")
	 WebElement passWord;

	@FindBy(name = "days")
	 WebElement days;

	@FindBy(name = "months")
	 WebElement months;

	@FindBy(name = "years")
	 WebElement years;

	@FindBy(name = "firstname")
 WebElement customerNirstName;

	@FindBy(name = "lastname")
	 WebElement customerLastName;

	@FindBy(name = "company")
	 WebElement companyName;

	@FindBy(name = "address1")
	 WebElement address;

	@FindBy(name = "city")
	 WebElement city;

	@FindBy(name = "id_state")
	 WebElement state;

	@FindBy(name = "postcode")
	 WebElement postCode;

	@FindBy(name = "id_country")
	 WebElement country;

	@FindBy(name = "phone")
	 WebElement phone;

	@FindBy(name = "phone_mobile")
	 WebElement mobile;

	@FindBy(name = "alias")
	 WebElement ref;

	@FindBy(name = "submitAccount")
	 WebElement registerBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			Action.click(driver, mr);
		} else {
			Action.click(driver, mrs);
		}
		
		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.type(passWord, pswd);
		Action.selectByValue(days, day);
		Action.selectByValue(months, month);
		Action.selectByValue(years, year);
		Action.type(companyName, comPany);
		Action.type(address, addr);
		Action.type(city, cityString);
		Action.selectByVisibleText(stateName, state);
		Action.type(postCode, zip);
		Action.selectByVisibleText(countryName, country);
		Action.type(mobile, mobilePhone);
	}
	
	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage();
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return Action.isDisplayed(driver, formTitle);
	}
	
}
