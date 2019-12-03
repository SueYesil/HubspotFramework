package com.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.BasePage;

public class LoginPagePF extends BasePage {
//two pattern
	//first pattern is NPF which is called by locator
	//second pattern is Page Factory(PF) which is used @FindBy in this approach
	WebDriver driver;
	//PF pattern: with the help of @FindBy
	@FindBy(id = "username")
	WebElement emailIdElement;
	@FindBy(id="password")
	WebElement password;
	
	@FindBy (id="loginBtBy")
	WebElement loginButtonElement;
	
	
	public LoginPagePF(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void doLogin(String username,String pwd){
		emailIdElement.sendKeys(username);
		password.sendKeys(pwd);
		loginButtonElement.click();
	}
	
}
