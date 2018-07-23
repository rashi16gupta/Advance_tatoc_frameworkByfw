package rashi.advance_tatoc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import UtilPackage.LocatorCall;

public class MenuItemsClass {
	static WebDriver driver=BrowserDetails.driver;
	static LocatorCall lc= new LocatorCall(driver);
	 public static String test_menu_items() {
		 
		  lc.getWebElementsTag("menuItems").click();
		  lc.getWebElementsTag("insidemenu").click();
		  
				return driver.getTitle();
	 }
}