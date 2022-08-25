package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * @author Hitendra: BaseClass is used to load the config file and Initialize 
 * WebDriver
 *  
 */
public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
 
	public void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		// String browserName = prop.getProperty("browser");
		 
		if (browserName.contains("Chrome")) {
	    driver = new ChromeDriver();
		} else if (browserName.contains("FireFox")) {
			
			driver = new FirefoxDriver();
		} 
		
		Action.implicitWait(driver,10);
		Action.pageLoadTimeOut(driver,30);
		driver.get(prop.getProperty("url"));
	}


}
