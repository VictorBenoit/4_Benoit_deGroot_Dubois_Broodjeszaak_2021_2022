package domain.model;

import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;

public class BestelLijn {
    private String naamBroodje;
    private String naamBelegen;
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;

    public BestelLijn(String naamBroodje, String naamBelegen) {
        this.naamBroodje = naamBroodje;
        this.naamBelegen = naamBelegen;
        broodjesDatabase = new BroodjesDatabase("BROODJEEXCEL");
        belegDatabase = new BelegDatabase("BELEGEXCEL");

        Broodje broodje = broodjesDatabase.getBroodje(naamBroodje);
        broodje.aanPassenVoorraad();
        int amountBroodje = broodje.getAmount();
        broodjesDatabase.updateDatabase(naamBroodje, amountBroodje);
        broodjesDatabase.saveDatabase();

        String[] belegAppart = naamBelegen.split(" ");
        for (String naamBeleg: belegAppart) {
            Beleg beleg = belegDatabase.getBeleg(naamBeleg);
            beleg.aanPassenVoorraad();
            int amountBeleg = beleg.getAmount();
            belegDatabase.updateDatabase(naamBeleg, amountBeleg);
            belegDatabase.saveDatabase();
        }
    }

    public String getNaamBroodje() {
        return naamBroodje;
    }

    public String getNaamBelegen() {
        return naamBelegen;
    }

}
