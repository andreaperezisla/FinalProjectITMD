package controllers;

public class ReservationRecords {

	private String date;
	private String time;
	private String type_of_hair;
	private String wash;
	private String price;
	

	public ReservationRecords(String date, String time, String type_of_hair, String wash, String price) {
		super();
		this.date = date;
		this.time = time;
		this.type_of_hair = type_of_hair;
		this.wash = wash;
		this.price = price;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the type_of_hair
	 */
	public String getType_of_hair() {
		return type_of_hair;
	}
	/**
	 * @param type_of_hair the type_of_hair to set
	 */
	public void setType_of_hair(String type_of_hair) {
		this.type_of_hair = type_of_hair;
	}
	/**
	 * @return the wash
	 */
	public String getWash() {
		return wash;
	}
	/**
	 * @param wash the wash to set
	 */
	public void setWash(String wash) {
		this.wash = wash;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
