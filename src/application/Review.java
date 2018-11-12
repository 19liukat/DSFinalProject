package application;

public class Review {
	private int stars;
	private String review;
	private String username;
	
	public Review() {
		stars=0;
		review="";
		username="";		
	}
	public Review(int stars, String review, String username) {
		this.stars=stars;
		this.review=review;
		this.username=username;
	}

}
