package com.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.CheckOutLoginPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	//public  org.apache.log4j.Logger logger;
	public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter reporter;
    public ExtentTest test;
   private static  Logger logger=LoggerFactory.getLogger(BaseTest.class);
    
      
	
	public  void initializeBrowser() throws Throwable {
		
	 driver=new ChromeDriver();
	 logger.info("ChromeBrowser opens successfully ....");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 prop=new Properties();
	 
	 
	 File file=new File("common.properties");
     FileInputStream file1=new FileInputStream(file);
      prop.load(file1);
	// File file = new File(System.getProperty("user.dir")+ "src//main//java//Com//configFiles//common.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}

	
	
	}
	

    
    
	@BeforeSuite
	public void starttestCase() throws InterruptedException {

        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        reporter = new ExtentSparkReporter(path);
	}
	
	@AfterSuite
	public void endtestCase() {
		extent.attachReporter(reporter);
		extent.flush();
	}
	
	
	

}
