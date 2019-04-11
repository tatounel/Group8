package org.group8.schoolbus.org.group8.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 
 */
public class DataViewController implements Initializable {

	//private Person selectedPerson;
	
	@FXML
	private Label borough;
	@FXML
    private Label typeOfDelay;
	@FXML
    private Label busCompany;
	@FXML
    private Label busNum;
	@FXML
    private Label breakdownID;
	@FXML
    private Label informedOn;
	@FXML
    private Label schoolNotified;
	@FXML
    private Label optNotified;
	@FXML
    private Label parentsNotified;
	@FXML
    private Label occurredOn;
	@FXML
    private Label createdOn;
	@FXML
    private Label numOfStudents;
	@FXML
    private Label lastUpdated;
	@FXML
    private Label reason;
	@FXML
    private Label routeNum;
	@FXML
    private Label runType;
	@FXML
    private Label studentAges;
	@FXML
    private Label schoolYear;
	@FXML
    private Label schoolsServiced;
	@FXML
	private Image photo;


	/**
	 * This method accepts a person to initialize the view
	 * 
	 * @param person
	 */
	/*public void initData(Person person) {
		selectedPerson = person;
		
		firstNameLabel.setText(selectedPerson.getFirstName());
		lastNameLabel.setText(selectedPerson.getLastName());
		birthdayLabel.setText(selectedPerson.getBirthday().toString());
		ageLabel.setText(Integer.toString(selectedPerson.getAge()));
		photo.setImage(selectedPerson.getImage());
	}*/

	/**
	 * When this method is called, it will change the Scene to a TableView example
	 */
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/ExampleOfTableView.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * Initializes the controller class.
	 */
	//@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
