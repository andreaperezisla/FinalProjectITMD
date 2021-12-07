package controllers;

public class UsersRecords {
	
	private String user_name;
	private String user_id;
	private String type_of_user;
	private String username;
	private String password;
	private String description;
	
	public UsersRecords(String user_name, String user_id, String type_of_user, String username, String password, String description) {
		super();
		this.user_name = user_name;
		this.user_id = user_id;
		this.type_of_user = type_of_user;
		this.username = username;
		this.password=password;
		this.description=description;
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
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the type_of_user
	 */
	public String getType_of_user() {
		return type_of_user;
	}

	/**
	 * @param type_of_user the type_of_user to set
	 */
	public void setType_of_user(String type_of_user) {
		this.type_of_user = type_of_user;
	}

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	};
	
	
	
	
	
	
}
