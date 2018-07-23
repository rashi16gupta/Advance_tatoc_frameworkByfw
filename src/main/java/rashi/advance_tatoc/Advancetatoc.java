package rashi.advance_tatoc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import UtilPackage.LocatorCall;

public class Advancetatoc{
	static WebDriver driver=BrowserDetails.driver;
	static LocatorCall lc= new LocatorCall(driver);
	public static String AvanceCourseTest() {
		 System.out.println("ad="+lc);
		lc.getWebElementsTag("linkAdvance").click();
				return driver.getTitle();
 }
}