package com.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage=new BasePage();
		prop = basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		loginPage.getLoginPageTitle();
		
		Thread.sleep(5000);
	}
		
	
	
	@Test(priority=1)
	
	public void HomeTitle(){
		String titleString=homePage.getHomePageTitle();
		System.out.println("Home Page Title;  "+titleString);
		Assert.assertEquals(titleString, Constants.HOME_PAGE_TITLE);
	}
	
//	@Test(priority =2)//unnecessary
//	public void VerificationAccountName(){
//		boolean verify =homePage.verifyaAcountName();
//		System.out.println("Logged in account name is:  "+verify);
//		Assert.assertEquals(verify, prop.getProperty("accountName"));
//	}
	
	@Test(priority=2)
	public void HomePageHeader(){
		String header=homePage.HomepageHeader();
		System.out.println("HomePage Header : "+Constants.HOME_PAGE_HEADER);
	}
	@Test(priority=3)
	public void GetLoggedInAccountName(){
		String accNameString=homePage.getLoggedInAccountName();
		System.out.println("Logged Account Name:   "+accNameString);
		Assert.assertEquals(accNameString, prop.getProperty("accountName"));
	
	
	}
	

	@AfterMethod
	public void teardown(){
		basePage.closeBrowser();
	}
}
