package application;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enter;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pas;

    @FXML
    private Button signup;

    @FXML
    void initialize() {
    	
    	enter.setOnAction(Event -> {
    		String loginText= login.getText().trim();
    		String passText= pas.getText().trim();
    		if (!loginText.equals("")&& !passText.equals(""))
    			loginUser(loginText, passText);
    		else 
    		{Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ошибка!");
    		alert.setHeaderText("Поле логин или пароль пустое.");
    		alert.setContentText("Заполните поля логин и пароль.");

    		alert.showAndWait();}
    	});
    	
    signup.setOnAction(event ->{
    	opennewcsene("/application/registr.fxml");
    });

    }

	private void loginUser(String loginText, String passText) {
		DatabaseHandler dbHendler = new DatabaseHandler();
		User user = new User();
		user.setlog(loginText);
		user.setpas(passText);
		ResultSet result = dbHendler.getUser(user);
		
		int counter =0;
		try {
			while (result.next()) {
				counter ++;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if (counter>=1) {
			opennewcsene("/application/tables.fxml");
		}
		else 
		{
			{Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ошибка");
    		alert.setHeaderText("Логин или пароль введён не правильно.");
    		alert.setContentText("Проверьте правильность написания логина и пароля.");
    		alert.showAndWait();};
		}
	}
	public void opennewcsene(String window) 
	{
		signup.getScene().getWindow().hide();
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

