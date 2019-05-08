package org.group8.schoolbus.org.group8.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author
 */
public class GUIDemo extends Application {


	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/ExampleOfTableView.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Germania+One");
		stage.setScene(scene);
		stage.setFullScreen(true);
		VBox layout = new VBox(10);
		
		

		ScrollPane scroll = new ScrollPane(layout);
		
		scroll.prefWidthProperty().bind(stage.widthProperty());
		scroll.prefHeightProperty().bind(stage.heightProperty());
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
