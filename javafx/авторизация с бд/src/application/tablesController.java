package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class tablesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane enter;

    @FXML
    private Button goback;

    @FXML
    private Button showPersonal;

    @FXML
    private Button showhistory;

    @FXML
    private Button showinvetar;

    @FXML
    private Button showotchy;

    @FXML
    private Button showsklady;

    @FXML
    void initialize() {
    	goback.setOnAction(event -> {
    		
    		opennewcsene("/application/singup.fxml");
    	});
 
    	showinvetar.setOnAction(event -> {
    		
    		opennewcsene("/application/inventary.fxml");
    	});
    	
    	showPersonal.setOnAction(event -> {
    		
    		opennewcsene("/application/personal.fxml");
    	});
    	
    	showhistory.setOnAction(event -> {
    		
    		opennewcsene("/application/istoriy.fxml");
    	});
    	
    	showotchy.setOnAction(event -> {
    		
    		opennewcsene("/application/otchity.fxml");
    	});
    	
    	showsklady.setOnAction(event -> {
    		
    		opennewcsene("/application/skladi.fxml");
    	});

    }
    
    public void opennewcsene(String window) 
	{
    	
        goback.getScene().getWindow().hide();
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

