package application;
import controller.BestelViewController;
import controller.CountController;
import controller.KitchenViewController;
import domain.*;
//import domain.model.Beleg;
//import domain.Broodjeszaak;
import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Broodje;
import domain.model.CountModel;
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.OrderView;
import view.panels.OrderViewPane;


public class BroodjeszaakMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		Broodjeszaak broodjeszaak = new Broodjeszaak();
		BestelViewController bestelViewController = new BestelViewController();
		KitchenViewController kitchenViewController = new KitchenViewController();
		Broodje broodje = new Broodje("bruin", 5.0, 10, 0);
		Beleg beleg = new Beleg("spek", 0.50, 10, 0);
		AdminView adminView = new AdminView(broodjeszaak);
		OrderView orderView = new OrderView(bestelViewController);
		KitchenView kitchenView = new KitchenView(kitchenViewController);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
