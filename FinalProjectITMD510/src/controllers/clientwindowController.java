package controllers;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class clientwindowController {
	
	@FXML
	private Button make_Reservation;
	
	
	@FXML
	private Button log_out;
	
	public void logout(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/login.fxml");
	}
	
	public void makeReservation(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/reservation_page.fxml");
	}

	
}
