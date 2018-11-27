package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import application.User.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
			int numItems = quantities.size();
			Text yourOrder = new Text("Thank you for your order, " + currentUser.getUsername());
			gp.add(yourOrder, 0, 0);
			gp.setPadding(new Insets(10, 10, 10, 10));
			int row = 1;
			double total=0.0;
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
					gp.add(number, 0, row);
					gp.add(item, 1, row);
					gp.add(pricetxt, 2, row++);
				}
			}
			BigDecimal totaldec=new BigDecimal(String.valueOf(total));
			BigDecimal roundedTotalDec =  totaldec.setScale(2, RoundingMode.DOWN);
			Text totalCost = new Text("Total: $" + roundedTotalDec);
			Text time =  new Text("Your order will be ready in approximately " + totalItems*5 + " minutes");
			gp.add(totalCost, 0, row++);
			gp.add(time, 0, row);
			Scene scene = new Scene(gp, 500, 500);
			finalScene = scene;
			
			// Adding stylesheet
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			gp.getStyleClass().add("background-white");

}
}
