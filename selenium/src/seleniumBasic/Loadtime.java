package seleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loadtime {
	WebDriver driver;

	public void invoke() {
		
		WebDriverManager.chromedriver().setup();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		ChromeOptions co = new ChromeOptions();
		co.merge(caps);
		
		driver = new ChromeDriver(co);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		long st = System.currentTimeMillis();
		driver.get("https://ng-iot-qa1-feapp.azurewebsites.net/home");

		long fin = System.currentTimeMillis();
		System.out.println(fin - st);
	}

	public static void main(String[] args) {
		BasicClass o = new BasicClass();
		o.invoke();

	}
}
