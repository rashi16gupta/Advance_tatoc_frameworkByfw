package rashi.advance_tatoc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDetails {



	static WebDriver driver;
	
	public static String launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:/rashi/chromedriver/chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
		driver.get("http://10.0.1.86//tatoc");
		driver.manage().window().maximize();
	 	return driver.getTitle();
	 	}
	
}