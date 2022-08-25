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
public class AddToCartPage extends BaseClass {
	
	//Action action= new Action();
	
	@FindBy(id="quantity_wanted")
	 WebElement quantity;
	
	@FindBy(name="group_1")
	 WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	 WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	 WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	 WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		Action.click(driver, addToCartBtn);
	}
	
	
	
}
