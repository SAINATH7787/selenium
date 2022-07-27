package com.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	FileInputStream ip;

	public WebDriver init_browser(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\GOOTY SAINATH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		} else if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\GOOTY SAINATH\\Downloads\\IEDriverServer_x64_4.3.0\\IEDriverServer.exe");
		}

		return driver;

	}

	public Properties initprop() {
		prop = new Properties();

		try {
			ip = new FileInputStream(
					"C:\\selenium\\KeywordDriven\\src\\main\\java\\com\\keyword\\util\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

}
