
package org.group8.schoolbus.org.group8.project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.group8.schoolbus.org.group8.project.ConnectionUtil;


/**
 * FXML Controller class for Signup
 *
 */
public class SignupController implements Initializable {
	@SuppressWarnings("rawtypes")
	@FXML
    private ChoiceBox typeBox;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField verifyPassword;
   
    @FXML
    private Button btnCreate;
    
    @FXML
    Label lblStatus;

    private ObservableList<String> choiceBoxData = FXCollections.observableArrayList();
	
    //variables for connecting to database
    PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet = null;

    
    //selections for choiceBox
	public ObservableList<String> getData(){
		
		choiceBoxData.add(("Parent"));
		choiceBoxData.add(("School Administrator"));
		choiceBoxData.add(("Office of Pupil Transport Staff"));
		
		return choiceBoxData; 
	}
    
   
    /**
     * Initializes the controller class.
     */
    public SignupController() {
        connection = (Connection) ConnectionUtil.conDB();
    }

    @SuppressWarnings("unchecked")
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        //adds items to choicebox
    	typeBox.setValue("Parent");
		typeBox.setItems(getData());
        
    }

    
    /**
     * called when signup button is pressed
     * checks if text and password fields are empty and calls saveData() if all are filled
     * switches to table scene when done
     * @param event
     * @throws IOException
     */
    @FXML
    private void HandleEvents(ActionEvent event) throws IOException {
        //
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || userName.getText().isEmpty() || password.getText().isEmpty() || verifyPassword.getText().isEmpty()) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } 
        
        else if(saveData() == "Success"){
            changeScreentoTable(event);
        }

    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        userName.clear();
        password.clear();
        verifyPassword.clear();
    }
    
    /**
     * saves inputs from text and password fields as new user in database
     * @return String success if values where added to database and exception if error occurred.
     */
    private String saveData() {
    	if(password.getText().equals(verifyPassword.getText())){
	       try {
	            String sql = "SELECT * FROM buswhere_users Where userName = ?";
	
	            String st = "INSERT INTO buswhere_users ( firstName, lastName, userName, password) VALUES (?,?,?,?)";
	            
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, userName.getText());
	            resultSet = preparedStatement.executeQuery();
	            
	            //first checks if username is already in database
	            if (resultSet.next()) {
	            	lblStatus.setTextFill(Color.TOMATO);
	                lblStatus.setText("That username has already been taken.");
	                return "";
	            }
	            else {
	            	preparedStatement = (PreparedStatement) connection.prepareStatement(st);
	                preparedStatement.setString(1, firstName.getText());
	                preparedStatement.setString(2, lastName.getText());
	                preparedStatement.setString(3, userName.getText());
	                preparedStatement.setString(4, password.getText());
	
	                preparedStatement.executeUpdate();
	                lblStatus.setTextFill(Color.GREEN);
	                lblStatus.setText("Account Created!");
	
	              
	                clearFields();
	                return "Success";
	
	            }
	            
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            lblStatus.setTextFill(Color.TOMATO);
	            lblStatus.setText(ex.getMessage());
	            return "Exception";
	        }
    	}
    	else {
        	lblStatus.setText("Password fields do not match.");
        	return "Passwords don't match";
    	}
    }


    /**
	 * When this method is called, it will change the Scene to the Login scene
	 */
	public void changeScreentoLogin(ActionEvent event) throws IOException {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
			
			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Germania+One");
			window.setScene(scene);
			window.setFullScreen(true);
			
			HBox layout = new HBox(10);
			
			layout.prefWidthProperty().bind(window.widthProperty());
			layout.prefHeightProperty().bind(window.heightProperty());
		
			window.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
   
	/**
	 * When this method is called, it will change the Scene to the Table scene
	 */
	public void changeScreentoTable(ActionEvent event) throws IOException {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/ExampleOfTableView.fxml"));
			
			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Germania+One");
			window.setScene(scene);

			window.setFullScreen(true);
			window.setMaximized(true);
			
			
			VBox layout = new VBox(10);
	
			ScrollPane scroll = new ScrollPane(layout);
			
			scroll.prefWidthProperty().bind(window.widthProperty());
			scroll.prefHeightProperty().bind(window.heightProperty());
			layout.prefWidthProperty().bind(window.widthProperty());
			layout.prefHeightProperty().bind(window.heightProperty());
			window.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
   
    

}
