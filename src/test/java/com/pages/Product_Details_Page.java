package com.pages;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Details_Page {
	
	public WebDriver driver;
	static Logger log = Logger.getLogger(Product_Details_Page.class);
	
	@FindBy(xpath="//div[@class=\"_1AtVbE col-12-12\"]//ul//button[text()='Add to cart']") private WebElement AddToCartBTN;
	@FindBy(xpath="//div[@class=\"_2c7YLP UtUXW0 _6t1WkM _3HqJxg\"]//div[@class=\"_1YokD2 _3Mn1Gg col-8-12\"]//h1//span") private WebElement expected_Product_Name;
	
	
	
	public Product_Details_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickonAdd_To_Cart()  {
		
		AddToCartBTN.click();
	}
	public String getProductText(WebDriver driver) throws Throwable {
		Set<String> allw = driver.getWindowHandles();
		  ArrayList<String> allWindows=new ArrayList<String>(allw);
		   driver.switchTo().window(allWindows.get(1));
		   Thread.sleep(3000);
		  return expected_Product_Name.getText();
		   

	       
	}
	

}
