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
public class HomePage extends BaseClass {
	
	//Action action= new Action();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	 WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	 WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return Action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return Action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=Action.getCurrentURL(driver);
		return homePageURL;
	}
}
