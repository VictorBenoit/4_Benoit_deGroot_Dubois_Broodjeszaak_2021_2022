package domain.model;

import domain.model.StatePattern.BestellingState;
import domain.model.StatePattern.InBestelling;
import domain.model.kortingStrategies.Factory.KortingStrategyFactory;
import domain.model.kortingStrategies.KortingStrategy;

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

    public KortingStrategy getDiscountStrategy(String activediscount) {
        if (activediscount == null) {
            activediscount = "No Discount";
        }
        return KortingStrategyFactory.createDiscount(activediscount);
    }
}
