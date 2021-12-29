package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registrController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField dolznot;

    @FXML
    private TextField fio;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pass;

    @FXML
    private Button zareg;
   
    @FXML
    private TextField ID;

    @FXML
    void initialize() {

    	zareg.setOnAction(event -> {
    		
    		singupnewuser();
    		opennewcsene("/application/singup.fxml");
    		
    		
    	});

    }

	private void singupnewuser() {
    	DatabaseHandler dbHandler = new DatabaseHandler();
    	
		Integer id_rsbotnika = Integer.parseInt(ID.getText());
		String FIO = fio.getText();
		String dolznost = dolznot.getText();
		String log = login.getText();
		String pas = pass.getText();
		
		User user = new User(id_rsbotnika, FIO, dolznost, log, pas);
		
		dbHandler.singupuser(user);
		
	}
	public void opennewcsene(String window) 
	{
		
		zareg.getScene().getWindow().hide();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource(window));
        try {
			loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        Parent root =loader.getRoot();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root));
        stage1.showAndWait();
	} 
}


