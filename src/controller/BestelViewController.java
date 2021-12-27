package controller;

import domain.Observer;
import domain.model.BestelFacade;
import domain.model.BestelLijn;
import domain.model.BestellingEvents;

import java.util.ArrayList;
import java.util.Map;

public class BestelViewController implements Observer {

    BestelFacade bestelFacade = new BestelFacade();
    ArrayList<BestelLijn> bestelLijnArray = new ArrayList<>();
    private BestellingEvents event;

    public BestelViewController() {
        event = BestellingEvents.TOEVOEGEN_BROODJE;
        bestelFacade.addObserver(this);
    }

    public void voegBestelLijnToe(String naamBroodje) {}

    public ArrayList<BestelLijn> getLijstBestlLijnen() {
        return bestelFacade.getLijstBestelLijnen();
    }

    public Map getVoorraadlijstBroodjes() {
        return bestelFacade.getVoorraadLijstBroodjes();
    }

    public BestellingEvents getEvent() {
        return event;
    }

    public ArrayList<BestelLijn> update(ArrayList<BestelLijn> bestelLijn) {
        bestelLijnArray = bestelLijn;
        return bestelLijnArray;
    }
}
