package application;

import com.sun.security.ntlm.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateRestaurant {

	private static Scene scene;
	private final TableView table = new TableView();
	TableColumn<Item, String> name;
	TableColumn<Item, String> description;
	TableColumn<Item, String> type;
	TableColumn<Item, String> price;
	private final ObservableList<Item> data = FXCollections.observableArrayList();

	public static Scene getScene() {
		return scene;
	}

	public CreateRestaurant(Stage primaryStage) {

		ScrollPane sp = new ScrollPane();
		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Implementing Nodes for GridPane
		Text text = new Text("Create My Restaurant");
		Label lblRestaurantName = new Label("Restaurant Name:");
		TextField txtRestaurantName = new TextField();
		Label lblRestaurantType = new Label("Restaurant Type:");
		TextField txtRestaurantType = new TextField();
		Label lblStreetAddress = new Label("Street Address:");
		TextField txtStreetAddress = new TextField();
		Label lblCity = new Label("City:");
		TextField txtCity = new TextField();
		Label lblState = new Label("State:");
		TextField txtState = new TextField();
		Label lblZip = new Label("Zip Code:");
		TextField txtZip = new TextField();
		Label lblPrice = new Label("Price Range:");
		Label lblMenuItems = new Label("Menu Items:");
		Button btnSubmit = new Button("Submit");
		Button btnCancel = new Button("Cancel");
		Label lblMessage = new Label();

		// Adding radio buttons for price ranges
		ToggleGroup tg = new ToggleGroup();
		RadioButton lvlOne = new RadioButton("$");
		lvlOne.setToggleGroup(tg);
		RadioButton lvlTwo = new RadioButton("$$");
		lvlTwo.setToggleGroup(tg);
		RadioButton lvlThree = new RadioButton("$$$");
		lvlThree.setToggleGroup(tg);
		RadioButton lvlFour = new RadioButton("$$$$");
		lvlFour.setToggleGroup(tg);
		HBox RadioBox = new HBox(lvlOne, lvlTwo, lvlThree, lvlFour);

		// Table of menu items
		name = new TableColumn<Item, String>("Item Name");
		name.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));

		description = new TableColumn<Item, String>("Description");
		description.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));

		type = new TableColumn<Item, String>("Type");
		type.setCellValueFactory(new PropertyValueFactory<Item, String>("type"));

		price = new TableColumn<Item, String>("Price");
		price.setCellValueFactory(new PropertyValueFactory<Item, String>("price"));

		// Add columns to table
		table.getColumns().clear();
		table.getColumns().addAll(name, description, type, price);
		table.setEditable(true);

		// A button adds a row immediately starts editing it.
		Button addAndEdit = new Button("Add and edit");
		addAndEdit.getStyleClass().add("button-blue");
		addAndEdit.setOnAction((ActionEvent e) -> {
			int idx = table.getSelectionModel().getSelectedIndex() + 1;
			data.add(idx, new Item());
			table.getSelectionModel().select(idx);
			table.layout();
			table.edit(idx, name);
		});

		// Adding Nodes to GridPane layout
		gridPane.add(text, 1, 0);
		gridPane.add(lblRestaurantName, 0, 1);
		gridPane.add(txtRestaurantName, 1, 1);
		gridPane.add(lblRestaurantType, 0, 2);
		gridPane.add(txtRestaurantType, 1, 2);
		gridPane.add(lblStreetAddress, 0, 3);
		gridPane.add(txtStreetAddress, 1, 3);
		gridPane.add(lblCity, 0, 4);
		gridPane.add(txtCity, 1, 4);
		gridPane.add(lblState, 0, 5);
		gridPane.add(txtState, 1, 5);
		gridPane.add(lblZip, 0, 6);
		gridPane.add(txtZip, 1, 6);
		gridPane.add(lblPrice, 0, 7);
		gridPane.add(RadioBox, 1, 7);
		// gridPane.add(lblMenuItemsNum, 0, 8);
		gridPane.add(lblMenuItems, 0, 8);
		gridPane.add(table, 1, 8);
		gridPane.add(addAndEdit, 2, 8);
		gridPane.add(btnCancel, 0, 9);
		gridPane.add(btnSubmit, 1, 9);

		// Action for buttons (submit and cancel) and styling
		btnSubmit.getStyleClass().add("button-blue");
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(new RestaurantList(primaryStage).getScene());
			}
		});

		btnCancel.getStyleClass().add("button-red");
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(new RestaurantList(primaryStage).getScene());
			}
		});

		sp.setContent(gridPane);
		scene = new Scene(sp, 600, 600);

		// Import stylesheet into the GUI String
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
	}

	public void removeSelectedRows() {

		table.getItems().removeAll(table.getSelectionModel().getSelectedItems());

		// table selects by index, so we have to clear the selection or else
		// items with that index would be selected
		table.getSelectionModel().clearSelection();

	}

}
