package application;

import application.Review.Review;
import application.Review.ReviewArrayList;
import application.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LeaveAReview {
	private static Scene scene;

	public static Scene getScene() {
		return scene;
	}

	public LeaveAReview(Stage primaryStage, Restaurant tempRestaurant, User currentUser){
		ScrollPane sp = new ScrollPane();
		scene = new Scene(sp, 500, 500);
		GridPane gridPane = new GridPane();
		// restaurant text
		Text name = new Text(tempRestaurant.getRestaurantName());
		name.getStyleClass().add("restaurant-title");
		String type = tempRestaurant.getRestaurantType();
		String rating = String.valueOf(tempRestaurant.getRating());
		String price = tempRestaurant.getPrice();
		String address = tempRestaurant.getStreetAddress() + ", " + tempRestaurant.getCity() + ", "
				+ tempRestaurant.getState();
		String stringDescription = type + " | " + rating + " | " + price + " | " + address;
		Text textDescription = new Text(stringDescription);
		textDescription.getStyleClass().add("restaurant-description");
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.getChildren().addAll(name, textDescription);
		gridPane.add(vBox, 0, 0);
		// Leave a Review
		Text text = new Text("Leave a Review");
		TextField txtReview = new TextField();
		Label lblstars = new Label();
		// drop down of star options
		ObservableList<Integer> options = FXCollections.observableArrayList(1, 2, 3, 4, 5);
		final ComboBox comboBox = new ComboBox(options);
		Label lblMessage = new Label();
		// submit review button
		Button submit = new Button();
		// when button is pressed, creates new Review object and adds it to
		// reviewList
		submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				double stars = (double)comboBox.getValue();
				String review = txtReview.getText().toString();
				String username = currentUser.getUsername();
				Review newReview = new Review(stars, review, username);
				tempRestaurant.addReview(newReview);
				txtReview.setText("");
				lblMessage.setText("Review submitted!");
			}
		});

		gridPane.add(text, 0, 1);
		gridPane.add(txtReview, 0, 2);
		gridPane.add(lblstars, 0, 3);
		gridPane.add(comboBox, 1, 3);
		gridPane.add(submit, 0, 4);
		gridPane.add(lblMessage, 0, 5);
		gridPane.setAlignment(Pos.CENTER);
		sp.setContent(gridPane);
		scene = new Scene(sp, 500, 500);
		// padding
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		gridPane.getStyleClass().add("background-white");
	}

}
