package application;

import java.util.ArrayList;

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
		public OrderPlaced(Stage primaryStage, ArrayList<Integer> quantities, Restaurant tempRestaurant) {
			GridPane gp = new GridPane();
			int numItems = quantities.size();
			Text yourOrder = new Text("Your Order: ");
			gp.add(yourOrder, 0, 0);
			gp.setPadding(new Insets(10, 10, 10, 10));
			int row = 1;
			for (int i=0; i<numItems; i++) {
				System.out.println(quantities.get(i));
				int quantity = quantities.get(i);
				if(quantity!=0) {
					Text number = new Text(String.valueOf(quantity));
					Text item = new Text(tempRestaurant.getItemList().get(i).getName());

					gp.add(item, 0, row);
					gp.add(number, 1, row++);
				}
			}
			Scene scene = new Scene(gp, 500, 500);
			finalScene = scene;
			
			// Adding stylesheet
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			gp.getStyleClass().add("background-white");

}
}
