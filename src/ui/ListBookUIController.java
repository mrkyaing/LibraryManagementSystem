package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import entity.Author;
import entity.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListBookUIController implements Initializable{
	@FXML
    private TableView<Book> booktable;

    @FXML
    private TableColumn<Book,Long> idcol;

    @FXML
    private TableColumn<Book, String> namecol;

    @FXML
    private TableColumn<Book, String> desccol;

    @FXML
    private TableColumn<Book, Integer> unitpricecol;

    @FXML
    private TableColumn<Book, Author> authorcol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.idcol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		this.namecol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		this.desccol.setCellValueFactory(new PropertyValueFactory<>("Description"));
		this.unitpricecol.setCellValueFactory(new PropertyValueFactory<>("Unitprice"));
		this.authorcol.setCellValueFactory(new PropertyValueFactory<>("Author"));
		booktable.setItems(getBookList());
		
	}
	ObservableList<Book> getBookList(){
		ObservableList<Book> userlist=FXCollections.observableArrayList();
		userlist.add(new Book("java","Java Programming",200,new Author("smith","smith@gmail.com","male","123","ygn")));		
		return userlist;
	}
	public void btnAddBookClick(ActionEvent e) throws IOException {
		Stage stage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/ui/AddBookUI.fxml"));
		Scene sence=new Scene(root);
		stage.setScene(sence);
		stage.setTitle("Add Book");
		stage.show();
	}
}
