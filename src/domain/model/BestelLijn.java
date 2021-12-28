package domain.model;

public class BestelLijn {
    private String naamBroodje;
    private String naamBeleg;
    private String naamBelegen;

    public BestelLijn(String naamBroodje, String naamBelegen) {
        this.naamBroodje = naamBroodje;
        this.naamBelegen = naamBelegen;
        /*Broodje broodje = broodjesDatabase.getBroodje(naamBroodje);
        Beleg beleg = belegDatabase.getBeleg(naamBeleg);
        broodje.aanPassenVoorraad();
        beleg.aanPassenVoorraad();*/
    }

    public String getNaamBroodje() {
        return naamBroodje;
    }

    public String getNaamBelegen() {
        return naamBelegen;
    }

}
