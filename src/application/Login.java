package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {

	private String user = "r";
	private String pw = "p";
	private String checkUser, checkPw;
	private static Scene scene;

	public static Scene getScene() {
		return scene;
	}

	public Login(Stage primaryStage) {
		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("Username:");
		TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password:");
		PasswordField pf = new PasswordField();
		Button btnLogin = new Button("Login");
		Label lblMessage = new Label();
		Text text = new Text("RestaurantAdvisor");

		// Adding Nodes to GridPane layout
		gridPane.add(text, 1, 0);
		gridPane.add(lblUserName, 0, 1);
		gridPane.add(txtUserName, 1, 1);
		gridPane.add(lblPassword, 0, 2);
		gridPane.add(pf, 1, 2);
		gridPane.add(btnLogin, 1, 3);
		gridPane.add(lblMessage, 1, 4);

		// Action for btnLogin and styling
		btnLogin.getStyleClass().add("button-blue");
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				checkUser = txtUserName.getText().toString();
				checkPw = pf.getText().toString();
				if (checkUser.equals(user) && checkPw.equals(pw)) {
					primaryStage.setScene(new RestaurantList(primaryStage).getScene());
				}
				else{
					lblMessage.setText("Incorrect username or password");
					lblMessage.setTextFill(Color.RED);
				}
				txtUserName.setText("");
				pf.setText("");
			}
		});
		
		scene = new Scene(gridPane, 500, 500);
		gridPane.setAlignment(Pos.CENTER);
		
		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);

	}
}
