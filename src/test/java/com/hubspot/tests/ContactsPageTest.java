package com.hubspot.tests;

import java.util.Properties;

import org.bson.codecs.ValueCodecProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class ContactsPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage ContactsPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage=new BasePage();
		prop = basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		ContactsPage=homePage.gotoContactsPage();
		
		Thread.sleep(5000);
	}
	
	@Test (priority=2)
	public void verifycontactsPagetitle(){
		String titleString=ContactsPage.getContactspageTitle();
		System.out.println("contact page title   "+ titleString);
		Assert.assertEquals(titleString, Constants.CONTACTS_PAGE_TITLE);
	}
	@Test
	public void createNewContactTest() throws InterruptedException{
		ContactsPage.CreateNewContact("sue@gmail.com", "sue", "yesil", "QAlead");
		
	}
	@Test 
	public  void createContact() throws InterruptedException{
		ContactsPage.CreateNewContact("hyesil@gmail.com", "hakan", "yesil", "editor");
	}
	@AfterMethod
	public void teardown(){
		basePage.closeBrowser();
	}
	
}
