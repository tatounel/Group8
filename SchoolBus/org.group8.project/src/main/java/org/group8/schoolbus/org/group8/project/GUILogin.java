package org.group8.schoolbus.org.group8.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author
 */
public class GUILogin extends Application {


	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/Signup.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Germania+One");
		stage.setScene(scene);
		stage.setFullScreen(true);
		
		HBox layout = new HBox(10);
		
		layout.prefWidthProperty().bind(stage.widthProperty());
		layout.prefHeightProperty().bind(stage.heightProperty());
		

		
		
	
		stage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
