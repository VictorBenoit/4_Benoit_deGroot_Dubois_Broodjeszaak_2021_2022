package domain.model;

public class BestelLijn {
    private String naamBroodje;

    public BestelLijn(Broodje broodje) {
        String naamBroodje = broodje.getName();
        broodje.aanPassenVoorraad();
    }
}
