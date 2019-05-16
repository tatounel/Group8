package org.group8.schoolbus.org.group8.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;


public class ExampleOfTableViewTest extends ApplicationTest{

	@Test
	public void test() {
		assertTrue(true);
	}
	
	
	@Test
    public void testA() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
							new GUIDemo().start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						} 
                    }
                });
            }
        });
        thread.start();// Initialize the thread
        Thread.sleep(10000); // Time to use the app, with out this, the thread
                                // will be killed before you can tell.
    }
	 
	

	  public void start (Stage stage) throws Exception {
	    Parent mainNode = FXMLLoader.load(getClass().getResource("/Login.fxml"));
	    stage.setMaximized(true);
	    stage.setScene(new Scene(mainNode));
	    stage.show();
	    stage.toFront();
	  }

	  @Before
	  public void setUp () throws Exception {
	  }

	  @After
	  public void tearDown () throws Exception {
	    FxToolkit.hideStage();
	    release(new KeyCode[]{});
	    release(new MouseButton[]{});
	  }

	  @Test
	  public void testEnglishInput () {
	    clickOn("#userName");
	    clickOn("#password");
	    write("ankakom");
	  }
	  

	  @Test
	  public void testUrlData()
	  {		
		  String dataUrl = new String();
		  dataUrl = "https://data.cityofnewyork.us/resource/fbkk-fqs7.json";
		
		  assertEquals("https://data.cityofnewyork.us/resource/fbkk-fqs7.json", dataUrl);
	  }
	  
	 
	

}
