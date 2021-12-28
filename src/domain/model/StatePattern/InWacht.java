package domain.model.StatePattern;

import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Broodje;
import domain.model.StatePattern.BestellingState;

import java.util.ArrayList;

public class InWacht extends BestellingState {
    public void voegBestelLijnToe(String naamBroodje, String naamBelegen) {
        System.out.println("Bestelling staat in wacht! Probeer later opnieuw.");
    }

    @Override
    public ArrayList<BestelLijn> getBestelLijnArray() {
        System.out.println("Bestelling staat in wacht! Probeer later opnieuw.");
        return null;
    }
}
