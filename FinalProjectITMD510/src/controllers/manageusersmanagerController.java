package controllers;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.DaoModel;

public class manageusersmanagerController implements Initializable{
	
	
	
	@FXML
	private TableView<UsersRecords> users_table;
	@FXML
	private TableColumn<UsersRecords,String> colName;
	@FXML
	private TableColumn<UsersRecords,String> colID;
	@FXML
	private TableColumn<UsersRecords,String> colType_of_User;
	@FXML
	private TableColumn<UsersRecords,String> colUsername;
	
	@FXML
	private Button back;
	
	@FXML
	private Button delete;


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		colName.setCellValueFactory(new PropertyValueFactory<UsersRecords,String>("user_name"));
		colID.setCellValueFactory(new PropertyValueFactory<UsersRecords,String>("user_id"));
		colType_of_User.setCellValueFactory(new PropertyValueFactory<UsersRecords,String>("type_of_user"));
		colUsername.setCellValueFactory(new PropertyValueFactory<UsersRecords,String>("username"));
				
		DaoModel dao = new DaoModel();
		List<UsersRecords> list = dao.getAllUsers();
		ObservableList<UsersRecords> data = FXCollections.observableArrayList(list) ;
		users_table.setItems(data);
			
		
	}
	
	public void backB(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("/views/manager_window.fxml");
	}
	
	public void deleteBoton(ActionEvent event) throws IOException{
		Main m = new Main();
		
		UsersRecords deleted = users_table.getSelectionModel().getSelectedItem();
		
		DaoModel dao = new DaoModel();
		dao.deleteUserRecord(deleted);
		
		m.changeScene("/views/manage_usersmanager.fxml");
	}
	

}
