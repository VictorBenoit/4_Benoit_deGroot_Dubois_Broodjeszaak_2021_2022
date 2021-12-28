package view.panels;

import controller.BestelViewController;
import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class OrderViewPane extends GridPane {

    private BestelViewController bestelViewController;
    private ObservableList<Beleg> beleggen;
    private TableView<Beleg> table1;
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    private TableView<BestelLijn> table2;
    private ObservableList<BestelLijn> bestelLijnArray;

    ArrayList<BestelLijn> bestelLijnArrayList = new ArrayList<>();

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

        // Beleg
        VBox p2 = new VBox(8);
        p2.setAlignment(Pos.CENTER);
        p3.setPadding(new Insets(0));
        p3.setBackground(
                new Background(
                        new BackgroundFill(Color.WHITE,
                                new CornerRadii(20), new Insets(0))));

        /*ArrayList<Beleg> beleg = belegDatabase.getBeleggenArrayList();*/

        table1 = new TableView<>();
        refresh1();
        /*StringJoiner joiner = new StringJoiner(System.lineSeparator());
        ArrayList<String> belegName = belegDatabase.getKeyBeleg();*/

        TableColumn<Beleg, String> colName1 = new TableColumn<Beleg, String>("Beleg");
        colName1.setMinWidth(300);
        colName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        /*TableColumn<Beleg, Double> colPrice1 = new TableColumn<>("Prijs");
        colPrice1.setMinWidth(100);
        colPrice1.setCellValueFactory(new PropertyValueFactory<Beleg, Double>("price"));*/

        table1.getColumns().addAll(colName1);
        this.add(table1, 0, 1);

        /*String selectieBeleg = String.valueOf(table1.getSelectionModel().getSelectedItem());
        System.out.println(selectieBeleg);*/

        Label type2 = new Label("Selecteer beleg:");
        Button btBelegToevoegen = new Button();
        btBelegToevoegen.setText("+1");
        p2.getChildren().addAll(type2, btBelegToevoegen);

        Label type3 = new Label("Bestelling voltooid?");
        Button btBestel = new Button();
        btBestel.setText("Bestelling Plaatsen");
        p2.getChildren().addAll(type3, btBestel);

        btBestel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectieBroodje = chbx.getSelectionModel().getSelectedItem();
                System.out.println(selectieBroodje);
                String selectieBeleg = (table1.getSelectionModel().getSelectedItem().getName());
                System.out.println(selectieBeleg);
                bestelViewController.voegBestelLijnToe(selectieBroodje, selectieBeleg);

                bestelLijnArrayList = bestelViewController.getLijstBestlLijnen();
                updateLijnen(bestelLijnArrayList);
                for(BestelLijn bestelLijn: bestelLijnArrayList) {
                    String broodje = bestelLijn.getNaamBroodje();
                    System.out.println(broodje);
                    String beleg = bestelLijn.getNaamBeleg();
                    System.out.println(beleg);
                }
            }
        });

        /*btBestel.setOnAction(actionEvent -> bestelViewController.voegBestelLijnToe(selectieBroodje, selectieBeleg));*/

        this.add(p2, 0, 2);

        // Moet waarde beleg zijn.


        //plus.setOnAction(e -> countUp());
        //min.setOnAction(e -> countDown());

    }

    public void updateLijnen(ArrayList<BestelLijn> bestelLijnArrayList1) {
        Label label1 = new Label("Bestel lijnen");
        table2 = new TableView<>();
        refresh2(bestelLijnArrayList1);
        TableColumn<BestelLijn, String> colName1 = new TableColumn<>("Besteld broodje");
        colName1.setMinWidth(150);
        colName1.setCellValueFactory(new PropertyValueFactory<BestelLijn, String>("naamBroodje"));
        TableColumn<BestelLijn, String> colName2 = new TableColumn<>("Besteld beleg");
        colName2.setMinWidth(150);
        colName2.setCellValueFactory(new PropertyValueFactory<BestelLijn, String>("naamBeleg"));
        table2.getColumns().addAll(colName1, colName2);

        this.add(label1, 1, 0);
        this.add(table2, 1, 1);
    }

    public void refresh1() {
        beleggen = FXCollections.observableArrayList(belegDatabase.getBeleggenArrayList());
        table1.setItems(beleggen);
        table1.refresh();
    }

    public void refresh2(ArrayList<BestelLijn> bestelLijnArrayList2) {
        bestelLijnArray = FXCollections.observableArrayList(bestelLijnArrayList2);
        table2.setItems(bestelLijnArray);
        table2.refresh();
    }


    public void setLabel(String s) {
    }
}
