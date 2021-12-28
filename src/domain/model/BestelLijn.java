package domain.model;

public class BestelLijn {
    private String naamBroodje;
    private String naamBeleg;

    public BestelLijn(String naamBroodje, String naamBeleg) {
        this.naamBroodje = naamBroodje;
        this.naamBeleg = naamBeleg;
        /*Broodje broodje = broodjesDatabase.getBroodje(naamBroodje);
        Beleg beleg = belegDatabase.getBeleg(naamBeleg);*//*
        broodje.aanPassenVoorraad();
        beleg.aanPassenVoorraad();*/
    }

    public String getNaamBroodje() {
        return naamBroodje;
    }

    public String getNaamBeleg() {
        return naamBeleg;
    }

}
