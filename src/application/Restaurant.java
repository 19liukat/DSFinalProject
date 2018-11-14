package application;

import application.Lists.ArrayIndexedList;
import application.Restaurants.Restaurant1ItemList;
import application.Restaurants.Restaurant1ReviewList;

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
		restaurantName="FreshFin Poke";
		restaurantType="Fast Casual";
		streetAddress="240 North Lord Street";
		city="Brookfield";
		state="WI";
		zipCode=53045;
		price="$$";
		itemList = (new Restaurant1ItemList()).getList();
		reviewList = (new Restaurant1ReviewList()).getList();
		numItems = itemList.size();
	}
	
	public Restaurant(String restaurantName, String restaurantType, String streetAddress, String city, String state, int zipCode, String price, int numItems) {
		restaurantName="FreshFin Poke";
		restaurantType="Fast Casual";
		streetAddress="240 North Lord Street";
		city="Brookfield";
		state="WI";
		zipCode=53045;
		price="$$";
		itemList = (new Restaurant1ItemList()).getList();
		reviewList = (new Restaurant1ReviewList()).getList();
		numItems = itemList.size();
	}
	

}
