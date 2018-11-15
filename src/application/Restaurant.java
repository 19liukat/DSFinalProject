package application;

import java.util.ArrayList;

import application.Lists.ArrayIndexedList;
import application.Restaurants.Restaurant1ItemList;
import application.Restaurants.Restaurant1ReviewList;
import application.Review.Review;

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
	private ArrayList<Item> itemList;
	private ArrayList<Review> reviewList;

	public Restaurant() {
		restaurantName = "FreshFin Poke";
		restaurantType = "Fast Casual";
		streetAddress = "240 North Lord Street";
		city = "Brookfield";
		state = "WI";
		zipCode = 53045;
		price = "$$";
		itemList = new ArrayList<Item>();
		reviewList = new ArrayList<Review>();
		rating = 0;
		numItems = itemList.size();
	}

	public Restaurant(String restaurantName, String restaurantType, String streetAddress, String city, String state,
			int zipCode, String price, int numItems) {
		restaurantName = "FreshFin Poke";
		restaurantType = "Fast Casual";
		streetAddress = "240 North Lord Street";
		city = "Brookfield";
		state = "WI";
		zipCode = 53045;
		price = "$$";
		itemList = (new Restaurant1ItemList()).getList();
		rating = (new Restaurant1ReviewList()).getAvg();
		numItems = itemList.size();
	}
	public void addReview(Review toAdd) {
		reviewList.add(toAdd);
	}
	public void addItem(Item toAdd) {
		itemList.add(toAdd);
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	public ArrayList<Review> getReviewList(){
		return reviewList;
	}


}
