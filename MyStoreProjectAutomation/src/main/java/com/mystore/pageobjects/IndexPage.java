package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	//Action action= new Action();
	
	@FindBy(xpath = "//a[@class='login']") 
	 WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	 WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	 WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	 WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {	
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=driver.getTitle();
		return myStoreTitel;
	}
	
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
	Action.type(searchProductBox, productName);
	Action.scrollByVisibilityOfElement(driver, searchButton);
	Action.click(driver, searchButton); 
	Thread.sleep(3000); 
	return new SearchResultPage(); }
	 
	
	

}
