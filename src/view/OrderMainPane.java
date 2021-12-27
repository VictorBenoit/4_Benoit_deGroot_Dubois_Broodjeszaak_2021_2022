package view;

import domain.Broodjeszaak;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.OrderViewPane;

public class OrderMainPane extends BorderPane {
    public OrderMainPane(Broodjeszaak broodjeszaak) {
        TabPane tabPane = new TabPane();
        OrderViewPane orderViewPane = new OrderViewPane(broodjeszaak);
        Tab ordersTab = new Tab("Bestel", orderViewPane);
        tabPane.getTabs().add(ordersTab);
        this.setCenter(tabPane);
    }
}
