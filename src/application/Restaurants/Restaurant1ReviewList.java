package application.Restaurants;

import java.util.ArrayList;

import application.Review.Review;

public class Restaurant1ReviewList {

	ArrayList<Review> reviewList;
	
	public Restaurant1ReviewList(){
		//int stars, String review, String username
		reviewList = new ArrayList<Review>();
		Review review1 = new Review(5, "Fantastic food! Excellent service and beautiful ambiance!", "FoodCritic123");
		Review review2 = new Review(3, "I ordered a chicken and rice bowl, but the chicken was dry and the rice tasted funny", "AnnaField");
		reviewList.add(review1);
		reviewList.add(review2);
	}
	public double getAvg(){
		double avg = 0;
		for(int i = 0; i < reviewList.size(); i++){
			avg += reviewList.get(i).getStars();
		}
		avg /= reviewList.size();
		return avg;
	}
	public ArrayList<Review> getList(){
		return reviewList;
	}
}
