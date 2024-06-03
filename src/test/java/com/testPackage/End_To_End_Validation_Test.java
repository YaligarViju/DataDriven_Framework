package com.testPackage;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseTest.BaseTest;
import com.pages.ViewCartPage;
import com.pages.CheckOutLoginPage;
import com.pages.CheckOutPage;
import com.pages.HomePage;
import com.pages.InventoryPage;

import com.pages.Product_Details_Page;
import com.utils.BaseUtil;



public class End_To_End_Validation_Test extends BaseTest {
	
  //LoginPage loginPage;
  HomePage homePage;
  InventoryPage inventoryPage;
  ViewCartPage viewcartPage;
  CheckOutLoginPage checkOutLoginPage;
  CheckOutPage checkoutPage;
  Product_Details_Page product;
  static Logger logger = Logger.getLogger(End_To_End_Validation_Test.class);
  
  
  
  
	
	@BeforeClass
	public void browserinitializer() throws Throwable {
		initializeBrowser();
		
	
	 homePage=new HomePage(driver);
	 inventoryPage=new InventoryPage(driver);
	 viewcartPage=new ViewCartPage(driver);
	  checkOutLoginPage=new CheckOutLoginPage(driver);
	 checkoutPage=new CheckOutPage(driver);
	  product=new Product_Details_Page(driver);
		
	}
	
	@BeforeMethod
	public void openApplication() {
	  driver.get(prop.getProperty("url"));
	  
	}
	@Test
	public void End_To_End() throws Throwable {
		 driver.get(prop.getProperty("url"));
//	 logger.info("ChromeBrowser opens successfully ....");
		 
		BaseUtil.takeScreenshot(driver, "Home Page");
		Thread.sleep(3000);
		
		homePage.Enter_MobileNumber(prop.getProperty("mobileNumber"));
		
		homePage.clickonRequestButton();
		BaseUtil.waitForTime(10000);   //  Thread.sleep(10000);
		System.out.println("Use SuccessFully Received OTP ");
		BaseUtil.waitForTime(10000);
		System.out.println("User Successfully Entered OTP");
		
        homePage.enter_text_in_SearchBox(prop.getProperty("product"));
		//logger.info("Navigated on Inventory Page of laptop ....");
		BaseUtil.takeScreenshot(driver, "Inventory Page");
		inventoryPage.clickonProduct();
		BaseUtil.waitForTime(3000);
		logger.info("clicked on Product and Able to see product  details Results ....");
		BaseUtil.takeScreenshot(driver, "Product Details Page");
		
		 String exptProduct = product.getProductText(driver);
		
		product.clickonAdd_To_Cart();
		//logger.info("clicked on add to cart button ....");
		
		//logger.info("Product Got Added into cart and Navigated to cart Page ....");
		
		BaseUtil.takeScreenshot(driver, " Cart Page");
		
		
		
		Assert.assertEquals(viewcartPage.get_Actual_Text(), exptProduct);;

		//logger.info("Verified product Successfuly....");
		
		
		viewcartPage.click_On_PlaceOrderBTN();
		BaseUtil.takeScreenshot(driver, " CheckOutLogin Page");
		checkOutLoginPage.enterMobileNumber(prop.getProperty("mobileNumber"));
		//logger.info(" Mobile number Entered ....");
		BaseUtil.waitForTime(5000);
		
		checkOutLoginPage.click_On_ContinueBTN1();
		BaseUtil.waitForTime(8000);
		System.out.println("User Entered otp Manually");
		
		
		//checkOutLoginPage.click_On_Continue_BTN2();
		
		
		
	}
	@AfterMethod
	public void takesFailedScereenshotTasteCase(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus()) {
			BaseUtil.takeScreenshot(driver,result.getName());
			}
		driver.quit();
	   // logger.info("*** chromeBrowser closed successfully: Test case ended ***");
	}

	

}
