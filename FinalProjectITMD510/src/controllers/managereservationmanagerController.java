package controllers;

import java.io.IOException;
//import java.awt.Button;
//import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.DaoModel;

public class managereservationmanagerController implements Initializable{
	
	
	
	@FXML
	private TableView<ReservationRecords> reservations_table;
	@FXML
	private TableColumn<ReservationRecords,String> colDate;
	@FXML
	private TableColumn<ReservationRecords,String> colTime;
	@FXML
	private TableColumn<ReservationRecords,String> colType;
	@FXML
	private TableColumn<ReservationRecords,String> colWash;
	@FXML
	private TableColumn<ReservationRecords,String> colPrice;
	@FXML	
	private Button back;
	@FXML	
	private Button delete;
	@FXML	
	private Button update;
	@FXML	
	private Button save;
	@FXML
	private DatePicker update_date;
	@FXML
	private TextField update_time;

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		colDate.setCellValueFactory(new PropertyValueFactory<ReservationRecords,String>("date"));
		colTime.setCellValueFactory(new PropertyValueFactory<ReservationRecords,String>("time"));
		colType.setCellValueFactory(new PropertyValueFactory<ReservationRecords,String>("type_of_hair"));
		colWash.setCellValueFactory(new PropertyValueFactory<ReservationRecords,String>("wash"));
		colPrice.setCellValueFactory(new PropertyValueFactory<ReservationRecords,String>("price"));
		
		DaoModel dao = new DaoModel();
		List<ReservationRecords> list = dao.getAllReservations();
		ObservableList<ReservationRecords> data = FXCollections.observableArrayList(list) ;
		
		reservations_table.setItems(data);
			
		
	}
	
	
	public void backB(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/manager_window.fxml");
	}
	
	
	public void DeleteReservation(ActionEvent event) throws IOException{
		Main m = new Main();
		
		ReservationRecords deleted = reservations_table.getSelectionModel().getSelectedItem();
		
		DaoModel dao = new DaoModel();
		dao.deleteReservationRecord(deleted);
		

		m.changeScene("/views/manage_reservationmanager.fxml");
	}
	
	public void UpdateReservation(ActionEvent event) throws IOException{
		
		update_date.setVisible(true);
		update_time.setVisible(true);
		save.setVisible(true);


	}
	
	public void SaveReservation(ActionEvent event) throws IOException{
		Main m = new Main();
		
		ReservationRecords toupdate = reservations_table.getSelectionModel().getSelectedItem();
		
		String old_date = toupdate.getDate();
		String old_time = toupdate.getTime();
		String new_date = update_date.getValue().toString();
		String new_time = update_time.getText().toString();
		
		DaoModel dao = new DaoModel();
		dao.updateReservationRecord(old_date,old_time,new_date,new_time);

		m.changeScene("/views/manage_reservationmanager.fxml");
	}

}
