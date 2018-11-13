package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantListDisplay {

	private static Scene finalScene;

	public static Scene getScene() {
		return finalScene;
	}

	public RestaurantListDisplay(Stage primaryStage) {

		// Adding GridPane
		GridPane gridPane = new GridPane();
		RestaurantArrayList restaurantList = new RestaurantArrayList();
		Restaurant test = new Restaurant();
		restaurantList.addRestaurant(test);
		ArrayList<Restaurant> temp = restaurantList.getList();
		ObservableList<Restaurant> observableRestaurant = FXCollections.observableArrayList(temp);
		//ListView<Restaurant> listView = new ListView<Restaurant>(observableRestaurant);
		TableView<Restaurant> table = new TableView<Restaurant>(observableRestaurant);
		TableColumn<Restaurant,String> nameCol = new TableColumn<Restaurant,String>("Restaurant Name");
		 nameCol.setCellValueFactory(new PropertyValueFactory("restaurantName"));
		 TableColumn<Restaurant,String> typeCol = new TableColumn<Restaurant,String>("Type");
		 typeCol.setCellValueFactory(new PropertyValueFactory("restaurantType"));
		 TableColumn<Restaurant,String> ratingCol = new TableColumn<Restaurant,String>("Rating");
		 ratingCol.setCellValueFactory(new PropertyValueFactory("rating"));
		 TableColumn<Restaurant,String> priceCol = new TableColumn<Restaurant,String>("Price");
		 priceCol.setCellValueFactory(new PropertyValueFactory("price"));
		 TableColumn<Restaurant,String> addressCol = new TableColumn<Restaurant,String>("Address");
		 addressCol.setCellValueFactory(new PropertyValueFactory("streetAddress"));
		 
		 table.getColumns().setAll(nameCol, typeCol, ratingCol, priceCol, addressCol);
		
		
		
		//testing
		ScrollPane sp = new ScrollPane();
		sp.setContent(gridPane);
		Text hello = new Text("Hello");
		gridPane.add(hello, 0, 0);
		gridPane.add(table, 0, 1);
		
		//calling elements of the list one by one
		
		
		Scene scene = new Scene(sp, 500, 500);

		finalScene = scene;
	}
}
