package application;
import controller.CountController;
import domain.*;
//import domain.model.Beleg;
//import domain.Broodjeszaak;
import domain.model.Beleg;
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
		CountModel model = new CountModel();
		CountController ccontroller = new CountController(model);

		Broodje broodje = new Broodje("bruin", 5.0, 10, 0);
		Beleg beleg = new Beleg("spek", 0.50, 10, 0);
		AdminView adminView = new AdminView(broodjeszaak);
		OrderView orderView = new OrderView(broodjeszaak);
		KitchenView kitchenView = new KitchenView();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
