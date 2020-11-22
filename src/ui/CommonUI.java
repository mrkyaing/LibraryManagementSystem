package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CommonUI {
	
	protected static void showDialog(String msg,AlertType alttype,String title) {
    	Alert alert=new Alert(alttype);
    	 alert.setTitle(title);
    	 alert.setHeaderText(msg);
    	 alert.show();
    }
}
