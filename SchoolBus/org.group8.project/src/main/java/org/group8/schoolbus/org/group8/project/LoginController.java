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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.group8.schoolbus.org.group8.project.ConnectionUtil;

/**
 *
 * @author oXCToo
 */
public class LoginController implements Initializable {

    @FXML
    private Label lblErrors;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;

    /// -- 
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignin) {
            //login here
            if (logIn().equals("Success")) {
                try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/OnBoard.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    }
    /**
   	 * When this method is called, it will change the Scene to the Login scene
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
	 * When this method is called, it will change the Scene to the Login scene
	 */
	public void changeScreentoTable(ActionEvent event) throws IOException {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/ExampleOfTableView.fxml"));
			
			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Germania+One");
			window.setFullScreen(true);
			//window.setScene(scene);
			
			
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
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }*/
    }

    public LoginController() {
        con = ConnectionUtil.conDB();

    }

    //we gonna use string to check for status
    private String logIn() {

        String email = txtUsername.getText();
        String password = txtPassword.getText();

        //query
        String sql = "SELECT * FROM admins Where email = ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                lblErrors.setTextFill(Color.TOMATO);
                lblErrors.setText("Enter Correct Email/Password");
                System.err.println("Wrong Logins --///");
                return "Error";

            } else {
                lblErrors.setTextFill(Color.GREEN);
                lblErrors.setText("Login Successful..Redirecting..");
                System.out.println("Successfull Login");
                return "Success";
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }

}