package com.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

import io.qameta.allure.Description;
@Listeners(com.hubspot.Listeners.ExtendReportListener.class)

public class LoginTest {
WebDriver driver;
BasePage basePage;
LoginPage loginPage;
Properties prop;

@BeforeMethod
public void setUp(){
	basePage=new BasePage();
	prop = basePage.initialize_properties();
	driver=basePage.initialize_driver(prop);
	loginPage=new LoginPage(driver);
}
	
@ Test(priority=1,description ="login test with correct username and correct password")
public void loginTest(){
	loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	
	
}
@ Test(priority=2,description ="login page title test....")
public void getLoginTitle(){
	String title =loginPage.getLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
}

@ Test(priority=3,description ="login test with   invalid username and invalid correct password")
public void InvalidUsername() throws InterruptedException{
	loginPage.doLogin(prop.getProperty("invalid_username"),prop.getProperty("invalid_password"));
	Thread.sleep(4000);//iki apostrof arasinida bosluk calismiyor!!!!!
	
}//priority provides ordereed test.
@ Test(priority=4,description ="login test with correct username and invalid password")
public void Invalidpassword() throws InterruptedException{
	loginPage.doLogin(prop.getProperty("username"),prop.getProperty("invalid_password"));
	Thread.sleep(3000);
	
}
	
	@AfterMethod
	public void teardown(){
		basePage.closeBrowser();
	}
	
}
