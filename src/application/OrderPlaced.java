package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import application.Restaurants.Restaurant;
import application.User.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrderPlaced {
	private static Scene finalScene;

	public static Scene getScene() {
		return finalScene;
	}

	public OrderPlaced(Stage primaryStage, ArrayList<Integer> quantities, Restaurant tempRestaurant, User currentUser, int totalItems) {
			GridPane gp = new GridPane();
			gp.setPadding(new Insets(10, 10, 10, 10));
			gp.setVgap(10);

			int numItems = quantities.size();
			Text yourOrder = new Text("Thank you for your order, " + currentUser.getUsername());
			gp.add(yourOrder, 0, 0);
			gp.setPadding(new Insets(10, 10, 10, 10));
			int row = 0;
			double total=0.0;
			GridPane tempPane = new GridPane();
			//setting widths of columns
		    ColumnConstraints column0 = new ColumnConstraints(30);
		    tempPane.getColumnConstraints().add(column0);
		    ColumnConstraints column1 = new ColumnConstraints(150);
		    tempPane.getColumnConstraints().add(column1);
		 
			for (int i=0; i<numItems; i++) {
				int quantity = quantities.get(i);
				if(quantity!=0) {
					
					Text number = new Text(String.valueOf(quantity));
					Text item = new Text(tempRestaurant.getItemList().get(i).getName());
					double price = quantity*tempRestaurant.getItemList().get(i).getPrice();
					BigDecimal itemPrice = new BigDecimal(String.valueOf(price));
					BigDecimal roundedItemPrice = itemPrice.setScale(2, RoundingMode.DOWN);
					Text pricetxt = new Text(String.valueOf(roundedItemPrice));
					total+=Double.valueOf(String.valueOf(roundedItemPrice));
					tempPane.add(number, 0, row);
					tempPane.add(item, 1, row);
					tempPane.add(pricetxt, 2, row++);
				}
				
			}
			gp.add(tempPane, 0, 1);
			BigDecimal totaldec=new BigDecimal(String.valueOf(total));
			BigDecimal roundedTotalDec =  totaldec.setScale(2, RoundingMode.DOWN);
			Text totalCost = new Text("Total: $" + roundedTotalDec);
			int totalTime = 15;
			totalTime+=totalItems*5;
			if(totalTime>90) {
				totalTime=90;
			}
			Text time =  new Text("Your order will be ready in approximately " + totalTime + " minutes");
			gp.add(totalCost, 0, 2);
			gp.add(time, 0, 3);
			Button back = new Button("Home");
			back.getStyleClass().add("button-blue");
			gp.add(back, 0, 4);
			back.setOnMouseClicked(
					event -> primaryStage.setScene(new SingleRestaurant(primaryStage, tempRestaurant, currentUser).getScene()));
			Scene scene = new Scene(gp, 500, 500);
			finalScene = scene;
			
			// Adding stylesheet
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			gp.getStyleClass().add("background-white");

}
}
