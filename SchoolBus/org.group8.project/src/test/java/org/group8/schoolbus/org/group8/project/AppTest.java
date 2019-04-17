package org.group8.schoolbus.org.group8.project;

import java.net.MalformedURLException;
import java.net.URL;


import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
  
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @Test
    public void url_assertions_examples() throws MalformedURLException
    {
    		String urlToRead = "https://data.cityofnewyork.us/resource/fbkk-fqs7.json";
    	
     //   JSONArray objArr = new JSONArray(busData.getHTML(urlToRead));;
    		String expected = "{friends:[{id:123,name:\"Corby Page\"},{id:456,name:\"Carter Page\"}]}";
    	//	JSONAssert.assertEquals(expected, objArr, false);
    }
    }

