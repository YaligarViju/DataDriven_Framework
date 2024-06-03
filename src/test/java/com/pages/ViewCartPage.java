package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {
	
	static Logger log = Logger.getLogger(ViewCartPage.class);
	
	@FindBy(xpath="//div[@class=\"zab8Yh _10k93p\"]//div[@class=\"_3fSRat\"]//a[@class=\"_2Kn22P gBNbID\"]") private WebElement partactual_Product_Text1;
	//@FindBy(xpath="//div[@class=\"_2nQDXZ\"]//div[@class=\"_3fSRat\"]//div[@class=\"_2-uG6-\"]//a") private WebElement actual_ProductText;
	@FindBy(xpath="//div[@class=\"_20RCA6\"]") private WebElement part_actual_ProductText2;
	@FindBy(xpath="//button/span[text()='Place Order']") private WebElement placeOrderBTN;
	public ViewCartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String get_Actual_Text() {
		 String part1=partactual_Product_Text1.getText();
		 String part2=part_actual_ProductText2.getText();
		 return part1+"  ("+part2+")";
		  
	}
	
	public void click_On_PlaceOrderBTN() {
		placeOrderBTN.click();
	}

}
