package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
 
	WebDriver driver;
	ElementUtil elementUtil;
	
	By Header= By.xpath("//h3[@class='H3-knyzUA kkRauT Heading-efonvz iQiwYO']");
	By accountName=By.xpath("//div[@class='navAccount-accountName']");
	By clickaccount=By.cssSelector("#account-menu > svg");

	By contactsMainTab =By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
//	public boolean verifyaAcountName(){
//		driver.findElement(clickaccount).click();
//		//driver.findElement(clickaccount).click();//burasi normalde yoktu ben ekledim.
//		return elementUtil.isElementDisplayed(accountName);	
//		}
	public String HomepageHeader(){
		return elementUtil.doGetText(Header);
	}
	
	public String getLoggedInAccountName(){
		elementUtil.doClick(clickaccount);//burasi normalde yoktu ben ekledim.
		return elementUtil.doGetText(accountName);
	}
	public void clickOncontacts(){
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(contactsChildTab);
	}
	public ContactsPage gotoContactsPage(){
		clickOncontacts();
		return new ContactsPage(driver);
	}
}
