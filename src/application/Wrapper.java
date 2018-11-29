package application;

import java.util.ArrayList;

import application.Restaurants.Restaurant;
import application.Review.Review;

public class Wrapper {
	private ArrayList<Restaurant> restaurantList;
	private ArrayList<Review> reviewList;
	public Wrapper() {
		restaurantList = new ArrayList<Restaurant>();
		reviewList = new ArrayList<Review>();
	}
	public void addRestaurant(Restaurant toAdd) {
		restaurantList.add(toAdd);
	}
	public void addReview(Review toAdd) {
		reviewList.add(toAdd);
	}
	public ArrayList<Restaurant> getRestaurant(){
		return restaurantList;
	}
	public ArrayList<Review> getReview(){
		return reviewList;
	}
	

}
