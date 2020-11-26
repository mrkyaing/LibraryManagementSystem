package ui;

import java.net.URL;
import java.util.ResourceBundle;

import dao.IStudentDAO;
import dao.StudentService;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import viewmodel.bookviewmodel;

public class ListStudentController extends CommonUI implements Initializable{
	    IStudentDAO dao; 
	    public ListStudentController() {
		this.dao = new StudentService();
	}
		@FXML
	    private TableView<Student> tblstudent;

	    @FXML
	    private TableColumn<Student, String> colrollno;

	    @FXML
	    private TableColumn<Student, String> colname;

	    @FXML
	    private TableColumn<Student, String> colgender;

	    @FXML
	    private TableColumn<Student, String> colemail;

	    @FXML
	    private TableColumn<Student, String> colphone;

	    @FXML
	    private TableColumn<Student, String> coladdress;

	    @FXML
	    private TableColumn<Student, Long> colid;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			this.colrollno.setCellValueFactory(new PropertyValueFactory<>("No"));
			this.colid.setCellValueFactory(new PropertyValueFactory<>("Id"));
			this.colname.setCellValueFactory(new PropertyValueFactory<>("Name"));
			this.colemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			this.colphone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			this.coladdress.setCellValueFactory(new PropertyValueFactory<>("Address"));
			this.colgender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
			tblstudent.setItems(getStudentList());
			
		}
		ObservableList<Student> getStudentList(){
			ObservableList<Student> studentList=FXCollections.observableArrayList();	
			studentList.addAll(dao.getAllStudent());
			return studentList;
		}
}
