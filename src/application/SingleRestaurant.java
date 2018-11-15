package application;

import java.util.ArrayList;

import application.Review.Review;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SingleRestaurant {
	private static Scene finalScene;
	private ArrayList<Review> reviewList;
	private ArrayList<Item> itemList;

	public static Scene getScene() {
		return finalScene;
	}

	public SingleRestaurant(Stage primaryStage, Restaurant tempRestaurant) {

		GridPane gridPane = new GridPane();

		// Adding title of restaurant
		Text restaurantName = new Text(tempRestaurant.getRestaurantName());
		restaurantName.getStyleClass().add("restaurant-title");
		gridPane.add(restaurantName, 0, 0);

		// Adding Toggle Bar
		ToggleGroup toggleGroup = new ToggleGroup();

		ToggleButton readReviews = new ToggleButton("Reviews");
		readReviews.setToggleGroup(toggleGroup);
		readReviews.setSelected(true);
		ToggleButton leaveReview = new ToggleButton("Leave a Review");
		leaveReview.setToggleGroup(toggleGroup);
		ToggleButton menu = new ToggleButton("Menu");
		menu.setToggleGroup(toggleGroup);

		// Placing toggle bar into separate HBox
		HBox toggleBar = new HBox();
		toggleBar.setPadding(new Insets(10, 10, 10, 0));
		toggleBar.getChildren().addAll(readReviews, leaveReview, menu);
		gridPane.add(toggleBar, 0, 1);

		// Prevents toggle buttons from being unselected
		toggleGroup.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
		    if (newVal == null)
		        oldVal.setSelected(true);
		});
		
		// Adding functionality to each toggle button
		//readReviews.setUserData();
		//leaveReview.setUserData();
		//menu.setUserData();
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
				if (new_toggle == readReviews) {
					Text temp = new Text("auadgkdklajlkejkwafk");
					gridPane.add(temp, 0, 2);
				}

			}
		});

		// Adjusting GridPane padding
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		// Adding GridPane to ScrollPane and setting scene
		ScrollPane sp = new ScrollPane();
		sp.setContent(gridPane);
		Scene scene = new Scene(sp, 500, 500);

		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);

		finalScene = scene;
	}
}
