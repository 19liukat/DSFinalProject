package application.Review;

import java.util.ArrayList;

public class ReviewArrayList {
	private static ArrayList<Review> reviewList;
	public ReviewArrayList() {
		reviewList = new ArrayList<Review>();
	}
	public ArrayList<Review> getList(){
		return reviewList;
	}
	public int getSize() {
		return reviewList.size();
	}
	public void addUser(Review toAdd) {
		reviewList.add(toAdd);
	}

}
