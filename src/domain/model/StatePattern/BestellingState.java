package domain.model.StatePattern;

import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Broodje;

import java.util.ArrayList;

public abstract class BestellingState {

    public void voegBestelLijnToe(String naamBroodje, String naamBelegen) {

    }

    public abstract ArrayList<BestelLijn> getBestelLijnArray();
}
