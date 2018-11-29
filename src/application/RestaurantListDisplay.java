package application;

import java.util.ArrayList;

import application.Restaurants.Restaurant;
import application.User.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantListDisplay {

	private static Scene finalScene;

	public static Scene getScene() {
		return finalScene;
	}

	public RestaurantListDisplay(Stage primaryStage, User currentUser) {

		// Adding GridPane
		GridPane gridPane = new GridPane();
		RestaurantArrayList restaurantList = new RestaurantArrayList();
		Restaurant test = new Restaurant();
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		// Adding restaurants to list to display
		restaurantList.addRestaurant(test);
		restaurantList.addRestaurant(test);
		ArrayList<Restaurant> rList = restaurantList.getList();

		int index = 0;
		int row = 0;
		int col = 0;
		int arraySize = rList.size();
		for (int i = 0; i < arraySize; i++) {

			// Generate list of Restaurant objects and display it
			final Restaurant tempRestaurant = rList.get(index);
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

			// Adding each Restaurant + description to separate VBox
			VBox vBox = new VBox();
			vBox.setPadding(new Insets(10, 10, 10, 10));
			vBox.getChildren().addAll(name, textDescription);
			gridPane.add(vBox, col, row++);
			index++;

			// Clicking a restaurant changes scene to individual restaurant page
			vBox.setOnMouseClicked(event -> primaryStage
					.setScene((new SingleRestaurant(primaryStage, tempRestaurant, currentUser)).getScene()));

		}
		// Logout button
		VBox logoutVBox = new VBox();
		logoutVBox.setPadding(new Insets(10, 10, 10, 10));
		Button logOut = new Button("Log Out");
		logOut.getStyleClass().add("button-red");
		logoutVBox.getChildren().add(logOut);
		logOut.setOnMouseClicked(event -> primaryStage.setScene(Login.getScene()));
		gridPane.add(logoutVBox, col, row++);
		
		// Final scene scrollpane
		ScrollPane sp = new ScrollPane();
		sp.setContent(gridPane);

		Scene scene = new Scene(sp, 500, 500);

		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		sp.getStyleClass().add("background-white");
		
		finalScene = scene;
	}

}
