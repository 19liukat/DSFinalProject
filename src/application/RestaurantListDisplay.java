package application;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangerListener;

import application.Restaurants.Restaurant;
import application.User.User;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantListDisplay {

	private static Scene finalScene;
	private ArrayList<Restaurant> rList;
	private ArrayList<Restaurant> original;

	public static Scene getScene() {
		return finalScene;
	}

	public RestaurantListDisplay(Stage primaryStage, User currentUser) {

		// Adding GridPane
		GridPane gridPane = new GridPane();
		RestaurantArrayList restaurantrList = new RestaurantArrayList();
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		// Adding restaurants to rList to display
		rList = restaurantrList.getList();
		original = rList;

		int row = 2;
		int col = 0;
		int arraySize = rList.size();
		Text title = new Text("Restaurants Near You");
		gridPane.add(title, 0, 0);
		gridPane.setHalignment(title, HPos.CENTER);
		TextField txt = new TextField();
        txt.setPromptText("Search");
        txt.textProperty().addListener(
            new ChangeListener() {
                public void changed(ObservableValue observable, 
                                    Object oldVal, Object newVal) {
                    handleSearchByKey2((String)oldVal, (String)newVal);
                }
            });
        
		for (int i = 0; i < arraySize; i++) {

			// Generate rList of Restaurant objects and display it
			final Restaurant tempRestaurant = rList.get(i);
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

			// Clicking a restaurant changes scene to individual restaurant page
			vBox.setOnMouseClicked(event -> primaryStage
					.setScene((new SingleRestaurant(primaryStage, tempRestaurant, currentUser)).getScene()));

		}
		public void handleSearchByKey(String oldVal, String newVal) {
	        // If the number of characters in the text box is less than last time
	        // it must be because the user pressed delete
	        if ( oldVal != null && (newVal.length() < oldVal.length()) ) {
	            // Restore the rLists original set of entries 
	            // and start from the beginning
	            rList.setItems( entries );
	        }
	         
	        // Change to upper case so that case is not an issue
	        newVal = newVal.toUpperCase();
	 
	        // Filter out the entries that don't contain the entered text
	        ObservableList<String> subentries = FXCollections.observableArrayList();
	        for ( Object entry: rList ) {
	            String entryText = (String)entry;
	            if ( entryText.toUpperCase().contains(newVal) ) {
	                subentries.add(entryText);
	            }
	        }
	        rList.setItems(subentries);
	    }
	 
	    public void handleSearchByKey2(String oldVal, String newVal) {
	        // If the number of characters in the text box is less than last time
	        // it must be because the user pressed delete
	        if ( oldVal != null && (newVal.length() < oldVal.length()) ) {
	            // Restore the rLists original set of entries 
	            // and start from the beginning
	            rList.setItems( entries );
	        }
	         
	        // Break out all of the parts of the search text 
	        // by splitting on white space
	        String[] parts = newVal.toUpperCase().split(" ");
	 
	        // Filter out the entries that don't contain the entered text
	        ObservableList<String> subentries = FXCollections.observableArrayList();
	        for ( Object entry: rList) {
	            boolean match = true;
	            String entryText = (String)entry;
	            for ( String part: parts ) {
	                // The entry needs to contain all portions of the
	                // search string *but* in any order
	                if ( ! entryText.toUpperCase().contains(part) ) {
	                    match = false;
	                    break;
	                }
	            }
	 
	            if ( match ) {
	                subentries.add(entryText);
	            }
	        }
	        rList.setItems(subentries);
	    }
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
