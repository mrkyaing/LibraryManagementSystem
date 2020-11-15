package ui;

import dao.AuthorService;
import dao.IAuthorDAO;
import entity.Author;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class AddAuthorUIController {
	Author editAuthor;
	@FXML
    private TextField txtauthorname;

    @FXML
    private TextField txtauthoremail;

    @FXML
    private TextArea txtauthoraddress;

    @FXML
    private RadioButton rdomale;

    @FXML
    private RadioButton rdofemale;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtauthorphone;
    public void setAuthor(Author a) {
    	this.editAuthor=a;
    	this.txtauthorname.setText(a.getName());
        this.txtauthoremail.setText(a.getEmail());
        this.txtauthoraddress.setText(a.getAddress());
        this.txtauthorphone.setText(a.getPhone());
        if(a.getGender().equals("male")) {
        	rdomale.setSelected(true);
        }
        else if(a.getGender().equals("female")) {
        	rdofemale.setSelected(true);
        }
        if(a!=null) {
        	btnSave.setText("Update");
        }
    }
    public void btnSaveClick(ActionEvent e) {
    	IAuthorDAO dao=new AuthorService();
    	String name=this.txtauthorname.getText();
    	String email=this.txtauthoremail.getText();
    	String gender=null;
    	if(rdomale.isSelected()) {
    		gender="male";
    	}else if(rdofemale.isSelected()) {
    		gender="female";
    	}
    	String phone=txtauthorphone.getText();
    	String address=txtauthoraddress.getText();
    	Author author=new Author(name,email,gender,phone,address);
  	     if(btnSave.getText().equals("Update"))
  	     {
  	    	 author.setId(this.editAuthor.getId());
  	    	 if(dao.update(author)) {
     			showDialog("Author Update success",AlertType.INFORMATION,"update");
     		}  		
     		else{
     		showDialog("Error occur when updating data",AlertType.ERROR,"error");
     		}
     		}else {
  	    	 if(dao.save(author)) {
     			showDialog("Author save success",AlertType.INFORMATION,"success");
     		}  		
     		else{
     		showDialog("Error occur when saving data",AlertType.ERROR,"error"); 
  	     }
  	    	
    	}
    	
    	
    }
    public void btnCancelClick(ActionEvent e) {
    	txtauthoraddress.clear();
    	txtauthoremail.clear();
    	txtauthorphone.clear();
    	txtauthorname.clear();
    	rdofemale.setSelected(false);
    	rdomale.setSelected(false);
    }
    private void showDialog(String msg,AlertType alttype,String title) {
    	Alert alert=new Alert(alttype);
    	 alert.setTitle(title);
    	 alert.setHeaderText(msg);
    	 alert.show();
    }
}
