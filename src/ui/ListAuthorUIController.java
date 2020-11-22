package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.AuthorService;
import dao.IAuthorDAO;
import entity.Author;
import entity.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListAuthorUIController extends CommonUI implements Initializable{
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

	public void clickItem(MouseEvent e) {
		authortable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {            		        	
		        	Alert alert = new Alert(AlertType.CONFIRMATION);
		            alert.setTitle("Select action (UPDATE,DELETE)");
		            alert.setHeaderText("Choose the action you like:");		     
		            ButtonType updateaction = new ButtonType("Update");
		            ButtonType deleteaction = new ButtonType("Delete");
		            // Remove default ButtonTypes
		            alert.getButtonTypes().clear();
		            alert.getButtonTypes().addAll(updateaction,deleteaction);
		            // option != null.
		            Optional<ButtonType> option = alert.showAndWait();		       
		            if (option.get() ==updateaction) {
		            	//Step 1
			        	Author author=new Author();
			        	author.setId(authortable.getSelectionModel().getSelectedItem().getId());
			        	author.setName(authortable.getSelectionModel().getSelectedItem().getName());
			        	author.setEmail(authortable.getSelectionModel().getSelectedItem().getEmail());
			        	author.setAddress(authortable.getSelectionModel().getSelectedItem().getAddress());
			            author.setGender(authortable.getSelectionModel().getSelectedItem().getGender());
			            author.setPhone(authortable.getSelectionModel().getSelectedItem().getPhone());		            
			            // Step 2
			            Node node = (Node) event.getSource();
			            // Step 3
			            Stage stage = (Stage) node.getScene().getWindow();
			            stage.close();
			            try {
			              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/AddAuthorUI.fxml"));    		            
			              Parent root = (Parent)fxmlLoader.load();     
			              AddAuthorUIController controller = fxmlLoader.<AddAuthorUIController>getController();
			              controller.setAuthor(author);
			              // Step 6
			              Scene scene = new Scene(root);
			              stage.setScene(scene);
			              // Step 7
			              stage.show();
			            } catch (IOException e) {
			              System.err.println(String.format("Error: %s", e.getMessage()));
			            }
		            } else if (option.get() ==deleteaction) {		        
		                    Long id=authortable.getSelectionModel().getSelectedItem().getId();
		                    IAuthorDAO dao=new AuthorService();
		                    String delmsg=dao.delete(id);
		                    if(delmsg.equals(null)) {
		                    	showDialog("Author delete success",AlertType.INFORMATION,"success");	
		                    }else {
		                    	showDialog(delmsg,AlertType.ERROR,"Error");		                    }
		            } 		        			        	
		        }
		    }
		});	
	}
}
