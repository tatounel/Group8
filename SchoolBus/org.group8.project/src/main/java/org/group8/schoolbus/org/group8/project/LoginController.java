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
import javafx.scene.control.Hyperlink;
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
 *
 * @author tania
 * controller for login fxml scene which is what users first see and allows them to login
 * or click on button to sign up
 */
public class LoginController implements Initializable {

    @FXML
    private Label lblErrors;
    @FXML
    private Hyperlink lblForgot;
    @FXML
    private Hyperlink skipLogin;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    @FXML
    private Button btnSignin;

    /// -- 
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    
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
    /**
   	 * When this method is called, it will change the Scene to the Forgot Password scene
   	 */
   	public void changeScreentoForgot(ActionEvent event) throws IOException {
   		
   		try {
   			
   			Parent root = FXMLLoader.load(getClass().getResource("/Forgot.fxml"));
   			
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
	 * after verifying that user has logged in.
	 */
	public void changeScreentoTable(ActionEvent event) throws IOException {
		if (logIn().equals("Success")) {
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
	/**
	 * When this method is called, it will change the Scene to the Table scene
	 * immediately
	 */
	public void changeScreentoTableNow(ActionEvent event) throws IOException {
		
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
				
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

    @Override
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

    public LoginController() {
        con = ConnectionUtil.conDB();

    }

    /**
     * checks database for inputted values of username and password
     * @return success if username and password match that of database and error if not
     */
    private String logIn() {

        String email = userName.getText();
        String pw = password.getText();

        //query
        String sql = "SELECT * FROM buswhere_users Where userName = ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pw);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                lblErrors.setTextFill(Color.TOMATO);
                lblErrors.setText("Enter Correct Username/Email or Password");
                return "Error";

            } else {
                lblErrors.setTextFill(Color.GREEN);
                lblErrors.setText("Login Successful..Redirecting..");
                return "Success";
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }

}