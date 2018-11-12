package application;

import application.Lists.ArrayIndexedList;

public class Restaurant {
	private String restaurantName;
	private String restaurantType;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private double price;
	private int numItems;
	private ArrayIndexedList<Item> itemList;
	private ArrayIndexedList<Review> reviewList;
	
	public Restaurant() {
		restaurantName="";
		restaurantType="";
		streetAddress="";
		city="";
		state="";
		zipCode=0;
		price=0;
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
		this.price=0;
		this.numItems=0;
		itemList = new ArrayIndexedList<Item>();
		reviewList = new ArrayIndexedList<Review>();
	}
	

}
