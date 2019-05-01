package org.group8.schoolbus.org.group8.project;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;


public class ExampleOfTableViewTest extends ApplicationTest{

	@Test
	public void test() {
		assertTrue(true);
	}

	  public void start (Stage stage) throws Exception {
	    Parent mainNode = FXMLLoader.load(getClass().getResource("/ExampleOfTableView.fxml"));
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
	    clickOn("#filterField");
	    write("hajerkfhkjhflewjfklwejiwejoirjweoijewoifj");
	  }
	  
	  @Test
	  public void testUrlData()
	  {		
		  String dataUrl = new String();
		  dataUrl = "https://data.cityofnewyork.us/resource/fbkk-fqs7.json";
		  JSONArray testUrl = null;
		
		  try {
			testUrl = new JSONArray(busData.getHTML(dataUrl));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		  assertEquals("https://data.cityofnewyork.us/resource/fbkk-fqs7.json", testUrl);
	  }
}