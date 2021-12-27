package view.panels;

import controller.CountController;
import domain.Broodjeszaak;
import domain.model.Beleg;
import domain.model.Broodje;
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
    private Broodjeszaak broodjeszaak;
    private BelegDatabase belegDatabase;
    private ObservableList<Beleg> beleggen;
    private ArrayList<Beleg> belegge;
    private ArrayList<String> belegName = new ArrayList<>();
    private Label lbl = new Label("Count is 0");
    private CountController cont;
    VBox box1;
    Label broodjeType;
    TableView<Beleg> table;

    public OrderViewPane(Broodjeszaak broodjeszaak) {
        this.broodjeszaak = broodjeszaak;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        // Broodje
        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER_LEFT);
        p3.setPadding(new Insets(10));

        Label type1 = new Label("Selecteer type broodje:");


        // geef domain.. terug ipv naam.

        ArrayList<Broodje> broodje = new ArrayList<>(broodjeszaak.getBroodjes());
        ArrayList<String> broodjesName = new ArrayList<>();
        for (Broodje b : broodje
        ) {
            String name = b.getName();
            System.out.println(name);
            broodjesName.add(name);
        }
        ObservableList<String> observableList = FXCollections.observableList(broodjesName);
        ChoiceBox<String> chbx = new ChoiceBox<>();
        chbx.setItems(observableList);
        chbx.getItems();
        p3.getChildren().addAll(type1, chbx);
        this.add(p3, 0, 0);

        //beleg
        VBox p2 = new VBox(8);
        p2.setAlignment(Pos.CENTER_LEFT);

        Label type2 = new Label("Selecteer 5 verschillende beleg:");
        ArrayList<Beleg> belegje = new ArrayList<>(broodjeszaak.getBeleg());
        ArrayList<String> belegName = new ArrayList<>();
        for (Beleg b : belegje
        ) {
            String name = b.getName();
            System.out.println(name);
            belegName.add(name);
        }
        ObservableList<String> observableList2 = FXCollections.observableList(belegName);
        ChoiceBox<String> chbx2 = new ChoiceBox<>();
        chbx2.setItems(observableList2);
        chbx2.getItems();

        ChoiceBox<String> chbx3 = new ChoiceBox<>();
        chbx3.setItems(observableList2);
        chbx3.getItems();

        ChoiceBox<String> chbx4 = new ChoiceBox<>();
        chbx4.setItems(observableList2);
        chbx4.getItems();

        ChoiceBox<String> chbx5 = new ChoiceBox<>();
        chbx5.setItems(observableList2);
        chbx5.getItems();

        ChoiceBox<String> chbx6 = new ChoiceBox<>();
        chbx6.setItems(observableList2);
        chbx6.getItems();

        p2.getChildren().addAll(type2, chbx2, chbx3, chbx4, chbx5, chbx6);
        this.add(p2,0, 1);

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER_LEFT);

        Label lbl = new Label("Count is 0");
        Button inc = new Button("Increment");
        Button dec = new Button("Decrement");
        p1.setAlignment(Pos.CENTER);       p1.setPadding(new Insets(10));
        p1.getChildren().addAll(lbl, inc, dec);
        inc.setOnAction(e -> cont.incrementButtonPressed());
        dec.setOnAction(e -> cont.decrementButtonPressed());
        this.add(p1, 1, 0);


        /*
        ArrayList<Beleg> beleg = new ArrayList<>(broodjeszaak.getBeleg());


        table = new TableView<>();
        refresh1();
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        ArrayList<String> belegName = new ArrayList<>();
        for (Beleg b : beleg
        ) {
            String name = b.getName();
            joiner.add(b.getName());
            System.out.println(name);
            belegName.add(name);
        }
        Button bt = new Button();
        bt.setText("+1");

        TableColumn<Beleg, String> colName1 = new TableColumn<Beleg, String>("Beleg");
        colName1.setMinWidth(100);
        colName1.setCellValueFactory(new PropertyValueFactory<Beleg, String>("name"));
        table.getColumns().addAll(colName1);
        this.add(table, 0, 1);


        p2.getChildren().addAll(type2, bt);
        this.add(p2, 1, 1);

        // Moet waarde beleg zijn.


        //plus.setOnAction(e -> countUp());
        //min.setOnAction(e -> countDown());


*/
    }

   /* public Pane root() {
        return root;
    }*/
   public void setLabel(String s) {
       lbl.setText(s);
   }

}
