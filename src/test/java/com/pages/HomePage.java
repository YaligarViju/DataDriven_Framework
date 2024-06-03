package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	static Logger log = Logger.getLogger(HomePage.class);
	
	@FindBy(xpath="//div[@class=\"_22Dgdy _29BEA8\"]//input") private WebElement mobileNumberTextBox;
	@FindBy(xpath = "//div[@class=\"YLloxs\"]//button")private WebElement requestBTN ;
	
	@FindBy(xpath = "//input[@name=\"q\"]")private WebElement searchtextField;
	
	
	
	
	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);	
	}
	
	public void Enter_MobileNumber(String mobileNumber) {
		mobileNumberTextBox.sendKeys(mobileNumber);
		
	}
	public void clickonRequestButton() {
		requestBTN.click();
	}
	public void enter_text_in_SearchBox(String text) {
		searchtextField.sendKeys(text,Keys.ENTER);
		
	}
	
	public String getPageURL() {
	String	actualURL=driver.getCurrentUrl();
		return actualURL;
	}

}
