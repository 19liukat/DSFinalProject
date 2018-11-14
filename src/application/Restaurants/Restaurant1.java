package application.Restaurants;

import application.Item;
import application.Restaurant;
import application.RestaurantArrayList;
import application.Review;
import application.Lists.ArrayIndexedList;

public class Restaurant1 {
	private String restaurantName;
	private String restaurantType;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String price;
	private int numItems;
	private double reviewAvg;
	private ArrayIndexedList<Item> itemList;

	//String restaurantName, String restaurantType, String streetAddress, String city, String state, int zipCode, double price, int numItems
	public Restaurant1() {
		restaurantName="FreshFin Poke";
		restaurantType="Fast Casual";
		streetAddress="240 North Lord Street";
		city="Brookfield";
		state="WI";
		zipCode=53045;
		price="$$";
		itemList = (new Restaurant1ItemList()).getList();
		reviewAvg = (new Restaurant1ReviewList()).getAvg();
		numItems = itemList.size();
		Restaurant temp = new Restaurant();
		RestaurantArrayList tempList = new RestaurantArrayList();
		tempList.addRestaurant(temp);
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

	public ArrayIndexedList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayIndexedList<Item> itemList) {
		this.itemList = itemList;
	}

	public double getReviewAvg() {
		return reviewAvg;
	}

}
