package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BasicClass {

	WebDriver driver;

	public void invoke() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsainath\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://danaher.udemy.com/");

		driver.findElement(By.xpath("//*[@id='form-group--3']")).sendKeys("sainathsai7787@gmail.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/form/button/span")).click();

		Actions builder = new Actions(driver);

		WebElement con = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/form/button/span"));
		builder.moveToElement(con).build().perform();

		Action soa = builder.keyDown(con, Keys.SHIFT).build();

		soa.perform();
	}

	public static void main(String[] args) {
		BasicClass o = new BasicClass();
		o.invoke();

	}

}

//ChromeOptions co = new ChromeOptions();
//WebDriverManager.chromedriver().setup();
//
//DesiredCapabilities caps = new DesiredCapabilities(); 
//driver = new ChromeDriver(co);