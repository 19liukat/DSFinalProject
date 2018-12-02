package application;

import java.util.ArrayList;

import application.Restaurants.Parser;
import application.Restaurants.Restaurant;

public class RestaurantArrayList {
	private ArrayList<Restaurant> restaurantList;

	public RestaurantArrayList() {
		restaurantList = new ArrayList<Restaurant>();
		Parser p = new Parser();
		restaurantList.add(p.rParse("Restaurant1"));
		restaurantList.add(p.rParse("Restaurant2"));
		restaurantList.add(p.rParse("Restaurant3"));
		restaurantList.add(p.rParse("Restaurant4"));
		restaurantList.add(p.rParse("Restaurant5"));
		restaurantList.add(p.rParse("Restaurant6"));
		restaurantList.add(p.rParse("Restaurant7"));
	}

	public void addRestaurant(Restaurant toAdd) {
		restaurantList.add(toAdd);
	}

	public ArrayList<Restaurant> getList() {
		return restaurantList;
	}

	public int getSize() {
		return restaurantList.size();
	}
}
