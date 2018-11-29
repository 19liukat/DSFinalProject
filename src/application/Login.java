package application;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import application.User.User;
import application.User.UserArrayList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {

	private String checkUser, checkPw;
	private static Scene scene;
	private boolean containsUser = false;
	private User currentUser;

	public static Scene getScene() {
		return scene;
	}

	public Login(Stage primaryStage) throws IOException{
		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Adding image
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("icon.jpg");
		BufferedImage bufferedImage = ImageIO.read(input);
		Image logoImage = SwingFXUtils.toFXImage(bufferedImage,null);
		ImageView logo = new ImageView(logoImage);
		logo.setFitHeight(30);
		logo.setFitWidth(50);
		gridPane.add(logo, 1, 0);
		GridPane.setHalignment(logo, HPos.CENTER);

		// instantiate UserArrayList
		UserArrayList userList = new UserArrayList();

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("Username:");
		TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password:");
		PasswordField pf = new PasswordField();
		Button btnLogin = new Button("Login");
		GridPane.setHalignment(btnLogin, HPos.RIGHT);
		Label lblMessage = new Label();
		Text restaurant = new Text("Restaurant");
		restaurant.getStyleClass().add("secondary-header");
		Text advisor = new Text("Advisor");
 		advisor.getStyleClass().add("header-red");
		HBox hBoxText = new HBox(restaurant, advisor);
		hBoxText.setAlignment(Pos.CENTER);
		Hyperlink link = new Hyperlink();
		link.setText("Don't have an account? Sign up");
		link.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(new CreateAccount(primaryStage).getScene());
			}
		});
		
		// allow button to grow:
		btnLogin.setMaxWidth(Double.MAX_VALUE);
		// ask GridPane to make button fill it's cells:
		GridPane.setFillWidth(btnLogin, true);

		// Adding Nodes to GridPane layout
		gridPane.add(hBoxText, 1, 1);
		GridPane.setHalignment(hBoxText, HPos.CENTER);
		gridPane.add(lblUserName, 0, 2);
		gridPane.add(txtUserName, 1, 2);
		gridPane.add(lblPassword, 0, 3);
		gridPane.add(pf, 1, 3);
		gridPane.add(btnLogin, 1, 4);
		gridPane.add(link, 1, 5);
		gridPane.add(lblMessage, 1, 6);

		// Action for btnLogin and styling
		btnLogin.getStyleClass().add("button-blue");
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// traverses userList to see if they match
				checkUser = txtUserName.getText().toString();
				checkPw = pf.getText().toString();
				for (int i = 0; i < userList.getSize(); i++) {
					if (userList.getUserList().get(i).equalTo(checkUser, checkPw)) {
						containsUser = true;
						currentUser = userList.getUserList().get(i);
					}
				}

				if (containsUser) {
					primaryStage.setScene(new RestaurantListDisplay(primaryStage, currentUser).getScene());
				} else {
					lblMessage.setText("Incorrect username or password");
					lblMessage.setTextFill(Color.RED);
				}
				txtUserName.setText("");
				pf.setText("");
			}
		});

		scene = new Scene(gridPane, 500, 500);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.getStyleClass().add("background-white");

		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);

	}
}
