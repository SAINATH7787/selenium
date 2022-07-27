package com.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.keyword.base.Base;

public class KeywordEngine {

	Base b;

	public WebDriver driver;
	public Properties prop;
	public static Sheet sheet;
	public Workbook book;

	String lname;
	String lvalue;

	public final String scensheet = "C:\\selenium\\KeywordDriven\\src\\main\\java\\com\\keyword\\Scenerios\\Keyword.xlsx";

	public void Exec(String sname) throws FileNotFoundException {

		FileInputStream file = new FileInputStream(scensheet);

		try {
			book = new HSSFWorkbookFactory().create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sname);

		int k = 0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			lname = null ; lvalue = null;
			String locvalue = sheet.getRow(i + 1).getCell(k + 1).toString().trim();

			if (!locvalue.equalsIgnoreCase("NA")) {
				 lname = locvalue.split("=")[0].trim();
				 lvalue = locvalue.split("=")[1].trim();
			}

			String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
			String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
			
			if(!lvalue.equals(null)) {
              switch(lvalue) {
			  case "login1" : 
				  WebElement e1 =driver.findElement(By.xpath("//a[@href =\"https://www.udemy.com/join/login-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F\" ]"));
				  
				  if(action.equalsIgnoreCase("sendkeys")) {
					  
					  e1.clear();
					  e1.sendKeys(value);
				  }
				  else if(action.equalsIgnoreCase("click")) {
					  e1.click();  
				  }
				  break;
			  case "login2" : 
				  
				  WebElement e2 =driver.findElement(By.xpath("//input[@name ='submit']"));
				  
				  if(action.equalsIgnoreCase("sendkeys")) {
					  
					  e2.clear();
					  e2.sendKeys(value);
				  }
				  else if(action.equalsIgnoreCase("click")) {
					  e2.click();  
				  }
		      break;
			  case "email":
				  WebElement e3 =driver.findElement(By.xpath("//input[@name ='email']"));
				  
				  if(action.equalsIgnoreCase("sendkeys")) {
					  
					  e3.clear();
					  e3.sendKeys(value);
				  }
				  else if(action.equalsIgnoreCase("click")) {
					  e3.click();  
				  }
				  
			  break;	  
			  case "password":
				  
				  WebElement e4 =driver.findElement(By.xpath("//input[@name ='password']"));
				  
				  if(action.equalsIgnoreCase("sendkeys")) {
					  
					  e4.clear();
					  e4.sendKeys(value);
				  }
				  else if(action.equalsIgnoreCase("click")) {
					  e4.click();  
				  }
			  break;
              }
			}

			switch (action) {

			case "openbrowser":

				b = new Base();

				prop = b.initprop();

				if (value.isEmpty() || value.equals("NA")) {

					driver = b.init_browser(prop.getProperty("browser"));
				} else {

					driver = b.init_browser("value");
				}

				break;

			case "enterurl":
				if (value.isEmpty() || value.equals("NA")) {
					driver.get(prop.getProperty("url"));

				} else
					driver.get(value);

				break;
				
				
			case "quit" : 
				driver.quit();
				break ; 
				
			default : break;

			}
			
			
			}

		}

	}

