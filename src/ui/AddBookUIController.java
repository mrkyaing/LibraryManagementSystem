package ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.AuthorService;
import dao.BookService;
import dao.IAuthorDAO;
import dao.IBookDAO;
import entity.Author;
import entity.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddBookUIController  implements Initializable{
	Author author;
	IBookDAO dao;
	IAuthorDAO adao;
	Book b;
	public AddBookUIController() {
		dao=new BookService();
		adao=new AuthorService();
		author=new Author();
	}
	
	public void setBook(Book b) {
		this.b=b;
		if(b!=null) {
			System.out.println("id:"+b.getId());
	    	this.txtdescription.setText(b.getDescription());
	    	this.txtname.setText(b.getName());	    	
	    	this.txtuniptrice.setText((String.valueOf(b.getUnitprice())));	    
	    	this.cboauthorList.getItems().add(String.valueOf(b.getAuthor().getId()));
		}
	}
	
	
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
		bindAuthorList();		    
	}

	private void bindAuthorList() {
		IAuthorDAO dao=new AuthorService();
	    List<Author> data=dao.getAllAuthor();
	    for(Author a:data) 
		cboauthorList.getItems().add(a.getId().toString());
	}
	

	public void SaveAction(ActionEvent e) {
		String name=this.txtname.getText();
		String desc=this.txtdescription.getText();
		double unitprice=Double.parseDouble(txtuniptrice.getText());
		
		Book book=new Book(name,desc,(int)unitprice,author);
	   if( dao.create(book)) {
		   showDialog("Book save success",AlertType.INFORMATION,"success");   
	   }
	}
   public void CboAction(ActionEvent e) {
		if(this.cboauthorList.getValue()!=null) {
			author=adao.getAuthorById(Long.parseLong(this.cboauthorList.getValue()));
		}
	   
	}
   public void CancelAction(ActionEvent e) {
		this.txtdescription.clear();
		this.txtname.clear();
		txtuniptrice.clear();
		cboauthorList.setPromptText("select one");
		
	}
   private void showDialog(String msg,AlertType alttype,String title) {
   	Alert alert=new Alert(alttype);
   	 alert.setTitle(title);
   	 alert.setHeaderText(msg);
   	 alert.show();
   }



   
}
