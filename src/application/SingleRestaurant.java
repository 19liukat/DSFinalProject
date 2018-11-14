package application;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class SingleRestaurant {
	private static Scene scene;

	public static Scene getScene() {
		return scene;
	}

	public SingleRestaurant(Stage primaryStage, Restaurant tempRestaurant){
		ScrollPane sp = new ScrollPane();
		scene = new Scene(sp, 500, 500);
	}
}
