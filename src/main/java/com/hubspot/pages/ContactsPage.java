package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
WebDriver driver;
ElementUtil elementUtil;

By createContactButton = By.xpath("//span[text()='Create contact']");
By createContactFormButton = By.xpath("//div[@class='private-layer']//li[1]");
By email = By.xpath("//input[@name='textInput']");
By firstName = By.xpath("//input[@class='form-control private-form__control' and @data-field='firstname']");
By lastName = By.xpath("//input[@class='form-control private-form__control' and @data-field='lastname']");
By jobTitle = By.xpath("//input[@class='form-control private-form__control' and @data-field='jobtitle']");


public ContactsPage(WebDriver driver){
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
}

public String  getContactspageTitle(){
	return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
	
}
public void CreateNewContact(String emailId,String FN,String LN,String JobTitleValue) throws InterruptedException{
	elementUtil.doClick(createContactButton);
	Thread.sleep(2000);
	elementUtil.doSendKeys(email, emailId);
	Thread.sleep(2000);
	elementUtil.doSendKeys(firstName, FN);
	Thread.sleep(2000);
	elementUtil.doSendKeys(lastName, LN);
	Thread.sleep(2000);
	elementUtil.doSendKeys(jobTitle, JobTitleValue);
	Thread.sleep(2000);
	elementUtil.doClick(createContactButton);
	Thread.sleep(2000);
	
}


}
