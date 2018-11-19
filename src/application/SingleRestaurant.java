package application;

import java.util.ArrayList;

import application.Review.Review;
import application.User.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SingleRestaurant {
	private static Scene finalScene;
	private ArrayList<Review> reviewList;
	private ArrayList<Item> itemList;

	public static Scene getScene() {
		return finalScene;
	}

	public SingleRestaurant(Stage primaryStage, Restaurant tempRestaurant, User currentUser) {

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
		// readReviews.setUserData();
		// leaveReview.setUserData();
		// menu.setUserData();
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
				if (new_toggle == readReviews) {
					GridPane tempGridPane = new GridPane();
					Text title = new Text("Customer Reviews");
					int row=1;
					int col=0;
					int reviewListSize = tempRestaurant.getReviewList().size();
					for (int i=0; i<reviewListSize; i++) {
						Review currentReview = tempRestaurant.getReviewList().get(i);
						VBox vBox = new VBox();
						vBox.setPadding(new Insets(10, 10, 10, 10));
						Text info = new Text("User: " + currentReview.getUsername() + " Stars (out of 5): " + currentReview.getStars());
						Text review = new Text(currentReview.getReview());
						vBox.getChildren().addAll(info, review);
						tempGridPane.add(vBox, col, row++);
					}
					tempGridPane.add(title, 0, 0);
					gridPane.add(tempGridPane, 0, 2);
				} else if (new_toggle == leaveReview) {
					VBox tempVBox = new VBox();
					Text text = new Text("Leave a Review");
					TextField txtReview = new TextField();
					Label lblStars = new Label("Stars (out of 5)");
					
					// Drop down of star options
					HBox stars = new HBox();
					ObservableList<Integer> options = FXCollections.observableArrayList(1, 2, 3, 4, 5);
					final ComboBox comboBox = new ComboBox(options);
					stars.getChildren().setAll(lblStars, comboBox);
					Label lblMessage = new Label();
					
					// Submit review button
					Button submit = new Button("Submit");

					// Adding nodes to VBox and GridPane
					tempVBox.getChildren().addAll(text, txtReview, stars, submit);
					gridPane.add(tempVBox, 0, 2);
					
					// When button is pressed, creates new Review object and adds it to reviewList
					submit.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							int stars = (int) comboBox.getValue();
							String review = txtReview.getText().toString();
							String username = currentUser.getUsername();
							Review newReview = new Review(stars, review, username);
							tempRestaurant.addReview(newReview);
							txtReview.setText("");
							lblMessage.setText("Review submitted!");
							gridPane.add(lblMessage, 0, 3);
							
						}
					});
					
				}
				else if(new_toggle == menu) {
					GridPane menuGridPane = new GridPane();
					Label menuLbl = new Label("Items");
					Label quantLbl = new Label("Quantity");
					int numItems = tempRestaurant.getNumItems();
					int col = 0;
					int row = 1;
					ColumnConstraints ColCons = new ColumnConstraints();
					ColCons.setMaxWidth(300.0);
					menuGridPane.getColumnConstraints().add(0, ColCons);
					for (int i=0; i<numItems; i++) {
						Item currentItem = tempRestaurant.getItemList().get(i);
						String itemName = currentItem.getName();
						double itemPrice = currentItem.getPrice();
						String itemDescription = currentItem.getDescription();
						Text nameTxt = new Text(itemName + " " + itemPrice);
						Text descriptionTxt = new Text(itemDescription);
						descriptionTxt.setWrappingWidth(250.0);
						VBox vBox = new VBox();
						vBox.setPadding(new Insets(10, 10, 10, 10));
						vBox.getChildren().addAll(nameTxt, descriptionTxt);
						menuGridPane.add(vBox, col, row++);					
					}
					menuGridPane.add(menuLbl, 0, 0);
					menuGridPane.add(quantLbl, 1, 0);
					gridPane.add(menuGridPane, 0, 2);
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
