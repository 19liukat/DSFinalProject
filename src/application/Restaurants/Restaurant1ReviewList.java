package application.Restaurants;

import java.util.ArrayList;

import application.Review.Review;

public class Restaurant1ReviewList {

	ArrayList<Review> reviewList;
	
	public Restaurant1ReviewList(){
		//int stars, String review, String username
		reviewList = new ArrayList<Review>();
	}
	public double getAvg(){
		double avg = 0;
		if(reviewList.size()==0){
			return 0.0;
		}
		for(int i = 0; i < reviewList.size(); i++){
			avg += reviewList.get(i).getStars();
		}
		avg /= reviewList.size();
		return avg;
	}
	public ArrayList<Review> getList(){
		return reviewList;
	}
	public void addReview(Review review){
		
	}
}
