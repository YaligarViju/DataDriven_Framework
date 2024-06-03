package com.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

  public class CheckOutLoginPage {
	
	public WebDriver driver;
	static Logger log = Logger.getLogger(CheckOutLoginPage.class);
	   
	    
	   
	
	
    @FindBy(xpath="//div[@class=\"IiD88i GtCYSF\"]//input") private WebElement emailTextField;
	@FindBy(xpath="//button[@class=\"_2KpZ6l _20xBvF _3AWRsL\"]//span[text()='CONTINUE']") private WebElement continueBTN;
	@FindBy(xpath="//div[@class=\"IiD88i GtCYSF\"]//input[@class=\"_2IX_2- _17N0em\"]") private WebElement mobileNumberTextField;
	@FindBy(xpath="")private WebElement continue_Button2;
	@FindBy(xpath = "//div[@class=\"IiD88i GtCYSF\"]//input[@class=\"_2IX_2- _3mctLh _17N0em\"]")private WebElement OTPTextField;
	
	
	
	
	
	
	
	public CheckOutLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	
	}
	
	public void enterEmailID(String emailid) {
		emailTextField.sendKeys(emailid);
	}
	public void click_On_ContinueBTN1() {
		continueBTN.click();
	}
	public void enterMobileNumber(String num) {
		mobileNumberTextField.sendKeys(num);
	}
	
   public void click_On_Continue_BTN2() {
		continue_Button2.click();
	}
	
	
	
	

}
