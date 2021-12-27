package view;

import controller.BestelViewController;
import controller.CountController;
import domain.Broodjeszaak;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderView {
	private Stage stage = new Stage();
	private Label lbl = new Label("Count is 0");
	private Pane root;
	private Scene scene;
	public OrderView(BestelViewController bestelViewController){
		stage.setTitle("ORDER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);

		Group root = new Group();
		Scene scene = new Scene(root, 650, 650);
		BorderPane borderPane = new OrderMainPane(bestelViewController);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();

		stage.show();

	}


}
