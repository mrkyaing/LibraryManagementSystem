package ui;

import java.net.URL;
import java.util.ResourceBundle;

import dao.AuthorService;
import dao.IAuthorDAO;
import entity.Author;
import entity.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListAuthorUIController implements Initializable{
	@FXML
    private TableView<Author> authortable;

    @FXML
    private TableColumn<Author,Long> idcol;

    @FXML
    private TableColumn<Author, String> namecol;

    @FXML
    private TableColumn<Author, String> emailcol;

    @FXML
    private TableColumn<Author, String> gendercol;

    @FXML
    private TableColumn<Author, String> phonecol;

    @FXML
    private TableColumn<Author, String> addresscol;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		this.idcol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		this.namecol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		this.emailcol.setCellValueFactory(new PropertyValueFactory<>("Email"));
		this.gendercol.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		this.phonecol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
		this.addresscol.setCellValueFactory(new PropertyValueFactory<>("Address"));
		authortable.setItems(getAuthorList());
		
	}
	ObservableList<Author> getAuthorList(){
		ObservableList<Author> data=FXCollections.observableArrayList();
		IAuthorDAO dao=new AuthorService();
		data.addAll(dao.getAllAuthor());
		return data;
	}
}
