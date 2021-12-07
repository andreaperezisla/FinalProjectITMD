package models;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/**
 * @author Andrea Perez Isla
 *
 * ITMD510 Object-Oriented App Develop
 * Lab4
 * Dao Model class
 * 
 */
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controllers.ReservationRecords;
import controllers.UsersRecords;


public class DaoModel {

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public DaoModel() { // create db object instance
		conn = new DBConnect();
	}

	// CREATE TABLES FOR USERS AND RESERVATIONS METHOD
	public void createTable() {
		try {
			// Open a connection
			System.out.println("Connecting to database to create Table...");
			System.out.println("Connected database successfully...");
			// Execute create query
			System.out.println("Creating table in given database...");
			stmt = conn.connect().createStatement();
			
			
			String sql1;
			String sql2;

			try {
				sql1 = "CREATE TABLE IF NOT EXISTS users_hairsalon_table " + "(id_number VARCHAR(20) not NULL, " + " user_name VARCHAR(20) not NULL, "
						+ " password VARCHAR(20) not NULL, " + " username VARCHAR(30) not NULL, " + " type_of_user VARCHAR(10) not NULL, " + " PRIMARY KEY ( id_number ))";
				
				sql2 = "CREATE TABLE IF NOT EXISTS reservations_hairsalon_tab " + "(date VARCHAR(15) not NULL, " + " time VARCHAR(60) not NULL, "
						+ " type_of_hair VARCHAR(20) not NULL, " + " wash VARCHAR(4) not NULL, " + " price VARCHAR(60) not NULL, " + " PRIMARY KEY ( time ))";
				
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Created table in given database...");
			conn.connect().close(); // close db connection
		} catch (SQLException se) { // Handle errors for JDBC
			se.printStackTrace();
		}
		
	}
	
	
	// CREATE TABLE HAIRDRESSERS METHOD
		public void createTableHairdressers() {
			try {
				// Open a connection
				System.out.println("Connecting to database to create Table2...");
				System.out.println("Connected database successfully...");
				// Execute create query
				System.out.println("Creating table in given database...");
				stmt = conn.connect().createStatement();
				
				String sql;
				try {
					sql = "CREATE TABLE IF NOT EXISTS hairdressers_hairsalon_table " + "(worker_number VARCHAR(60) not NULL, " + " name VARCHAR(20) not NULL, "
							+ " id_number VARCHAR(20) not NULL, " + " description VARCHAR(70) not NULL, " + " PRIMARY KEY ( worker_number ))";
					
					stmt.executeUpdate(sql);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Created table in given database...");
				conn.connect().close(); // close db connection
			} catch (SQLException se) { // Handle errors for JDBC
				se.printStackTrace();
			}
			
		}
	

	// INSERT INTO USERS TABLE METHOD
	public void insertNewUser(UsersRecords u) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.connect().createStatement();
			String sql = null;
			
			sql = "INSERT INTO users_hairsalon_table(id_number,user_name,password,username,type_of_user) " + 
					"VALUES ('"+u.getUser_id()+"','"+u.getUser_name()+"', '"+u.getPassword()+"', '"+u.getUsername()+"', '"+u.getType_of_user()+"')";
			
				
			stmt.executeUpdate(sql);
			
			conn.connect().close();
			
			if(u.getType_of_user().equals("Admin")) insertNewHairdresser(u);
				
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}// INSERT INTO USERS TABLE METHOD
	
	
	
	// INSERT INTO HAIRDRESSERS TABLE METHOD
			public void insertNewHairdresser(UsersRecords u) {
				try {
					// Execute a query
					System.out.println("Inserting records into the table...");
					stmt = conn.connect().createStatement();
					String sql = null;
					Random ran = new Random();
					int rr = ran.nextInt(300);
					String id_generado=String.valueOf(rr);
					System.out.println(id_generado);
					
					sql = "INSERT INTO hairdressers_hairsalon_table(worker_number,name,id_number,description) " + 
							"VALUES ('"+id_generado+"','"+u.getUser_name()+"', '"+u.getUser_id()+"', '"+u.getDescription()+"')";
						
					stmt.executeUpdate(sql);
					
					conn.connect().close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}// INSERT INTO HAIRDRESSERS TABLE METHOD	
	
	
	
	
	

	// INSERT INTO RESERVATIONS TABLE METHOD
		public void insertNewReservation(ReservationRecords r) {
			try {
				// Execute a query
				System.out.println("Inserting records into the table...");
				stmt = conn.connect().createStatement();
				String sql = null;
				
				sql = "INSERT INTO reservations_hairsalon_tab(date,time,type_of_hair,wash,price) " + 
						"VALUES ('"+r.getDate()+"','"+r.getTime()+"', '"+r.getType_of_hair()+"', '"+r.getWash()+"', '"+r.getPrice()+"')";
					
				stmt.executeUpdate(sql);				
				conn.connect().close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}// INSERT INTO RESERVATIONS TABLE METHOD	
		
		
		
		//GET USER DATA METHOD
		public UsersRecords getUserData(String username,String password) {
			UsersRecords u =null;
			try {
				// Execute a query
				System.out.println("Looking for the record into the table...");
				stmt = conn.connect().createStatement();
				String sql = null;
				ResultSet rs = null;
				
				//System.out.println(username);
				//System.out.println(password);
				
				sql = "SELECT * FROM users_hairsalon_table WHERE username='"+username+"' AND password='"+password+"'";
					
				stmt.executeQuery(sql);
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					u = new UsersRecords(rs.getString("id_number"),rs.getString("user_name"),rs.getString("type_of_user"),rs.getString("username"),rs.getString("password"),"");
				}else {
					u = new UsersRecords("","","","Error","Error","");
					
				}
				
				conn.connect().close();
				
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			return u;
			
			
		}//GET USER DATA METHOD
		
		
		
		//GET ALL USERS METHOD
		public List<UsersRecords> getAllUsers() {
			List<UsersRecords> list = new ArrayList<>();
			UsersRecords u =null;
			try {
				// Execute a query
				System.out.println("Looking for the hairdressesrs TABLE records into the table...");
				stmt = conn.connect().createStatement();
				String sql = null;
				ResultSet rs = null;
				
				sql = "SELECT * FROM users_hairsalon_table";
					
				stmt.executeQuery(sql);
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();

	            int colCount = rsmd.getColumnCount();
	            //int rowCount = 0;
	            while (rs.next()) {
	                //rowCount++;
	                for (int i = 1; i <= colCount; i++)
	                	u = new UsersRecords(rs.getString("id_number"),rs.getString("user_name"),rs.getString("type_of_user"),rs.getString("username"),rs.getString("password"),"");
	                	list.add(u);
	            }
				
				conn.connect().close();
				
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			return list;
			
			
		}//GET ALL USERS METHOD
		
		
		
		//GET ALL RESERVATIONS METHOD
		public List<ReservationRecords> getAllReservations() {
			List<ReservationRecords> list = new ArrayList<>();
			ReservationRecords r =null;
			try {
				// Execute a query
				System.out.println("Looking for the reservations TABLE records into the table...");
				stmt = conn.connect().createStatement();
				String sql = null;
				ResultSet rs = null;
				
				sql = "SELECT * FROM reservations_hairsalon_tab";
					
				stmt.executeQuery(sql);
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();

	            int colCount = rsmd.getColumnCount();
	            //int rowCount = 0;
	            while (rs.next()) {
	                //rowCount++;
	                //System.out.println("Datos para la fila " + rowCount);
	                for (int i = 1; i <= colCount; i++)
	                    //System.out.println("   Fila " + i + ": " + rs.getString(i));
	                	r = new ReservationRecords(rs.getString("date"),rs.getString("time"),rs.getString("type_of_hair"),rs.getString("wash"),rs.getString("price"));
	                	list.add(r);
	            }
				
				conn.connect().close();
				
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			return list;
			
			
		}//GET ALL RESERVATIONS METHOD
		
		
		
		//DELETE A RESERVATION RECORD METHOD
		public void deleteReservationRecord(ReservationRecords deleted) {
			try {
				// Execute a query
				System.out.println("Looking for the reservations TABLE TO ERASE A record...");
				stmt = conn.connect().createStatement();
				String sql = null;
				
				sql = "DELETE FROM reservations_hairsalon_tab WHERE time='"+deleted.getTime()+"' AND date='"+deleted.getDate()+"'";
					
				stmt.executeUpdate(sql);
				conn.connect().close();				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			
		}//DELETE A RESERVATION RECORD METHOD
		
		
		//DELETE A USER RECORD METHOD
		public void deleteUserRecord(UsersRecords deleteduser) {
			try {
				// Execute a query
				System.out.println("Looking for the users TABLE TO ERASE A record...");
				stmt = conn.connect().createStatement();
				String sql = null;
				
				sql = "DELETE FROM users_hairsalon_table WHERE username='"+deleteduser.getUsername()+"' AND password='"+deleteduser.getPassword()+"'";
					
				stmt.executeUpdate(sql);
				conn.connect().close();	
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			
		}//DELETE A USER RECORD METHOD
	
		
		//UPDATE A RESERVATION RECORD METHOD
		public void updateReservationRecord(String old_date,String old_time,String new_date,String new_time) {
			try {
				// Execute a query
				System.out.println("Looking for the users TABLE TO ERASE A record...");
				stmt = conn.connect().createStatement();
				String sql = null;
				
				sql = "UPDATE reservations_hairsalon_tab SET time='"+new_time+"' , date='"+new_date+"' WHERE time='"+old_time+"' AND date='"+old_date+"'";
					
				stmt.executeUpdate(sql);
				conn.connect().close();		
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			
		}//UPDATE A RESERVATION RECORD METHOD
	

}
