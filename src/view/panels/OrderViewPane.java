package view.panels;

import controller.BestelViewController;
import domain.model.Beleg;
import domain.model.Broodje;
import domain.Broodjeszaak;
import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.StringJoiner;

public class OrderViewPane extends GridPane {

    private BestelViewController bestelViewController;
    private ArrayList<Beleg> belegName;
    private ObservableList<Beleg> beleggen;
    private TableView<Beleg> table;
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;

    public OrderViewPane(BestelViewController bestelViewController) {
        this.bestelViewController = bestelViewController;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        // Broodje
        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER_LEFT);
        p3.setPadding(new Insets(10));

        Label type1 = new Label("Selecteer type broodje:");
        // geef domain.. terug ipv naam.

        broodjesDatabase = new BroodjesDatabase("BROODJETEKST");
        belegDatabase = new BelegDatabase("BELEGTEKST");

        ArrayList<String> broodjesName = broodjesDatabase.getKeyBroodjes();

        ObservableList<String> observableList = FXCollections.observableList(broodjesName);
        ChoiceBox<String> chbx = new ChoiceBox<>();
        chbx.setItems(observableList);
        chbx.getItems();
        p3.getChildren().addAll(type1, chbx);
        this.add(p3, 0, 0);

        //beleg
        VBox p2 = new VBox(8);
        p2.setAlignment(Pos.CENTER_LEFT);
        p3.setPadding(new Insets(0));
        p3.setBackground(
                new Background(
                        new BackgroundFill(Color.WHITE,
                                new CornerRadii(20), new Insets(0))));
        Label type2 = new Label("Selecteer beleg:");
        ArrayList<Beleg> beleg = belegDatabase.getBeleggenArrayList();

        table = new TableView<>();
        refresh1();
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        ArrayList<String> belegName = belegDatabase.getKeyBeleg();

        TableColumn<Beleg, String> colName1 = new TableColumn<Beleg, String>("Beleg");
        colName1.setMinWidth(100);
        colName1.setCellValueFactory(new PropertyValueFactory<Beleg, String>("name"));
        table.getColumns().addAll(colName1);
        this.add(table, 0, 1);

        Button bt = new Button();
        bt.setText("+1");
        p2.getChildren().addAll(type2, bt);
        this.add(p2, 0, 4);

        // Moet waarde beleg zijn.


        //plus.setOnAction(e -> countUp());
        //min.setOnAction(e -> countDown());



    }

    public void refresh1() {
        beleggen = FXCollections.observableArrayList(belegDatabase.getBeleggenArrayList());
        table.setItems(beleggen);
        table.refresh();
    }


    public void setLabel(String s) {
    }
}
