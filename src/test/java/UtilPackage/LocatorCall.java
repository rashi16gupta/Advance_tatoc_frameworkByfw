package UtilPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import LocatorMapping.LocatorMap;
public class LocatorCall {
	static String TagName;
	static String TagValue;
	static WebDriver driver;
	static WebElement webelement;
	LocatorMap lm;
	public LocatorCall(WebDriver driver)
	{
		this.driver=driver;
	
		lm= new LocatorMap();
	}
	
	public  WebElement getWebElementsTag(String name)
	{
		//System.out.println(name);
		 TagName= lm.getElementByTag(name);
		
		 TagValue= lm.getElementByValue(name);
		 //System.out.println(TagName+ "  "+ TagValue);
	
		 try {
				if (TagName.equalsIgnoreCase("id")) {
					
				      webelement = driver.findElement(By.id(TagValue));
					//System.out.println("webelement "+webelement);
					//hE(driver, webelement);
				} else if (TagName.equalsIgnoreCase("name")) {
					webelement = driver.findElement(By.name(TagValue));
					
				} else if (TagName.equalsIgnoreCase("xpath")) {
					webelement = driver.findElement(By.xpath(TagValue));
					
				} else if (TagName.equalsIgnoreCase("linkText")) {
					webelement = driver.findElement(By.linkText(TagValue));
				
				} else if (TagName.equalsIgnoreCase("class")) {
					webelement = driver
							.findElement(By.className(TagValue));
					
				} else if (TagName.equalsIgnoreCase("cssSelector")) {
					webelement = driver.findElement(By
							.cssSelector(TagValue));
					
				} else {
					System.out.println("Please Check the Given Locator Syntax :"
							+ name);
					
					return null;
				}
			} catch (Exception exception) {
				System.out.println("in catch check Locator Syntax :"
						+ name);
				
								exception.printStackTrace();
				return null;
			}
		
		return webelement;
}
	
	
}
