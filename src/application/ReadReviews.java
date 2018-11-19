package application;

import application.Review.Review;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReadReviews {
	private static Scene scene;

	public static Scene getScene() {
		return scene;
	}
	public ReadReviews(Restaurant tempRestaurant, Stage primaryStage) {
		ScrollPane sp = new ScrollPane();
		GridPane gridPane = new GridPane();
		Text title = new Text("Customer Reviews");
		int row=0;
		int col=0;
		int reviewListSize = tempRestaurant.getReviewList().size();
		for (int i=0; i<reviewListSize; i++) {
			Review currentReview = tempRestaurant.getReviewList().get(i);
			VBox vBox = new VBox();
			vBox.setPadding(new Insets(10, 10, 10, 10));
			Text info = new Text("User: " + currentReview.getUsername() + " Stars (out of 5): " + currentReview.getStars());
			Text review = new Text(currentReview.getReview());
			vBox.getChildren().addAll(info, review);
			gridPane.add(vBox, col, row++);
		}
		
		sp.setContent(gridPane);
		scene = new Scene(sp, 500, 500);
	}
}
