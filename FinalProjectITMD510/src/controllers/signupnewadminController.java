package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.DaoModel;

public class signupnewadminController implements Initializable{
	
	
	@FXML
	private Button registerUser;
	@FXML
	private Button cancel;
	
	@FXML
	private TextField user_name;
	@FXML
	private TextField user_id;
	@FXML
	private ChoiceBox<String> type_of_user;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private TextArea description;
	
	
	public void registerUser(ActionEvent event) throws IOException{
		Main m = new Main();
		UsersRecords u = null;
		if(type_of_user.getValue().equals("Client") || type_of_user.getValue().equals("Manager")) {
			u = new UsersRecords(user_name.getText().toString(), user_id.getText().toString(), type_of_user.getValue(), username.getText().toString(),password.getText().toString(),"");
		}else {
			u = new UsersRecords(user_name.getText().toString(), user_id.getText().toString(), type_of_user.getValue(), username.getText().toString(),password.getText().toString(),description.getText().toString());
		}
		
		DaoModel dao = new DaoModel();
		dao.insertNewUser(u);
		
		m.changeScene("/views/manager_window.fxml");
	}
	
	public void cancelButton(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/manager_window.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		type_of_user.getItems().add("Client");
		type_of_user.getItems().add("Admin");
		type_of_user.getItems().add("Manager");
	}
	
	

}
