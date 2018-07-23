package rashi.advance_tatoc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import UtilPackage.LocatorCall;

public class FileHandlingInTatoc {
	static WebDriver driver=BrowserDetails.driver;
	static LocatorCall lc= new LocatorCall(driver);
	public static String fileHandling() throws FileNotFoundException, InterruptedException
	{
		String element;
		lc.getWebElementsTag("downLoadClick").click();
		
		Thread.sleep(2000);
		String path= "/home/qainfotech/Downloads/file_handle_test.dat";
		File file = new File(path);
		Scanner scnr = new Scanner(file);
		 List<String> storedlist= new ArrayList<String>();
		while(scnr.hasNextLine()){
		   String line = scnr.nextLine();
		   //System.out.println(line);
		   storedlist.add(line);
		  
		}
		element= storedlist.get(2);
		//System.out.println("element  "+signature);
		String [] arrayS= element.split(":");
		String signature=arrayS[1].trim();
		System.out.println("element  "+signature);
		
		lc.getWebElementsTag("enterSignature").sendKeys(signature);
		lc.getWebElementsTag("ProceedEnd").click();
				
				
				return driver.getCurrentUrl();
	}
	    
}