package org.group8.schoolbus.org.group8.project;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.group8.schoolbus.org.group8.project.ConnectionUtil;

/**
 *
 * @author tania
 * this is the controller for the forgot fxml which allows users to update their password 
 */
public class ForgotController implements Initializable {

    @FXML
    private Label lblErrors;

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField verifyPassword;
    @FXML
    private Button btnSignin;

    // variables for connecting to database
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

   
    /**
   	 * When this method is called, it will change the Scene to the Login scene
   	 */
   	public void changeScreentoLogin(ActionEvent event) throws IOException {
   		String status = updatePassword();
   		
   		//if password was updated, switch to login scene so users can now log in with their new password.
   		if(status == "Success") {
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
   		else {
   			lblErrors.setTextFill(Color.TOMATO);
   			lblErrors.setText(status);
   		}
   		
   	}
    /**
   	 * When this method is called, it will change the Scene to the Signup scene
   	 */
   	public void changeScreentoSignup(ActionEvent event) throws IOException {
   		
   		try {
   			
   			Parent root = FXMLLoader.load(getClass().getResource("/Signup.fxml"));
   			
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

    @Override
    /**
     * this method is always called first for the forgot scene, checks to make sure database is working properly
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
    }

    public ForgotController() {
        con = ConnectionUtil.conDB();

    }

    /**
     * checks database for user name and if found updates password for that user name
     * @return String success if password was updated successfully
     */
    private String updatePassword() {

        String email = userName.getText();
        String pw = password.getText();
        String vpw = verifyPassword.getText();

        //query
        String sql = "SELECT * FROM buswhere_users Where userName = ?";
       
        //check if both password fields match
        if(pw.equals(vpw)) {
	       
        	try {
	            preparedStatement = con.prepareStatement(sql);
	            preparedStatement.setString(1, email);
	            resultSet = preparedStatement.executeQuery();
	            
	            if (!resultSet.next()) {
	                return "Enter Correct Username/Email";
	            }
	           
	            String query = "UPDATE buswhere_users SET password = ? WHERE userName = ?";
	            
	            preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, pw);
	            preparedStatement.setString(2, email);
	            
	            int result = preparedStatement.executeUpdate(); 
	            
	            //executeUpdate returns number of items changed, should always be 1 in this case
	            if(result != 1) {
	            	return "Error executing update.";
	            }
	           
	            return "Success";
	            
	        } 
        	catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            return "Exception";
	        }
        }
        else {
        	return "Password fields do not match.";
        }
		
    }

}