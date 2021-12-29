package view.panels;

import controller.BestelViewController;
import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Bestelling;
import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;
import domain.model.kortingStrategies.Factory.KortingStrategyEnum;
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
    private String allBeleg;
    Button btBestel = new Button();
    private double total;
    ArrayList<BestelLijn> bestelLijnArrayList = new ArrayList<>();
    private Label type9 = new Label();
    private KortingStrategyEnum kortingStrategyEnum;
    ComboBox<String> comboBox = new ComboBox<>();
    Bestelling bestelling;

    public OrderViewPane(BestelViewController bestelViewController) {
        this.bestelViewController = bestelViewController;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        allBeleg = "";

        // Broodje
        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER_LEFT);
        p3.setPadding(new Insets(10));

        Label type1 = new Label("Selecteer type broodje:");
        // geef domain.. terug ipv naam.

        broodjesDatabase = new BroodjesDatabase("BROODJEEXCEL");
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
        p2.setAlignment(Pos.CENTER_LEFT);
        p3.setPadding(new Insets(0));
        p3.setBackground(
                new Background(
                        new BackgroundFill(Color.WHITE,
                                new CornerRadii(20), new Insets(0))));

        table1 = new TableView<>();
        refresh1();

        TableColumn<Beleg, String> colName1 = new TableColumn<Beleg, String>("Beleg");
        colName1.setMinWidth(300);
        colName1.setCellValueFactory(new PropertyValueFactory<>("name"));

        table1.getColumns().addAll(colName1);
        this.add(table1, 0, 1);

        VBox p4 = new VBox(8);
        p4.setAlignment(Pos.CENTER_LEFT);
        p4.setPadding(new Insets(10));

        Label type2 = new Label("Selecteer beleg:");
        Button btBelegToevoegen = new Button();
        btBelegToevoegen.setText("+1");
        p4.getChildren().addAll(type2, btBelegToevoegen);

        Label type3 = new Label("Bestelling voltooid?");

        btBestel.setText("Bestelling Plaatsen");
        p4.getChildren().addAll(type3, btBestel);

        Label type4 = new Label("Vorige bestel lijn toevoegen");
        Button btIdentiek = new Button();
        btIdentiek.setText("Toevoegen");
        p4.getChildren().addAll(type4, btIdentiek);

        Label type5 = new Label("Vorige bestel lijn verwijderen");
        Button btVerwijderen = new Button();
        btVerwijderen.setText("Verwijderen");
        p4.getChildren().addAll(type5, btVerwijderen);

        Label type6 = new Label("Volledige bestelling annuleren");
        Button btAllesVerwijderen = new Button();
        btAllesVerwijderen.setText("Alles verwijderen");
        p4.getChildren().addAll(type6, btAllesVerwijderen);

        Label type8 = new Label("Kies korting:");


        comboBox.getItems().add("geen korting");
        comboBox.getItems().add("10% korting");
        comboBox.getItems().add("Gratis korting voor goedkoopste broodje");
        p4.getChildren().addAll(type8, comboBox);

        Label type7 = new Label("Bestelling afsluiten");
        Button btAfsluiten = new Button();
        btAfsluiten.setText("Afsluiten");
        p4.getChildren().addAll(type7, btAfsluiten);

        type9.setText("Prijs: " + total);
        p4.getChildren().addAll(type9);
        btAfsluiten.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            try {


                   bestelLijnArrayList = bestelViewController.getLijstBestelLijnen();
                    String test = comboBox.getSelectionModel().getSelectedItem();


                System.out.println("dd: " +test);
                                            for (BestelLijn b:bestelLijnArrayList
                                            ) {
                                                total += b.getAmountBestelling();

                                            }
                System.out.println(total);
                //Geeft nullpointer om korting te berekenen
                //  double krt = bestelling.getDiscountStrategy(test).calculateTotalReduction(total);

                                            type9.setText("" + total );
                System.out.println(type9);
                                        }catch (NullPointerException e) {
                                            Alert alert = new Alert(Alert.AlertType.WARNING);
                                            alert.setTitle("Error venster");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Fout in methode");
                                            alert.showAndWait();
                                        }

                                }
        });


        btBestel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String selectieBroodje = chbx.getSelectionModel().getSelectedItem();
                    bestelViewController.voegBestelLijnToe(selectieBroodje, allBeleg);
                    bestelLijnArrayList = bestelViewController.getLijstBestelLijnen();
                    updateLijnen(bestelLijnArrayList);

                    allBeleg = "";
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error venster");
                    alert.setHeaderText(null);
                    alert.setContentText("Foute bestelling, kies ten minste 1 broodje en 1 beleg.");
                    alert.showAndWait();
                }

            }
        });

        btBelegToevoegen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    String choiceBeleg = table1.getSelectionModel().getSelectedItem().getName();
                    allBeleg += choiceBeleg + " ";
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error venster");
                    alert.setHeaderText(null);
                    alert.setContentText("Maak een keuze van een beleg!");
                    alert.showAndWait();
                }
            }
        });

        btIdentiek.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    try {
                        bestelViewController.getIdentiekeLijn(bestelLijnArrayList);
                        bestelLijnArrayList = bestelViewController.getLijstBestelLijnen();
                        updateLijnen(bestelLijnArrayList);
                        allBeleg = "";
                    } catch (NullPointerException e) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error venster");
                        alert.setHeaderText(null);
                        alert.setContentText("Actie kan niet uitgevoerd worden!");
                        alert.showAndWait();
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error venster");
                    alert.setHeaderText(null);
                    alert.setContentText("Actie kan niet uitgevoerd worden!");
                    alert.showAndWait();
                }
            }
        });

        btVerwijderen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    bestelViewController.verwijderen(bestelLijnArrayList);
                    bestelLijnArrayList = bestelViewController.getLijstBestelLijnen();
                    updateLijnen(bestelLijnArrayList);

                    allBeleg = "";
                } catch (ArrayIndexOutOfBoundsException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error venster");
                    alert.setHeaderText(null);
                    alert.setContentText("Alles is al verwijderd.");
                    alert.showAndWait();
                }
            }
        });

        btAllesVerwijderen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bestelViewController.allesVerwijderen();
                bestelLijnArrayList = bestelViewController.getLijstBestelLijnen();
                updateLijnen(bestelLijnArrayList);

                allBeleg = "";
            }
        });

        this.add(p2, 0, 2);
        this.add(p4, 0, 3);
    }

    public void updateLijnen(ArrayList<BestelLijn> bestelLijnArrayList1) {
        table2 = new TableView<>();
        Label label1 = new Label("Bestel lijnen");
        refresh2(bestelLijnArrayList1);
        TableColumn<BestelLijn, String> colName1 = new TableColumn<>("Besteld broodje");
        colName1.setMinWidth(150);
        colName1.setCellValueFactory(new PropertyValueFactory<BestelLijn, String>("naamBroodje"));
        TableColumn<BestelLijn, String> colName2 = new TableColumn<>("Besteld beleg");
        colName2.setMinWidth(150);
        colName2.setCellValueFactory(new PropertyValueFactory<BestelLijn, String>("naamBelegen"));
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

    public String getSelectedDiscount() {
        return comboBox.getSelectionModel().getSelectedItem();
    }




}
