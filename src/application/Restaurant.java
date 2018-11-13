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

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public ArrayIndexedList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayIndexedList<Item> itemList) {
		this.itemList = itemList;
	}

	public ArrayIndexedList<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayIndexedList<Review> reviewList) {
		this.reviewList = reviewList;
	}
	

}
