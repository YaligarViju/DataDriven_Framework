package com.pages;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
 public WebDriver driver;
 static Logger log = Logger.getLogger(InventoryPage.class);
 
	@FindBy(xpath="(//div[@class=\"_36fx1h _6t1WkM _3HqJxg\"]//div[@class=\"_1YokD2 _3Mn1Gg\"]//div[@class=\"_1AtVbE col-12-12\"]//div[@class=\"_13oc-S\"]//a)[18]") private WebElement productLink ;
	
	
	
	 public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
		}
	 public void clickonProduct() throws InterruptedException {
		 		 productLink.click();
	 }

}
