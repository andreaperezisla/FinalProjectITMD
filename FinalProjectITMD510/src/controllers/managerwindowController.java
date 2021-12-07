package controllers;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class managerwindowController {
	
	@FXML
	private Button manage_Reservations;
	
	@FXML
	private Button manage_Users;
	
	@FXML
	private Button create_Users;
	
	@FXML
	private Button log_out;
	
	public void logout(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/login.fxml");
	}
	
	public void manageReservations(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/manage_reservationmanager.fxml");
	}
	
	public void manageUsers(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/manage_usersmanager.fxml");
	}
	
	public void createUsers(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/signup_newadmin.fxml");
	}
	

}
