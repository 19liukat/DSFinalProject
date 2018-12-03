package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import application.Restaurants.Restaurant;
import application.Review.Review;
import application.User.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

		// Back button
		Button back = new Button("Back");
		back.getStyleClass().add("button-red");
		gridPane.add(back, 0, 0);
		GridPane.setHalignment(back, HPos.RIGHT);
		back.setOnMouseClicked(event -> primaryStage.setScene(RestaurantListDisplay.getScene()));

		// Adding Toggle Bar
		ToggleGroup toggleGroup = new ToggleGroup();

		ToggleButton info = new ToggleButton("About this Restaurant");
		info.setToggleGroup(toggleGroup);
		ToggleButton readReviews = new ToggleButton("Reviews");
		readReviews.setToggleGroup(toggleGroup);
		ToggleButton leaveReview = new ToggleButton("Leave a Review");
		leaveReview.setToggleGroup(toggleGroup);
		ToggleButton menu = new ToggleButton("Menu");
		menu.setToggleGroup(toggleGroup);
		toggleGroup.selectToggle(info);

		// Placing toggle bar into separate HBox
		HBox toggleBar = new HBox();
		toggleBar.setPadding(new Insets(10, 10, 0, 0));
		toggleBar.getChildren().addAll(info, readReviews, leaveReview, menu);
		gridPane.add(toggleBar, 0, 1);

		// Prevents toggle buttons from being unselected
		toggleGroup.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
			if (newVal == null)
				oldVal.setSelected(true);
		});

		// Adding functionality to each toggle button
		VBox tempVBox = new VBox(5);
		tempVBox.setPrefWidth(460);
		GridPane menuGridPane = new GridPane();
		menuGridPane.setPrefWidth(460);
		GridPane infoGP = new GridPane();
		tempVBox.getStyleClass().add("blue-border");
		menuGridPane.getStyleClass().add("blue-border");
		infoGP.getStyleClass().add("blue-border");
		infoGP.setPrefWidth(460);

		// Automatically set to Info tab
		infoGP.setPadding(new Insets(10, 10, 10, 10));
		info.setSelected(true);

		// Adding restaurant picture
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String filePath = tempRestaurant.getFileName() + "Image.jpg";
		InputStream input = classLoader.getResourceAsStream(filePath);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(input);
			Image logoImage = SwingFXUtils.toFXImage(bufferedImage, null);
			ImageView image = new ImageView(logoImage);
			image.setFitWidth(440);
			image.setPreserveRatio(true);
			infoGP.add(image, 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Text aboutRestaurant = new Text("About This Restaurant");
		aboutRestaurant.getStyleClass().add("restaurant-title");
		Text name = new Text(tempRestaurant.getRestaurantName());
		Text phone = new Text(tempRestaurant.getPhone());
		Text address = new Text(tempRestaurant.getStreetAddress());
		Text restAddress = new Text(tempRestaurant.getCity() + " " + tempRestaurant.getState() + " "
				+ String.valueOf(tempRestaurant.getZipCode()));
		Text restaurantType = new Text(tempRestaurant.getRestaurantType());
		infoGP.add(aboutRestaurant, 0, 1);
		infoGP.add(name, 0, 2);
		infoGP.add(phone, 0, 3);
		infoGP.add(address, 0, 4);
		infoGP.add(restAddress, 0, 5);
		gridPane.add(infoGP, 0, 2);

		// Creating ToggleGroup to switch between tabs
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
				if (new_toggle == info) {
					tempVBox.getChildren().clear();
					gridPane.getChildren().remove(tempVBox);
					gridPane.getChildren().remove(menuGridPane);
					gridPane.getChildren().remove(infoGP);

					// Formatting info GridPane
					infoGP.setPadding(new Insets(10, 10, 10, 10));

					// Adding restaurant picture
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					String filePath = tempRestaurant.getFileName() + "Image.jpg";
					InputStream input = classLoader.getResourceAsStream(filePath);
					BufferedImage bufferedImage;
					try {
						bufferedImage = ImageIO.read(input);
						Image logoImage = SwingFXUtils.toFXImage(bufferedImage, null);
						ImageView image = new ImageView(logoImage);
						image.setPreserveRatio(true);
						infoGP.add(image, 0, 0);
						image.setFitWidth(440);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Text aboutRestaurant = new Text("About This Restaurant");
					aboutRestaurant.getStyleClass().add("restaurant-title");
					Text restaurantName = new Text(tempRestaurant.getRestaurantName());
					Text phone = new Text(tempRestaurant.getPhone());
					Text address = new Text(tempRestaurant.getStreetAddress());
					Text restAddress = new Text(tempRestaurant.getCity() + " " + tempRestaurant.getState() + " "
							+ String.valueOf(tempRestaurant.getZipCode()));
					Text restaurantType = new Text(tempRestaurant.getRestaurantType());

					tempVBox.getChildren().addAll(aboutRestaurant, restaurantName, phone, address, restAddress);

					infoGP.add(aboutRestaurant, 0, 1);
					infoGP.add(restaurantName, 0, 2);
					infoGP.add(phone, 0, 3);
					infoGP.add(address, 0, 4);
					infoGP.add(restAddress, 0, 5);
					gridPane.add(infoGP, 0, 2);
				}
				if (new_toggle == readReviews) {
					tempVBox.getChildren().clear();
					gridPane.getChildren().remove(tempVBox);
					gridPane.getChildren().remove(menuGridPane);
					gridPane.getChildren().remove(infoGP);

					Text title = new Text("Customer Reviews");
					title.getStyleClass().add("secondary-header");
					tempVBox.getChildren().add(title);
					int reviewListSize = tempRestaurant.getReviewList().size();
					if (reviewListSize == 0) {
						Text noReviews = new Text("There are no reviews at this time. Be the first to leave one!");
						tempVBox.getChildren().add(noReviews);
					}
					for (int i = 0; i < reviewListSize; i++) {
						Review currentReview = tempRestaurant.getReviewList().get(i);
						tempVBox.setPadding(new Insets(10, 10, 10, 10));
						Text info = new Text(
								"User: " + currentReview.getUsername() + " | Stars: " + currentReview.getStars());
						Text review = new Text(currentReview.getReview());
						review.setWrappingWidth(400);
						Text divider = new Text("---");
						tempVBox.getChildren().addAll(info, review, divider);
					}
					gridPane.add(tempVBox, 0, 2);
				} else if (new_toggle == leaveReview) {
					gridPane.getChildren().remove(tempVBox);
					gridPane.getChildren().remove(menuGridPane);
					tempVBox.getChildren().clear();
					gridPane.getChildren().remove(infoGP);

					tempVBox.setSpacing(10);
					Text text = new Text("Leave a Review");
					text.getStyleClass().add("secondary-header");
					TextArea txtReview = new TextArea();
					txtReview.setWrapText(true);
					Label lblStars = new Label("Stars: ");

					// Drop down of star options
					HBox stars = new HBox();
					ObservableList<String> options = FXCollections.observableArrayList("Not Selected", "1", "2", "3",
							"4", "5");
					final ComboBox comboBox = new ComboBox(options);
					comboBox.getSelectionModel().selectFirst();
					stars.getChildren().setAll(lblStars, comboBox);
					Label lblMessage = new Label();

					// Submit review button
					Button submit = new Button("Submit");
					submit.getStyleClass().add("button-blue");

					// Adding nodes to VBox and GridPane
					tempVBox.getChildren().addAll(text, txtReview, stars, submit);
					gridPane.add(tempVBox, 0, 2);

					// When button is pressed, creates new Review object and
					// adds it to reviewList
					submit.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							String review = txtReview.getText().toString();
							String username = currentUser.getUsername();
							if (review.equals("") || comboBox.getValue().equals("Not Selected")) {
								lblMessage.setText("Please enter valid review");
								lblMessage.setTextFill(Color.RED);
							} else {
								int stars = Integer.valueOf((String) comboBox.getValue());
								Review newReview = new Review(stars, review, username);
								tempRestaurant.addReview(newReview);
								txtReview.setText("");
								lblMessage.setText("Review submitted!");
								try {
									Files.write(
											Paths.get("src/application/Restaurants/" + tempRestaurant.getFileName()),
											("\n" + username + ";" + stars + ";" + review).getBytes(),
											StandardOpenOption.APPEND);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							tempVBox.getChildren().add(lblMessage);
						}
					});

				} else if (new_toggle == menu) {
					gridPane.getChildren().remove(tempVBox);
					gridPane.getChildren().remove(menuGridPane);
					tempVBox.getChildren().clear();
					gridPane.getChildren().remove(infoGP);

					Label menuLbl = new Label("Items");
					Label quantLbl = new Label("Quantity");
					menuLbl.getStyleClass().add("secondary-header");
					quantLbl.getStyleClass().add("secondary-header");
					int numItems = tempRestaurant.getNumItems();
					int col = 0;
					int row = 1;

					// Adding textfields for placing an order
					ArrayList<Integer> quantities = new ArrayList<Integer>();
					ArrayList<TextField> textFieldList = new ArrayList<TextField>();
					for (int i = 0; i < numItems; i++) {
						Item currentItem = tempRestaurant.getItemList().get(i);
						String itemName = currentItem.getName();
						double itemPrice = currentItem.getPrice();
						String itemDescription = currentItem.getDescription();
						Text nameTxt = new Text(itemName + " $" + itemPrice);
						Text descriptionTxt = new Text(itemDescription);
						descriptionTxt.setWrappingWidth(250.0);
						TextField itemQuantity = new TextField();
						itemQuantity.setText("0");
						textFieldList.add(itemQuantity);

						// Code from Internet
						itemQuantity.textProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue<? extends String> observable, String oldValue,
									String newValue) {
								if (!newValue.matches("\\d*")) {
									itemQuantity.setText(newValue.replaceAll("[^\\d]", ""));
								}
							}
						});

						VBox vBox = new VBox();
						vBox.setPadding(new Insets(10, 10, 10, 0));
						vBox.getChildren().addAll(nameTxt, descriptionTxt);
						menuGridPane.add(vBox, col, row);

						menuGridPane.add(itemQuantity, col + 1, row++);
					}

					Button submitBtn = new Button("Place your order");
					submitBtn.getStyleClass().add("button-blue");
					submitBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							int totalItems = 0;
							for (int i = 0; i < textFieldList.size(); i++) {
								String currTextField = textFieldList.get(i).getText().toString();
								totalItems += Integer.valueOf(currTextField);
								quantities.add(Integer.valueOf(currTextField));
							}
							primaryStage.setScene(
									new OrderPlaced(primaryStage, quantities, tempRestaurant, currentUser, totalItems)
											.getScene());
						}
					});
					menuGridPane.add(menuLbl, 0, 0);
					menuGridPane.add(quantLbl, 1, 0);
					menuGridPane.add(submitBtn, 0, row);
					gridPane.add(menuGridPane, 0, 2);
				}

			}
		});

		// Adjusting GridPane padding
		gridPane.setPadding(new Insets(10, 0, 10, 10));

		// Adding GridPane to ScrollPane and setting scene
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
