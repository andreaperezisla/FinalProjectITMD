package controllers;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.DaoModel;


public class signupController {
	
	
	@FXML
	private Button registerUser;
	@FXML
	private Button cancel;
	
	@FXML
	private TextField user_name;
	@FXML
	private TextField user_id;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	
	public void registerUser(ActionEvent event) throws IOException{
		Main m = new Main();
		
		
		UsersRecords u = new UsersRecords(user_name.getText().toString(), user_id.getText().toString(), "Client", username.getText().toString(),password.getText().toString(),"");
		
		DaoModel dao = new DaoModel();
		dao.insertNewUser(u);

		m.changeScene("/views/login.fxml");
	}
	
	public void cancelButton(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/login.fxml");
	}
	
	
}
