package rashi.advance_tatoc;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import UtilPackage.LocatorCall;

public class RestURLTest {
	static WebDriver driver=BrowserDetails.driver;
	static LocatorCall lc= new LocatorCall(driver);
	public static String rest_Service() throws InterruptedException, IOException, JSONException
	{
		driver.get("http://10.0.1.86/tatoc/advanced/rest");
		
		String sessid = lc.getWebElementsTag("sessID").getText();
        sessid = sessid.substring(12,sessid.length());
        String Resturl = "http://10.0.1.86/tatoc/advanced/rest/service/token/"+sessid;

        URL url = new URL(Resturl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String responsejson=new String(response);
        
        JSONObject obj=new JSONObject(responsejson);
        responsejson=(String) obj.get("token");
        
        URL url1 = new URL("http://10.0.1.86/tatoc/advanced/rest/service/register");
        HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
        

        conn1.setRequestMethod("POST");
        
        conn1.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "id="+sessid+"&signature="+responsejson+"&allow_access=1";
        
        conn1.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn1.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = conn1.getResponseCode();
        
        conn1.disconnect();
        
        lc.getWebElementsTag("restClick").click();
        Thread.sleep(1000);
	    return driver.getTitle();
	   
	}
}