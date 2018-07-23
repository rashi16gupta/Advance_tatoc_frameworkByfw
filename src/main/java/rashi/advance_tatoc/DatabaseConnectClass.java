package rashi.advance_tatoc;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import UtilPackage.LocatorCall;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnectClass {
	static WebDriver driver=BrowserDetails.driver;
	static LocatorCall lc= new LocatorCall(driver);
	public static String Test_database_entry()
	{
		try {
	
	Class.forName("com.mysql.jdbc.Driver");
		
	String dbUrl="jdbc:mysql://10.0.1.86:3306/tatoc";
	String username="tatocuser";
			String password="tatoc01";
			
	String symbol= lc.getWebElementsTag("symbolDisplay").getText();

	System.out.println("symbol="+symbol);
	String query1="select * from identity";
	String query2="select * from credentials";
	String id=null;
	String name=null;
	String passkey=null;
	Connection con = DriverManager.getConnection(dbUrl,username,password);
	Statement stmt = con.createStatement();	
	ResultSet rs= stmt.executeQuery(query1);
	while (rs.next()){
/*	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
	
	*/
		
		if(rs.getString(2).equalsIgnoreCase(symbol))
		{id=rs.getString(1);
		System.out.println("id="+id);}
		
	}
	ResultSet rs1= stmt.executeQuery(query2);
	while (rs1.next()){
/*	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getString(3));
	*/
		
		if(rs1.getString(1).equals(id)){
		{
			name=rs1.getString(2);
			passkey=rs1.getString(3);
			System.out.println(name+" "+ passkey);
			
			lc.getWebElementsTag("uname").sendKeys(name);
			lc.getWebElementsTag("upass").sendKeys(passkey);
			lc.getWebElementsTag("uclick").click();
			
			
		}
	}
	
	} 
}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return driver.getTitle();
				}
}