package view.panels;

import controller.KitchenViewController;
import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Bestelling;
import domain.model.Broodje;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class KitchenViewPane extends GridPane {
    private Bestelling bestelling;
    private KitchenViewController kitchenViewController;
    private ObservableList<BestelLijn> bestellingen;
    private TableView<BestelLijn> table1;
    public KitchenViewPane(KitchenViewController kitchenViewController) {
        this.kitchenViewController = kitchenViewController;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        Label label1 = new Label("Bestellingen");
        table1 = new TableView<BestelLijn>();
       // refresh1();



    }
    public void refresh1() {
        bestellingen = FXCollections.observableArrayList(bestelling.getLijstBestelLijnen());
        table1.setItems(bestellingen);
        table1.refresh();
    }
}
