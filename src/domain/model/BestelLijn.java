package domain.model;

public class BestelLijn {
    private String naamBroodje;
    private String naamBeleg;

    public BestelLijn(Broodje broodje, Beleg beleg) {
        naamBroodje = broodje.getName();
        naamBeleg = beleg.getName();
        broodje.aanPassenVoorraad();
        beleg.aanPassenVoorraad();
    }

    public String getNaamBroodje() {
        return naamBroodje;
    }

    public String getNaamBeleg() {
        return naamBeleg;
    }

}
