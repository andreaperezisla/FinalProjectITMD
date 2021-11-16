package records;

import java.io.*;
import java.util.*;


/**
 * @author Andrea Perez Isla
 *
 * ITMD510 Object-Oriented App Develop
 * Lab2
 * HairSalonRecords class
 * 
 */

public class HairSalonRecords extends Client {

	// Array to save HairSalonRecords objects
	protected static HairSalonRecords hairjs[] = new HairSalonRecords[4];

	// ArrayList to manage file's rows and columns
	static ArrayList<List<String>> list_file = new ArrayList<>();

	// Attributes
	private String username;
	private String password;
	private String user_name;
	private String user_type;
	

	//Getters and Setters
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}

	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	//END OF GETTERS AND SETTERS
	
	
	@Override
	public void readData() {
		// TODO Auto-generated method stub
		// Creating a reader object and introducing file to be read

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("hairsalon-Detail.csv")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String line = "";
		
		//For each record in the file, parse it and save it into the ArrayList already created 
		try {
			while ((line = br.readLine()) != null) {
				list_file.add(Arrays.asList(line.split(",")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//After successfully reading the file, it is necessary to process the data from the file
		processData();

	}

	@Override
	public void processData() {
		// TODO Auto-generated method stub

		//putting into the HairSalonRecords list the data from the arraylist
		//Through a loop, creating an index and actualizing it when finished
		int i = 0;

		for (List<String> rowData : list_file) {
			// Creating array of objects
			hairjs[i] = new HairSalonRecords();
			
			// setting each field to its corresponded object
			hairjs[i].setUsername(rowData.get(0)); 
			hairjs[i].setPassword(rowData.get(1));
			hairjs[i].setUser_name(rowData.get(2));
			hairjs[i].setUser_type(rowData.get(3));
			
			i++;
		}

	}

} //END OF CLASS
