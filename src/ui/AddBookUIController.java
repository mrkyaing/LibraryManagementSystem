package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class AddBookUIController implements Initializable{
	
	@FXML
    private TextField txtname;

    @FXML
    private TextField txtdescription;

    @FXML
    private TextField txtuniptrice;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;
    
    @FXML
    private ComboBox<String> cboauthorList;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cboauthorList.getItems().add("smith");
		cboauthorList.getItems().add("C.J Date");
		
	}
    
    
    
}
