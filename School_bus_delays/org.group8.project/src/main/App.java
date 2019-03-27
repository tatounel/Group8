package org.group8.schoolbus.org.group8.project;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class App 
{
    public static void main( String[] args ) throws Exception, JSONException
    {
    	boolean isDelayed = false;
    	String delay = null;
        System.out.println(busData.getHTML("https://data.cityofnewyork.us/resource/fbkk-fqs7.json"));
    	String urlToRead = "https://data.cityofnewyork.us/resource/fbkk-fqs7.json";
    	System.out.println(busData.getHTML("https://data.cityofnewyork.us/resource/fbkk-fqs7.json").trim().charAt(0));
        JSONArray objArr = new JSONArray(busData.getHTML(urlToRead));
       
        
        for(int i = 0; i < objArr.length(); i++) {
        	String busNo = objArr.getJSONObject(i).getString("bus_no");
        	String parentNotified = objArr.getJSONObject(i).getString("has_contractor_notified_parents");
        	String schoolNotified = objArr.getJSONObject(i).getString("has_contractor_notified_schools");
        	if(objArr.getJSONObject(i).has("how_long_delayed")) {
        		delay = objArr.getJSONObject(i).getString("how_long_delayed");
        		isDelayed = true;
        	}
        	
        	System.out.println("Bus Number: " + busNo);
        	if(isDelayed) {
        		System.out.println("Delay: " + delay);
        		isDelayed = false;
        	}
        	else {
        		System.out.println("Bus was not delayed");
        	}
        	
        	System.out.println("Parent Notification: " + parentNotified);
        	System.out.println("School Notification: " + schoolNotified + "\n");
        }
    }
}
