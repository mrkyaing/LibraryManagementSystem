package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainUIController {
	@FXML
    private MenuBar menuid;
	@FXML
	    private Menu menubook;

	    @FXML
	    private Menu authormenu;

	    @FXML
	    private Menu studentmenu;

	    @FXML
	    private Menu rentmenu;
	    
	    public void addbookmenuClick(ActionEvent e) throws IOException {
	    	Stage stage=new Stage();
    		Parent root=FXMLLoader.load(getClass().getResource("/ui/AddBookUI.fxml"));
    		Scene sence=new Scene(root);
    		stage.setScene(sence);
    		stage.setTitle("Add Book");
    		stage.show();
	    }
	    public void showbookmenuClick(ActionEvent e) throws IOException {
	    	Stage stage=new Stage();
    		Parent root=FXMLLoader.load(getClass().getResource("/ui/ListBookUI.fxml"));
    		Scene sence=new Scene(root);
    		stage.setScene(sence);
    		stage.setTitle("List Book");
    		stage.show();
	    }
	    
	    public void addaddauthormenuitemclick(ActionEvent e) throws IOException {
	    	Stage stage=new Stage();
	    	Parent root=FXMLLoader.load(getClass().getResource("/ui/AddAuthorUI.fxml"));
	    	Scene sence=new Scene(root);
	    	stage.setScene(sence);
	    	stage.setTitle("Add Author");
	    	stage.show();
	    }
	    public void Listauthormenuitemclick(ActionEvent e) throws IOException {
	    	Stage stage=new Stage();
	    	Parent root=FXMLLoader.load(getClass().getResource("/ui/ListAuthorUI.fxml"));
	    	Scene sence=new Scene(root);
	    	stage.setScene(sence);
	    	stage.setTitle("List Author");
	    	stage.show();
	    }
	    public void addStudentmenuitemclick(ActionEvent e) throws IOException {
	    	Stage stage=new Stage();
	    	Parent root=FXMLLoader.load(getClass().getResource("/ui/AddStudentUI.fxml"));
	    	Scene sence=new Scene(root);
	    	stage.setScene(sence);
	    	stage.setTitle("Add Student");
	    	stage.show();
	    }
	    public void ListStudentmenuitemclick(ActionEvent e) throws IOException {
	    	Stage stage=new Stage();
	    	Parent root=FXMLLoader.load(getClass().getResource("/ui/ListStudentUI.fxml"));
	    	Scene sence=new Scene(root);
	    	stage.setScene(sence);
	    	stage.setTitle("List Student");
	    	stage.show();
	    }
	    public void Logout(ActionEvent e) throws IOException {
	    	Alert alert = new Alert(AlertType.CONFIRMATION, "Are you Sure to logout?", ButtonType.YES, ButtonType.NO);
	    	alert.showAndWait();

	    	if (alert.getResult() == ButtonType.YES) {
	    		Stage menustage = (Stage) menuid.getScene().getWindow();
		    	menustage.close();	
		    	Parent root=FXMLLoader.load(getClass().getResource("/ui/LoginUI.fxml"));
		    	Scene sence=new Scene(root);
		    	Stage stage=new Stage();
		    	stage.setScene(sence);
		    	stage.setTitle("Login");
		    	stage.show();
	    	}
	    	
	    	
	    }
	    
}
