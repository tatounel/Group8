package org.group8.schoolbus.org.group8.project;

import java.net.MalformedURLException;
import java.net.URL;


import junit.framework.TestCase;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


/**
 * Unit test for simple App
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
     * Rigorous Test :-)
     * @return the suite of tests being tested
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @Test
    public void url_assertions_examples() throws MalformedURLException
    {
    	 assertThat(new URL("https://data.cityofnewyork.us/resource/fbkk-fqs7.jso")).hasParameter("m");
    }
    }

