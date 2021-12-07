package application;
	
//import java.sql.ResultSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.DaoModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//to change between views
	private static Stage stg;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {

			DaoModel dao = new DaoModel();
			dao.createTable();
			dao.createTableHairdressers();

			
			stg =primaryStage;
			primaryStage.setResizable(false);
			
			
			Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
			primaryStage.setTitle("Hair Salon App");
			primaryStage.setScene(new Scene (root, 686, 400));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml){
		try {
			Parent pane  = FXMLLoader.load(getClass().getResource(fxml));
			stg.getScene().setRoot(pane);		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
