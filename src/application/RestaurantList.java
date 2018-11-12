package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantList {

	private static Scene finalScene;

	public static Scene getScene() {
		return finalScene;
	}

	public RestaurantList(Stage primaryStage) {
		// Adding BorderPane
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 10, 10, 10));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(0, 10, 10, 10));

		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		Text temp = new Text("Hello");
		gridPane.add(temp, 0, 0);
		
		bp.setTop(hb);
		bp.setCenter(gridPane);
		Scene scene = new Scene(bp, 500, 500);

		finalScene = scene;
	}
}
