package domain.model;

import java.util.ArrayList;

public class Bestelling {

    ArrayList<BestelLijn> bestelLijnArray = new ArrayList<>();

    public Bestelling() {

    }

    public ArrayList<BestelLijn> getLijstBestelLijnen() {
        return bestelLijnArray;
    }

    public void voegBestelLijnToe(Broodje broodje) {
        BestelLijn bestelLijn = new BestelLijn(broodje);
        bestelLijnArray.add(bestelLijn);
    }
}
