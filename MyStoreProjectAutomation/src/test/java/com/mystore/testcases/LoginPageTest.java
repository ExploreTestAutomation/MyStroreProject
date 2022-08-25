/**
 * 
 */
package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;


public class LoginPageTest extends BaseClass {
	 IndexPage indexPage;
	 LoginPage loginPage;
	 HomePage homePage;
	
	   @Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void loginTest() throws Throwable {
	
		indexPage= new IndexPage();
		
		loginPage=indexPage.clickOnSignIn();

		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homePage=loginPage.login(uname,pswd,homePage);
	String actualURL =	homePage.getCurrURL();
    String expectedURL="http://automationpractice.com/index.php?controller=my-account";

	Assert.assertEquals(actualURL, expectedURL);
	

	}

}
