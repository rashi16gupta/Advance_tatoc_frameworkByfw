package rashi.advance_tatoc;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestTatoc {

	
	public TestTatoc() {
		
	 	}
	@Test 
	  public void test001_Browser_Launch() {
		String titleName= BrowserDetails.launchBrowser();
		Assert.assertTrue(titleName.contains("Welcome - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
	  }
	
	@Test 
  public void test002_AvanceCource() {
		String titleName= Advancetatoc.AvanceCourseTest();
		Assert.assertTrue(titleName.contains("Hover Menu - Advanced Course - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
  }
	
	
	@Test
	  public void test003_menu_items() {
		String titleName= MenuItemsClass.test_menu_items();
		Assert.assertTrue(titleName.contains("Query Gate - Advanced Course - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
	}
	@Test 
	public void test004_database_entry()
	{
		String titleName= DatabaseConnectClass.Test_database_entry();
		System.out.println("db="+titleName);
		Assert.assertTrue(titleName.contains("Video Player - Advanced Course - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
	}
	
	@Test 
	public  void test005_rest_Service() throws InterruptedException, IOException, JSONException
	{
		String title= RestURLTest.rest_Service();
		System.out.println("rs="+title);
		Assert.assertTrue(title.contains("File Handle - Advanced Course - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
	}

	@Test
	public void test006_fileHandling() throws FileNotFoundException, InterruptedException
	{

		String endURL= FileHandlingInTatoc.fileHandling();
		
		Assert.assertTrue(endURL.contains("http://10.0.1.86/tatoc/end"));
		Reporter.log("Application Lauched successfully | ");
	}
	    
	

}