package view;

import controller.KitchenViewController;
import domain.model.Bestelling;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.KitchenViewPane;
import view.panels.OrderViewPane;

public class KitchenMainPane extends BorderPane {
    public KitchenMainPane() {
        KitchenViewController kitchenViewController = new KitchenViewController();
        TabPane tabPane = new TabPane();

        KitchenViewPane kitchenViewPane = new KitchenViewPane(kitchenViewController );
        Tab kitchenTab = new Tab("Bestellingen", kitchenViewPane);
        tabPane.getTabs().add(kitchenTab);
        this.setCenter(tabPane);
    }


}
