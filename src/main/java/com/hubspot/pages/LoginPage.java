package com.hubspot.pages;

import java.awt.print.Pageable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	//define locators / Or with by LOcator NOn page factory//
	ElementUtil elementUtil;
	By emailId=By.id("username");
	By password=By.id("password");
	By loginBtnBy=By.id("loginBtn");
	
	//constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page action
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage  doLogin(String username, String pwd){
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtnBy);
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtnBy).click();
		
		return new HomePage(driver);
		
	}
	public HomePage InvalidLogin(String invalidusername,String  invalidpassword){
		driver.findElement(emailId).sendKeys(invalidusername);
		driver.findElement(password).sendKeys(invalidpassword);
		driver.findElement(loginBtnBy).click();
		return new HomePage(driver);
	}
}
