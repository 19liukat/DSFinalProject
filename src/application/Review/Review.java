package application.Review;

public class Review {
	private double stars;
	private String review;
	private String username;
	
	public Review() {
		stars=0;
		review="";
		username="";		
	}
	
	public Review(double stars, String review, String username) {
		this.stars=stars;
		this.review=review;
		this.username=username;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
