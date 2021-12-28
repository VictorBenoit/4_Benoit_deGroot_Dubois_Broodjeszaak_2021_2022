package domain.model.StatePattern;

import domain.model.Beleg;
import domain.model.BestelLijn;
import domain.model.Broodje;

import java.util.ArrayList;

public class InBestelling extends BestellingState {

    ArrayList<BestelLijn> bestelLijnArray = new ArrayList<>();

    public void voegBestelLijnToe(Broodje broodje, Beleg beleg) {
        BestelLijn bestelLijn = new BestelLijn(broodje, beleg);
        bestelLijnArray.add(bestelLijn);
    }

        public ArrayList<BestelLijn> getBestelLijnArray() {
            return bestelLijnArray;
        }
}
