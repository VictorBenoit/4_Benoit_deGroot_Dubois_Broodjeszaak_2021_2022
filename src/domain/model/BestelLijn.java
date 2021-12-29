package domain.model;

import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;
import domain.model.kortingStrategies.Factory.KortingStrategyEnum;
import javafx.scene.control.Alert;

public class BestelLijn {

    private String naamBroodje;
    private String naamBelegen;
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    double total = 0;

    public BestelLijn(String naamBroodje, String naamBelegen) {

        broodjesDatabase = new BroodjesDatabase("BROODJEEXCEL");
        belegDatabase = new BelegDatabase("BELEGEXCEL");
        Broodje broodje = broodjesDatabase.getBroodje(naamBroodje);
        int currentAmountBroodje = broodje.getAmount();
        if (currentAmountBroodje > 0) {
            this.naamBroodje = naamBroodje;
            broodje.aanPassenVoorraad();
            broodje.aanPassenVerkoop();
            int amountBroodje = broodje.getAmount();
            int salesBroodje = broodje.getSales();
            broodjesDatabase.updateDatabase(naamBroodje, amountBroodje, salesBroodje);
            broodjesDatabase.saveDatabase();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error venster");
            alert.setHeaderText(null);
            alert.setContentText("Broodjes zijn op!");
            alert.showAndWait();
            return;
        }

    String[] belegAppart = naamBelegen.split(" ");
            for (String naamBeleg : belegAppart) {
                Beleg beleg = belegDatabase.getBeleg(naamBeleg);
                int currentAmount = beleg.getAmount();
                if (currentAmount > 0) {
                    this.naamBelegen = naamBelegen;
                    beleg.aanPassenVoorraad();
                    beleg.aanPassenVerkoop();
                    int amountBeleg = beleg.getAmount();
                    int salesBeleg = beleg.getSales();
                    belegDatabase.updateDatabase(naamBeleg, amountBeleg, salesBeleg);
                    belegDatabase.saveDatabase();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error venster");
                    alert.setHeaderText(null);
                    alert.setContentText("Beleg is op!");
                    alert.showAndWait();
                }

            }
    }

    public double getAmountBestelling(){
        total = broodjesDatabase.getBroodje(naamBroodje).getPrice();
        for(int i = 0; i != belegDatabase.getBeleggenArrayList().size(); i++){
            total += belegDatabase.getBeleggenArrayList().get(i).getPrice();

        }

        return total;

    }

    public String getNaamBroodje() {
        return naamBroodje;
    }

    public String getNaamBelegen() {
        return naamBelegen;
    }

}
