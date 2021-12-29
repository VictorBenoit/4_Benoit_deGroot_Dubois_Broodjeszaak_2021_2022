package view.panels;

import controller.KitchenViewController;
import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Bestelling;
import domain.model.Broodje;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KitchenViewPane extends GridPane {
    private Bestelling bestelling;
    private KitchenViewController kitchenViewController;
    private ObservableList<BestelLijn> bestellingen;
    private TableView<BestelLijn> table1;
    private ObservableList<BestelLijn> bestelLijnArray;
    private ArrayList<BestelLijn> bestelLijnArrayList1;
    private int counter = 0;
    private Label label = new Label("Aantal bestellingen: ");

    public KitchenViewPane(KitchenViewController kitchenViewController) {
        this.kitchenViewController = kitchenViewController;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        VBox p3 = new VBox();
        Label label1 = new Label("Bestellingen: ");
        Button btn = new Button();
        btn.setOnAction(event -> {
            label.setText("Aantal bestellingen: " + Integer.toString(counter));
            counter();
        });
        p3.getChildren().addAll(label1, btn, label);
        this.add(p3, 0, 0);
    }

    public void counter() {
        counter++;
        // System.out.println(counter);
    }

}


