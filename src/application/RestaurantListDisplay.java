package application;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantListDisplay {

	private static Scene finalScene;

	public static Scene getScene() {
		return finalScene;
	}

	public RestaurantListDisplay(Stage primaryStage) {

		/*
		 * ObservableList<Restaurant> observableRestaurant =
		 * FXCollections.observableArrayList(temp);
		 * 
		 * 
		 * TableView<Restaurant> table = new
		 * TableView<Restaurant>(observableRestaurant); TableColumn<Restaurant,
		 * String> nameCol = new TableColumn<Restaurant,
		 * String>("Restaurant Name"); nameCol.setCellValueFactory(new
		 * PropertyValueFactory("restaurantName")); TableColumn<Restaurant,
		 * String> typeCol = new TableColumn<Restaurant, String>("Type");
		 * typeCol.setCellValueFactory(new
		 * PropertyValueFactory("restaurantType")); TableColumn<Restaurant,
		 * String> ratingCol = new TableColumn<Restaurant, String>("Rating");
		 * ratingCol.setCellValueFactory(new PropertyValueFactory("rating"));
		 * TableColumn<Restaurant, String> priceCol = new
		 * TableColumn<Restaurant, String>("Price");
		 * priceCol.setCellValueFactory(new PropertyValueFactory("price"));
		 * TableColumn<Restaurant, String> addressCol = new
		 * TableColumn<Restaurant, String>("Address");
		 * addressCol.setCellValueFactory(new
		 * PropertyValueFactory("streetAddress"));
		 * 
		 * table.getColumns().setAll(nameCol, typeCol, ratingCol, priceCol,
		 * addressCol);
		 */
		// Adding GridPane
		GridPane gridPane = new GridPane();
		RestaurantArrayList restaurantList = new RestaurantArrayList();
		Restaurant test = new Restaurant();
		restaurantList.addRestaurant(test);
		ArrayList<Restaurant> rList = restaurantList.getList();
		
		Restaurant tempRestaurant = null;
		int index = 0;
		int row = 0;
		int col = 0;
		int arraySize = rList.size();
		if(!rList.isEmpty()){
			do{
				tempRestaurant = rList.get(index);
				Text name = new Text(tempRestaurant.getRestaurantName());
				Text type = new Text(tempRestaurant.getRestaurantType());
				Text rating = new Text(String.valueOf(tempRestaurant.getRating()));
				Text price = new Text(tempRestaurant.getPrice());
				Text address = new Text(tempRestaurant.getStreetAddress() + ", " + tempRestaurant.getCity() + ", "
						+ tempRestaurant.getState());
				gridPane.add(name, col, row++);
				gridPane.add(type, col++, row);
				gridPane.add(rating, col++, row);
				gridPane.add(price, col++, row);
				gridPane.add(address, col++, row);
				index++;
			}while(index < arraySize);
		}

		
		ScrollPane sp = new ScrollPane();
		sp.setContent(gridPane);
		//gridPane.add(table, 0, 1);

		// calling elements of the list one by one

		Scene scene = new Scene(sp, 500, 500);

		finalScene = scene;
	}
}
