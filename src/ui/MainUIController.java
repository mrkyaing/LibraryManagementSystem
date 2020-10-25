package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class MainUIController {
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
}
