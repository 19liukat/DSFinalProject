package application;

import java.io.File;
import java.io.IOException;

import application.Restaurants.Parser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) throws IOException{
		
		
		Scene scene = new Login(primaryStage).getScene();
		
		primaryStage.setTitle("RestaurantAdvisor");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
