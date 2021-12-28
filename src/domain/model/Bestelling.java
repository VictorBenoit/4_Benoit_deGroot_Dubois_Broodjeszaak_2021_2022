package domain.model;

import domain.model.StatePattern.BestellingState;
import domain.model.StatePattern.InBestelling;

import java.util.ArrayList;

public class Bestelling {

    ArrayList<BestelLijn> bestelLijnArrayList = new ArrayList<>();
    private BestellingState state;

    public Bestelling() {
        state = new InBestelling();
    }

    public ArrayList<BestelLijn> getLijstBestelLijnen() {
        bestelLijnArrayList = state.getBestelLijnArray();
        return bestelLijnArrayList;
    }

    public void voegBestelLijnToe(String naamBroodje, String naamBelegen) {
        state.voegBestelLijnToe(naamBroodje, naamBelegen);
    }
}
