package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QAone {
	
	WebDriver driver ;
	
	public void invoke(){

		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setAcceptInsecureCerts(true);
		ChromeOptions co = new ChromeOptions();
		co.merge(caps);

		driver = new ChromeDriver(co);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("https://ng-iot-qa1-feapp.azurewebsites.net/home");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys("gsainath@beckman.com");
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='passwordInput']")).sendKeys("Sai@123456789");
		driver.findElement(By.xpath("//*[@id='submitButton']")).click();
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		long st = System.currentTimeMillis();
		/*driver.get("https://ng-iot-qa1-feapp.azurewebsites.net/home");*/
		long fin = System.currentTimeMillis();
		System.out.println(fin - st);
		
		
		
		driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*driver.findElement(By.xpath("//*[@id='nav_search']")).sendKeys("121992");
		driver.findElement(By.xpath("//*[@id='nav_search']")).sendKeys(Keys.ENTER);*/
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		QAone o = new QAone();
		o.invoke();

	}

}
