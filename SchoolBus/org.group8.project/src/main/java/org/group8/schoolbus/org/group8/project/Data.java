package org.group8.schoolbus.org.group8.project;

import org.json.JSONArray;
import org.json.JSONException;

import javafx.*;
import javafx.beans.property.*;


public class Data{

    private SimpleStringProperty borough;
    private SimpleStringProperty typeOfDelay;
    private SimpleStringProperty busCompany;
    private SimpleStringProperty busNum;
    private SimpleIntegerProperty breakdownID;
    private SimpleStringProperty informedOn;
    private SimpleStringProperty schoolNotified;
    private SimpleStringProperty optNotified;
    private SimpleStringProperty parentsNotified;
    private SimpleStringProperty occurredOn;
    private SimpleStringProperty createdOn;
    private SimpleIntegerProperty numOfStudents;
    private SimpleStringProperty lastUpdated;
    private SimpleStringProperty reason;
    private SimpleStringProperty routeNum;
    private SimpleStringProperty runType;
    private SimpleStringProperty studentAges;
    private SimpleStringProperty schoolYear;
    private SimpleStringProperty schoolsServiced;

/*constructor to load up parsed JSON data in the form of objects, before being 
loaded into the columns of the JavaFX tableview*/
    Data(String borough,String typeOfDelay,String busCompany,String busNum,int breakdownID,String informedOn,String schoolNotified,
    		String optNotified, String parentsNotified, String occurredOn, String createdOn, int numOfStudents, String lastUpdated,
    		String reason, String routeNum, String runType, String studentAges, String schoolYear, String schoolsServiced){
    
        this.borough = new SimpleStringProperty(borough);
        this.typeOfDelay = new SimpleStringProperty(typeOfDelay);
        this.busCompany = new SimpleStringProperty(busCompany);
        this.busNum = new SimpleStringProperty(busNum);
        this.breakdownID = new SimpleIntegerProperty(breakdownID);
        this.informedOn = new SimpleStringProperty(informedOn);
        this.schoolNotified = new SimpleStringProperty(schoolNotified);
        this.optNotified = new SimpleStringProperty(optNotified);
        this.parentsNotified = new SimpleStringProperty(parentsNotified);
        this.occurredOn = new SimpleStringProperty(occurredOn);
        this.createdOn = new SimpleStringProperty(createdOn);
        this.numOfStudents = new SimpleIntegerProperty(numOfStudents);
        this.lastUpdated = new SimpleStringProperty(lastUpdated);
        this.reason = new SimpleStringProperty(reason);
        this.routeNum = new SimpleStringProperty(routeNum);
        this.runType = new SimpleStringProperty(runType);
        this.studentAges = new SimpleStringProperty(studentAges);
        this.schoolYear = new SimpleStringProperty(schoolYear);
        this.schoolsServiced = new SimpleStringProperty(schoolsServiced);
       

    }

//getter methods defined so that the tableview could extract each property value into the respective columns.
	    public String getBorough() {
	        return borough.get();
	    }
	
	    public void setBorough(String text) {
			this.borough = new SimpleStringProperty(text);
		}
	    
	    public String getTypeOfDelay() {
	        return typeOfDelay.get();
	    }
	
	    public void setTypeOfDelay(String text) {
			this.typeOfDelay = new SimpleStringProperty(text);
		}
	    
	    public String getBusCompany() {
	        return busCompany.get();
	    }
	
	    public void setBusCompany(String text) {
			this.busCompany = new SimpleStringProperty(text);
		}
	    
	    public String getBusNum() {
	        return busNum.get();
	    }
	
	    public void setBusNum(String text) {
			this.busNum = new SimpleStringProperty(text);
		}
	    
	    public int getBreakdownID() {
	        return breakdownID.get();
	    }
	
	    public void setBreakdownID(Integer num) {
			this.breakdownID = new SimpleIntegerProperty(num);
		}
	    
	    public String getInformedOn() {
	        return informedOn.get();
	    }
	
	    public void setInformedOn(String text) {
			this.informedOn = new SimpleStringProperty(text);
	    }
	    
	    public String getSchoolNotified() {
	        return schoolNotified.get();
	    }
	
	    public void setSchoolNotified(String text) {
			this.schoolNotified = new SimpleStringProperty(text);
	    }
	    
	    public String getOptNotified() {
	        return optNotified.get();
	    }
	     
	    public void setOptNotified(String text) {
			this.optNotified = new SimpleStringProperty(text);
	    }
	    
	    public String getParentsNotified() {
	        return parentsNotified.get();
	    }
	    
	    public void setParentsNotified(String text) {
			this.parentsNotified = new SimpleStringProperty(text);
		}
	    
	    public String getOccurredOn() {
	        return occurredOn.get();
	    } 
	    
	    public void setOccurredOn(String text) {
			this.occurredOn = new SimpleStringProperty(text);
	    }
	    
	    public String getCreatedOn() {
	        return createdOn.get();
	    } 
	    
	    public void setCreatedOn(String text) {
			this.createdOn = new SimpleStringProperty(text);
	    }
	    
	    public int getNumOfStudents() {
	        return numOfStudents.get();
	    } 
	    
	    public void setNumOfStudents(Integer num) {
			this.numOfStudents = new SimpleIntegerProperty(num);
		}
	    
	    public String getLastUpdated() {
	        return lastUpdated.get();
	    } 
	    
	    public void setLastUpdated(String text) {
			this.lastUpdated = new SimpleStringProperty(text);
	    }
	    
	    public String getReason() {
	        return reason.get();
	    } 
	    
	    public void setReason(String text) {
			this.reason = new SimpleStringProperty(text);
	    }
	    
	    public String getRouteNum() {
	        return routeNum.get();
	    }
	    
	    public void setRouteNum(String text) {
			this.routeNum = new SimpleStringProperty(text);
	    }
	    
	    public String getRunType() {
	        return runType.get();
	    } 
	    
	    public void setRunType(String text) {
			this.runType = new SimpleStringProperty(text);
	    }
	    
	    public String getStudentAges() {
	        return studentAges.get();
	    } 
	    
	    public void setStudentAges(String text) {
			this.studentAges = new SimpleStringProperty(text);
	    }
	    
	    public String getSchoolYear() {
	        return schoolYear.get();
	    } 
	    
	    public void setSchoolYear(String text) {
			this.schoolYear = new SimpleStringProperty(text);
	    }
	    
	    public String getSchoolsServiced() {
	        return schoolsServiced.get();
	    }  
	    
	    public void setSchoolsServiced(String text) {
			this.schoolsServiced = new SimpleStringProperty(text);
	    }
	    
	    /*public static void main( String[] args ) throws Exception, JSONException
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
	        	int  noOfStudents = objArr.getJSONObject(i).getInt("number_of_students_on_the_bus");
	        	if(objArr.getJSONObject(i).has("how_long_delayed")) {
	        		delay = objArr.getJSONObject(i).getString("how_long_delayed");
	        		isDelayed = true;
	        	}
	    }*/
}

	