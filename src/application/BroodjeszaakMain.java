package application;
	
import domain.Broodjeszaak;
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		Broodjeszaak broodjeszaak = new Broodjeszaak();
		AdminView adminView = new AdminView(broodjeszaak);
		OrderView orderView = new OrderView();
		KitchenView kitchenView = new KitchenView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
