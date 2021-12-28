package controller;

import domain.Observer;
import domain.model.BestelFacade;
import domain.model.BestelLijn;
import domain.model.BestellingEvents;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;

public class BestelViewController implements Observer {

    BestelFacade bestelFacade = new BestelFacade();
    ArrayList<BestelLijn> bestelLijnArray = new ArrayList<>();
    private static EnumSet<BestellingEvents> bestellingEventsEnumSet = EnumSet.of(BestellingEvents.TOEVOEGEN_BROODJE, BestellingEvents.TOEVOEGEN_BELEG);

    public BestelViewController() {
        bestelFacade.addObserver(this);
    }

    public void voegBestelLijnToe(String naamBroodje, String naamBelegen) {
        bestelFacade.voegBestelLijnToe(naamBroodje, naamBelegen);
    }

    public ArrayList<BestelLijn> getLijstBestelLijnen() {
        return bestelLijnArray;
    }

    public Map getVoorraadLijstBroodjes() {
        return bestelFacade.getVoorraadLijstBroodjes();
    }

    public Map getVoorraadLijstBeleg() {
        return bestelFacade.getVoorraadLijstBeleg();
    }

    public EnumSet<BestellingEvents> getEvent() {
        return bestellingEventsEnumSet;
    }

    public ArrayList<BestelLijn> update(ArrayList<BestelLijn> bestelLijn) {
        bestelLijnArray = bestelLijn;
        return bestelLijnArray;
    }
}
