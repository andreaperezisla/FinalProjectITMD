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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.DaoModel;


public class reservationpageController implements Initializable{
	
	
	
	@FXML
	private ChoiceBox<String> type_of_hair;
	
	@FXML
	private ChoiceBox<String> wash;
	
	@FXML
	private ChoiceBox<String> hairdressers;
	
	@FXML
	private DatePicker date_reservation;
	@FXML
	private TextField time;
	
	
	@FXML
	private Button cancel;
	
	@FXML
	private Button make_reservation;
	

	
	public void cancelButton(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/client_window.fxml");
	}
	
	
	public void makeReservation(ActionEvent event) throws IOException{
		Main m = new Main();

		int price=0;
		
		if(type_of_hair.getValue().equals("Short")) price = 10;
		if(type_of_hair.getValue().equals("Medium")) price = 20;
		if(type_of_hair.getValue().equals("Long")) price = 30;
		if(wash.getValue().equals("Yes")) price += 10;
		
		ReservationRecords r = new ReservationRecords(date_reservation.getValue().toString(),time.getText().toString(),type_of_hair.getValue(),wash.getValue(),String.valueOf(price));
		
		DaoModel dao = new DaoModel();
		dao.insertNewReservation(r);
		
		m.changeScene("/views/client_window.fxml");
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String[] hairdressers_array = new String[3];
		hairdressers_array[0]="Marta";
		hairdressers_array[1]="Andres";
		hairdressers_array[2]="Federico";
		
		type_of_hair.getItems().add("Short");
		type_of_hair.getItems().add("Medium");
		type_of_hair.getItems().add("Long");
		wash.getItems().add("Yes");
		wash.getItems().add("No");
		for (int i=0;i<hairdressers_array.length;i++) {
			hairdressers.getItems().add(hairdressers_array[i]);
		}
		
	}
	
	
	
	
	
	
}
