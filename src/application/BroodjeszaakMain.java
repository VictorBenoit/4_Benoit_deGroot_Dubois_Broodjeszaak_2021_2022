package application;
import domain.*;
//import domain.Beleg;
//import domain.Broodjeszaak;
import domain.loadSaveStrategies.BroodjesExcelLoadSaveStrategy;
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.OrderView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class BroodjeszaakMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		Broodjeszaak broodjeszaak = new Broodjeszaak();
		Broodje broodje = new Broodje("bruin", 5.0, 10, 0);
		Beleg beleg = new Beleg("spek", 0.50, 10, 0);
		AdminView adminView = new AdminView(broodjeszaak);
		OrderView orderView = new OrderView();
		KitchenView kitchenView = new KitchenView();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
