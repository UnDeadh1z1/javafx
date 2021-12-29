package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class skladiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button back;

    @FXML
    private Button change;

    @FXML
    private Button del;

    @FXML
    void initialize() {
    	back.setOnAction(event -> {
    		
    		opennewcsene("/application/tables.fxml");
    	});

    }
    public void opennewcsene(String window) 
	{
    	
    	back.getScene().getWindow().hide();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource(window));
        try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
        Parent root =loader.getRoot();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root));
        stage1.showAndWait();
	} 

}


