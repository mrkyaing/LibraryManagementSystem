package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class LoginUIController {

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblloginStatus;
    
    
  
    public void login(ActionEvent e) throws IOException{ 	  	
    	if(txtusername.getText().isEmpty()) {
    		this.showDialog("please fill user name!!");
    		return;
    	}
    	if(txtpassword.getText().isEmpty()) {
    		this.showDialog("please fill password!!");
    		return;
    	}
    	if(txtusername.getText().equals("admin")
    	 &&txtpassword.getText().equals("prodev@123")){
    		Stage stage=new Stage();//create the stage Object
    		//for closing Login UI 
    		Node node = (Node)e.getSource();//current node status
    		stage = (Stage) node.getScene().getWindow();//read the current window
    		stage.close();//close the current window dialog
    		//for calling main UI Window
    		Parent root=FXMLLoader.load(getClass().getResource("/ui/MainUI.fxml"));
    		Scene sence=new Scene(root);   		  		
    		stage.setScene(sence);
    		stage.setTitle("Library Management System");
    		stage.show();
    	}else {
    		this.lblloginStatus.setText("User Name or Password is wrong .");
    		this.lblloginStatus.setTextFill((Paint.valueOf("red")));
    	}
    			
    }//end of login method
    public void cancel(ActionEvent e) {
    	txtpassword.clear();
    	txtusername.clear();
    	lblloginStatus.setText("login status");
    }//end of cancel method 
    
   private void showDialog(String message) {
	   Alert alert=new Alert(AlertType.ERROR);
	   alert.setTitle("Error");
	   alert.setHeaderText(message);
	   alert.showAndWait();
   }//end of showdialog
    
}//end of class 
