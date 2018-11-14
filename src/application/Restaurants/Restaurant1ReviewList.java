package application.Restaurants;

import application.Item;
import application.Review;
import application.Lists.ArrayIndexedList;

public class Restaurant1ReviewList {

	ArrayIndexedList<Review> reviewList;
	
	public Restaurant1ReviewList(){
		//int stars, String review, String username
		reviewList = new ArrayIndexedList<Review>();
		Review review1 = new Review(5, "Fantastic food! Excellent service and beautiful ambiance!", "FoodCritic123");
		Review review2 = new Review(3, "I ordered a chicken and rice bowl, but the chicken was dry and the rice tasted funny", "AnnaField");
		reviewList.add(review1);
		reviewList.add(review2);
	}
	public ArrayIndexedList<Review> getList(){
		return reviewList;
	}
}
