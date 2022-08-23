package com.Dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Excel.reader;

public class DataTest {

	WebDriver driver;


	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror");

	}
	
	@DataProvider
	public Iterator<Object []> getTestData() {
		
		ArrayList<Object[]> mydata = reader.Excelreader();
		return mydata.iterator();
	}
	
	
	
	@Test(dataProvider = "getTestData")
	public void halfEbayRegPageTest(String fn,String ln, String em,String pw){
		
//		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
//
//		driver = new ChromeDriver();
//
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror");

		
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(fn);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(ln);
	
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(em);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pw);
		
	
		 
	}
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
