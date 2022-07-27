package Testng.Practice;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Hello world!
 *
 */

public class App {
	WebDriver driver;

	@Test
	public void invoke() {

//		System.setProperty("webdriver.chrome.driver","C:\\Users\\gsainath\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();

//		ChromeOptions co = new ChromeOptions();
		WebDriverManager.chromedriver().setup();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		ChromeOptions co = new ChromeOptions();
		co.merge(caps);
//		co.addArguments("--start maximize");
		driver = new ChromeDriver(co);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@id =\"nav-link-accountList-nav-line-1\" ]")).click();
		driver.findElement(By.xpath("//input[@id =\"ap_email\" ]")).sendKeys("8978326417");
		driver.findElement(By.id("continue")).click();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		driver.findElement(By.id("ap_password")).sendKeys("abc@123");
		driver.findElement(By.id("signInSubmit")).click();

		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
