package LocatorMapping;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LocatorMap {
	static HashMap<String, String> h1 = new HashMap<String, String>();
	static HashMap<String, String> h2 = new HashMap<String, String>();

	
	public LocatorMap()
	{
		
		String filePath=("C:\\Users\\rashigupta\\workspace1\\advance_tatoc\\src\\test\\java\\LocatorsFile");
		 String strCurrentLine;
		 BufferedReader br= null;
			try{
		br= new BufferedReader (new FileReader(filePath));
		
		    
		while ((strCurrentLine = br.readLine()) != null) {
		   
	String[] arrLocator = strCurrentLine.split(":");
	
			String locatorName = arrLocator[0].trim();
			String locatorTag = arrLocator[2].trim();
			String objectLocator = arrLocator[4].trim();
			/*       System.out.println("locatorName" +locatorName);
					 System.out.println("locatorTag"+locatorTag);
					System.out.println("objectLocator"+objectLocator);
			*/
		
			h1.put(locatorName, locatorTag);
			h2.put(locatorName, objectLocator);
			
			
		    
		} }
		catch (IOException e) {

			   e.printStackTrace();

			  } finally {

			   try {
			    if (br != null)
			     br.close();
			   } catch (IOException ex) {
			    ex.printStackTrace();
			   }
		}
	}
	
	
	public static String getElementByTag(String locatorName1)
	{     //System.out.println("locatorName" +h1.get(locatorName1));
		return h1.get(locatorName1);
	}
	public static String getElementByValue(String locatorName1)
	{ //System.out.println("locatortage" +h2.get(locatorName1));
		return h2.get(locatorName1);
	}
}
	
