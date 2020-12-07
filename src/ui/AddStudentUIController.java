package ui;

import java.util.regex.Pattern;

import dao.IStudentDAO;
import dao.StudentService;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class AddStudentUIController extends CommonUI{	
	IStudentDAO dao;
	
	@FXML
    private TextField txtno;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextArea txtaddress;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnaddress;

    @FXML
    private RadioButton rdomale;

    @FXML
    private RadioButton rdofemale;
    
    
    public AddStudentUIController() {
		dao =new StudentService();
		 
	}


	public void SaveAction(ActionEvent e) {
    	String gender=null;
    	if(rdomale.isSelected()) {
    		gender="male";
    	}else if(rdofemale.isSelected()) {
    		gender="female";
    	}
    	Student entity=new Student(this.txtno.getText(),txtname.getText(),gender,txtemail.getText(),txtphone.getText(),txtaddress.getText());
    	if(dao.save(entity)) {
    		showDialog("Student save success",AlertType.INFORMATION,"success");
    	}else {
    		showDialog("Student save fail",AlertType.ERROR,"Error");
    	}
    }
    
	
}
