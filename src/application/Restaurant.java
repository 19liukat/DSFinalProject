package application;

import application.Lists.ArrayIndexedList;

public class Restaurant {
	private String restaurantName;
	private String restaurantType;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String price;
	private int numItems;
	private double rating;
	private ArrayIndexedList<Item> itemList;
	private ArrayIndexedList<Review> reviewList;
	
	public Restaurant() {
		restaurantName="chicken";
		restaurantType="bad";
		streetAddress="";
		city="";
		state="";
		zipCode=0;
		price="";
		numItems=0;
		itemList= null;
		reviewList= null;
	}
	
	public Restaurant(String restaurantName, String restaurantType, String streetAddress, String city, String state, int zipCode, double price, int numItems) {
		this.restaurantName="";
		this.restaurantType="";
		this.streetAddress="";
		this.city="";
		this.state="";
		this.zipCode=0;
		this.price="";
		this.numItems=0;
		itemList = new ArrayIndexedList<Item>();
		reviewList = new ArrayIndexedList<Review>();
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public String toString() {
		return restaurantName;
	}
	

}
