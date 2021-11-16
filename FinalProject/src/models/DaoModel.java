package models;
/**
 * @author Andrea Perez Isla
 *
 * ITMD510 Object-Oriented App Develop
 * Lab4
 * Dao Model class
 * 
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import records.HairSalonRecords;

public class DaoModel {

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public DaoModel() { // create db object instance
		conn = new DBConnect();
	}

	// CREATE TABLE METHOD
	public void createTable() {
		try {
			// Open a connection
			System.out.println("Connecting to database to create Table...");
			System.out.println("Connected database successfully...");
			// Execute create query
			System.out.println("Creating table in given database...");
			stmt = conn.connect().createStatement();
			
			
			 String sql5 ="DELETE FROM users_hairsalon_tab"; stmt.executeUpdate(sql5);
			 
			
			//SQL statement to create the table. If it already exists, a warning appears.
			
			//Faltan relaciones entre tablas
			
			String sql;
			String sql2;
			String sql3;
			try {
				sql = "CREATE TABLE users_hairsalon_tab " + "(id_user INTEGER not NULL AUTO_INCREMENT, " + " username VARCHAR(20) not NULL, "
						+ " password VARCHAR(20) not NULL, " + " user_name VARCHAR(30) not NULL, " + " user_type VARCHAR(10) not NULL, " + " PRIMARY KEY ( id_user ))";
				
				sql2 = "CREATE TABLE services_hairsalon_tab " + "(id_service INTEGER not NULL AUTO_INCREMENT, " + " cut_type VARCHAR(10) not NULL, "
						+ " wash_hair VARCHAR(3) not NULL, " + " worker_in_charged VARCHAR(20) not NULL, " + " used_products VARCHAR(60) not NULL, " + " PRIMARY KEY ( id_service ))";
				
				sql3 = "CREATE TABLE personal_info_hairsalon_tab " + "(id_personal INTEGER not NULL AUTO_INCREMENT, " + " name VARCHAR(20) not NULL, "
						+ " phone_number numeric(10) not NULL, " + " address VARCHAR(40) not NULL, " + " service VARCHAR(40) not NULL, " + " PRIMARY KEY ( id_personal ))";
				
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
				stmt.executeUpdate(sql3);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			
			System.out.println("Created table in given database...");
			conn.connect().close(); // close db connection
		} catch (SQLException se) { // Handle errors for JDBC
			se.printStackTrace();
		}
	}

	// INSERT INTO METHOD
	public void insertRecords(HairSalonRecords[] hairjs) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.connect().createStatement();
			String sql = null;
			String sql2 = null;
			String sql3 = null;
			
			// Include all object data to the database table
			for (int i = 0; i < hairjs.length; ++i) {
				
				// SQL statement to add the id, income and pep values of each record
				//into the A_Pere_tab table
				
				sql = "INSERT INTO users_hairsalon_tab(username,password,user_name,user_type) " + 
						"VALUES (' "+hairjs[i].getUsername()+" ', ' "+hairjs[i].getPassword()+" ', '"+hairjs[i].getUser_name()+"', '"+hairjs[i].getUser_type()+"')";
				//sql2 = "INSERT INTO services_hairsalon_tab(id,income,pep) " + 
				//		"VALUES (' "+hairjs[i].getId()+" ', ' "+hairjs[i].getIncome()+" ', '"+hairjs[i].getPep()+"')";
				//sql3 = "INSERT INTO personal_info_hairsalon_tab(id,income,pep) " + 
				//		"VALUES (' "+hairjs[i].getId()+" ', ' "+hairjs[i].getIncome()+" ', '"+hairjs[i].getPep()+"')";
				
				stmt.executeUpdate(sql);
				//stmt.executeUpdate(sql2);
				//stmt.executeUpdate(sql3);
				
			}
			conn.connect().close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}// INSERT INTO METHOD

	
	
	public ResultSet retrieveRecords() {
		ResultSet rs = null;
		String sql = null;
		//SQL statement to show the results, ordered by pep
		//in a desc way
//		if (tipo_tabla == "users") {
//			sql = "SELECT * from users_hairsalon_tab ORDER BY id_user ASC";
//		}else if(tipo_tabla == "services") {
//			sql = "SELECT * from services_hairsalon_tab ORDER BY id_service ASC";
//		}else {
//			sql = "SELECT * from personal_info_hairsalon_tab ORDER BY id_personal ASC";
//		}
		
		sql = "SELECT * from users_hairsalon_tab ORDER BY id_user ASC";
		
		System.out.println("Records inserted!");
		try {
			stmt = conn.connect().createStatement();
			rs = stmt.executeQuery(sql);
			conn.connect().close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return rs;
	}
	
	
	
	
	
	
	
	

}
