package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.DaoModel;
import javafx.event.ActionEvent;
import java.io.IOException;

import application.Main;

public class LoginController {

	public LoginController() {

	}

	
	@FXML
	private Button button;

	@FXML
	private Button signup;

	@FXML
	private Label wrongLogIn;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	
	public void userLogin(ActionEvent event) throws IOException {
		Main m = new Main();
		DaoModel dao = new DaoModel();
		UsersRecords u = null;

		if (username.getText().isEmpty() && password.getText().isEmpty()) {
			wrongLogIn.setText("Please enter your username and password");
		}

		u = dao.getUserData(username.getText().toString(), password.getText().toString());


		if (u.getType_of_user().equals("Client")) {
			m.changeScene("/views/client_window.fxml");
		}
		if (u.getType_of_user().equals("Admin")) {
			m.changeScene("/views/admin_window.fxml");
		}
		if (u.getType_of_user().equals("Manager")) {
			m.changeScene("/views/manager_window.fxml");
		}
		if (u.getUsername().equals("Error") && u.getPassword().equals("Error")) {
			wrongLogIn.setText("Wrong password or username");
		}

	}

	public void signUp(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("/views/signup.fxml");
	}

}
