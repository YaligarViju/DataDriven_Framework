package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	static Logger log = Logger.getLogger(CheckOutPage.class);
	
	
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
