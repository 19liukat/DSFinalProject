package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	String user = "restaurant";
	String pw = "password";
	String checkUser, checkPw;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("RestaurantAdvisor");

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("Username");
		TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password");
		PasswordField pf = new PasswordField();
		Button btnLogin = new Button("Login");
		Label lblMessage = new Label();

		// Adding Nodes to GridPane layout
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pf, 1, 1);
		gridPane.add(btnLogin, 1, 2);
		gridPane.add(lblMessage, 1, 3);

		// Adding text to HBox
		Text text = new Text("RestaurantAdvisor");
		hb.getChildren().add(text);

		// Add ID's to Nodes
		bp.setId("bp");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		text.setId("text");

		// Action for btnLogin and styling
		btnLogin.getStyleClass().add("button-blue");
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				checkUser = txtUserName.getText().toString();
				checkPw = pf.getText().toString();
				if (checkUser.equals(user) && checkPw.equals(pw)) {
					lblMessage.setText("Congratulations!");
					lblMessage.setTextFill(Color.GREEN);
				} else {
					lblMessage.setText("Incorrect user or pw.");
					lblMessage.setTextFill(Color.RED);
				}
				txtUserName.setText("");
				pf.setText("");
			}
		});

		// Add HBox and GridPane layout to BorderPane Layout
		bp.setTop(hb);
		bp.setCenter(gridPane);
		Scene scene = new Scene(bp, 500, 600);

		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);

		primaryStage.setTitle("RestaurantAdvisor");
		primaryStage.setScene(scene);
		primaryStage.show();

		/*
		 * // Create menu bar to toggle between login for restaurant and
		 * customer MenuBar menuBar = new MenuBar(); GridPane root = new
		 * GridPane();
		 * 
		 * // Import stylesheet into the GUI String css =
		 * this.getClass().getResource("application.css").toExternalForm();
		 * Scene scene = new Scene(root, 600, 500);
		 * scene.getStylesheets().add(css);
		 * 
		 * // Create individual menu options Text login = new Text("Login");
		 * Label username = new Label("Username: "); Label password = new
		 * Label("Password: "); TextField tf = new TextField(); PasswordField pf
		 * = new PasswordField(); pf.setPromptText("Enter Password"); Button
		 * submit = new Button("Submit");
		 * submit.getStyleClass().add("button-blue");
		 * 
		 * root.setHgap(10); root.setVgap(10); root.setConstraints(login, 11,
		 * 8); root.setConstraints(username, 10, 10); root.setConstraints(tf,
		 * 11, 10); root.setConstraints(password, 10, 12);
		 * root.setConstraints(pf, 11, 12);
		 * 
		 * 
		 * Button loginButton = new Button("Login");
		 * loginButton.getStyleClass().add("button-blue");
		 * loginButton.setOnAction(e -> { Customer customer = new Customer();
		 * primaryStage.getScene().setRoot(customer.getRootPane()); });
		 * root.setConstraints(loginButton, 11, 14);
		 * 
		 * root.getChildren().addAll(login, username, tf, password, pf,
		 * loginButton);
		 */

	}

	public static void main(String[] args) {
		launch(args);
	}
}
