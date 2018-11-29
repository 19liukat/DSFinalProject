package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import application.User.User;
import application.User.UserArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateAccount {
	private static Scene scene;
	private String checkPw1;
	private String checkPw2;

	public static Scene getScene() {
		return scene;
	}

	public CreateAccount(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		// instantiate single userList
		UserArrayList userList = new UserArrayList();

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("Username:");
		TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password:");
		PasswordField pf = new PasswordField();
		Label lblConfPass = new Label("Confirm Password:");
		PasswordField confPf = new PasswordField();
		Button btnCreateAccount = new Button("Create Account");
		Label lblMessage = new Label();
		Text restaurant = new Text("Restaurant");
		restaurant.getStyleClass().add("secondary-header");
		Text advisor = new Text("Advisor");
		advisor.getStyleClass().add("header-red");
		HBox hBoxText = new HBox(restaurant, advisor);
		hBoxText.setAlignment(Pos.CENTER);
		btnCreateAccount.getStyleClass().add("button-blue");
		btnCreateAccount.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				checkPw1 = pf.getText().toString();
				checkPw2 = confPf.getText().toString();

				if (txtUserName.getText().equals("")) {
					lblMessage.setText("Please enter a valid username");
				} else if (pf.getText().equals("")) {
					lblMessage.setText("Please enter a valid password");
				} else {
					if (checkPw1.equals(checkPw2)) {
						User newUser = new User(txtUserName.getText().toString(), checkPw1);
						userList.addUser(newUser);
						primaryStage.setScene(new RestaurantListDisplay(primaryStage, newUser).getScene());
						// Appends new username and password to text file so you can log in later
						try {
				            Files.write(Paths.get("src/application/User/UserList"), ("\n" + newUser.getUsername() + ";" + newUser.getPassword()).getBytes(), StandardOpenOption.APPEND);

						}catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						lblMessage.setText("Passwords don't match");
						lblMessage.setTextFill(Color.RED);
					}
					txtUserName.setText("");
					pf.setText("");
					confPf.setText("");
				}
			}
		});

		// Adding Nodes to GridPane layout
		gridPane.add(hBoxText, 1, 0);
		gridPane.add(lblUserName, 0, 1);
		gridPane.add(txtUserName, 1, 1);
		gridPane.add(lblPassword, 0, 2);
		gridPane.add(pf, 1, 2);
		gridPane.add(lblConfPass, 0, 3);
		gridPane.add(confPf, 1, 3);
		gridPane.add(btnCreateAccount, 1, 4);
		gridPane.add(lblMessage, 1, 5);
		lblMessage.setTextFill(Color.RED);

		// allow button to grow:
		btnCreateAccount.setMaxWidth(Double.MAX_VALUE);
		// ask GridPane to make button fill it's cells:
		GridPane.setFillWidth(btnCreateAccount, true);

		scene = new Scene(gridPane, 500, 500);
		gridPane.setAlignment(Pos.CENTER);

		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		gridPane.getStyleClass().add("background-white");
	}

}
