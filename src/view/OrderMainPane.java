package view;

import controller.BestelViewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.OrderViewPane;

public class OrderMainPane extends BorderPane {
    public OrderMainPane() {

        BestelViewController bestelViewController = new BestelViewController();
        TabPane tabPane = new TabPane();

        OrderViewPane orderViewPane = new OrderViewPane(bestelViewController);
        Tab ordersTab = new Tab("Bestel", orderViewPane);
        tabPane.getTabs().add(ordersTab);
        this.setCenter(tabPane);
    }
}
