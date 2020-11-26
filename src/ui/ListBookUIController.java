package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.BookService;
import dao.IBookDAO;
import entity.Author;
import entity.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewmodel.bookviewmodel;

public class ListBookUIController extends CommonUI implements Initializable{
	IBookDAO dao;
	public ListBookUIController() {
		dao=new BookService();
	}
	@FXML
    private TableView<bookviewmodel> booktable;

    @FXML
    private TableColumn<bookviewmodel,Long> idcol;

    @FXML
    private TableColumn<bookviewmodel, String> namecol;

    @FXML
    private TableColumn<bookviewmodel, String> desccol;

    @FXML
    private TableColumn<bookviewmodel, Integer> unitpricecol;

    @FXML
    private TableColumn<bookviewmodel, String> authorcol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.idcol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		this.namecol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		this.desccol.setCellValueFactory(new PropertyValueFactory<>("Description"));
		this.unitpricecol.setCellValueFactory(new PropertyValueFactory<>("Unitprice"));
		this.authorcol.setCellValueFactory(new PropertyValueFactory<>("AuthorName"));
		booktable.setItems(getBookList());
		
	}
	ObservableList<bookviewmodel> getBookList(){
		ObservableList<bookviewmodel> bookList=FXCollections.observableArrayList();	
		bookList.addAll(dao.getAll());
		return bookList;
	}
	public void btnAddBookClick(ActionEvent e) throws IOException {
		Stage stage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/ui/AddBookUI.fxml"));
		Scene sence=new Scene(root);
		stage.setScene(sence);
		stage.setTitle("Add Book");
		stage.show();
	}
	public void clickItem(MouseEvent e) {
		booktable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {            
		            //Step 1
		        	Book b=new Book();
		            b.setId(booktable.getSelectionModel().getSelectedItem().getId());
		            b.setName(booktable.getSelectionModel().getSelectedItem().getName());
		            b.setDescription(booktable.getSelectionModel().getSelectedItem().getDescription());
		            b.setUnitprice(booktable.getSelectionModel().getSelectedItem().getUnitprice());
		            
		            //b.setAuthor(author);
		            // Step 2
		            Node node = (Node) event.getSource();
		            // Step 3
		            Stage stage = (Stage) node.getScene().getWindow();
		            stage.close();
		            try {

		              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/AddBookUI.fxml"));    		            
		              Parent root = (Parent)fxmlLoader.load();     
		              AddBookUIController controller = fxmlLoader.<AddBookUIController>getController();
		              controller.setBook(b);
		              // Step 6
		              Scene scene = new Scene(root);
		              stage.setScene(scene);
		              // Step 7
		              stage.show();
		            } catch (IOException e) {
		              System.err.println(String.format("Error: %s", e.getMessage()));
		            }
		        }
		    }
		});	
	}
	
	

}
