package domain.model;

import domain.Observer;
import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class BestelFacade implements Subject{

    String strategyBroodjesTekst = "BROODJETEKST";
    BroodjesDatabase broodjesDatabase = new BroodjesDatabase(strategyBroodjesTekst);
    String strategyBelegTekst = "BELEGTEKST";
    BelegDatabase belegDatabase = new BelegDatabase(strategyBelegTekst);
    ArrayList<Bestelling> bestellings = new ArrayList<>();
    private List<Observer> observersList = new ArrayList<>();
    Bestelling bestelling;

    public BestelFacade() {
        bestelling = new Bestelling();
    }

    @Override
    public void voegBestelLijnToe(String naamBroodje, String naamBelegen) {
        bestelling.voegBestelLijnToe(naamBroodje, naamBelegen);
        bestellings.add(bestelling);
        notifyObservers();
    }

    public ArrayList<BestelLijn> getLijstBestelLijnen() {
        return bestelling.getLijstBestelLijnen();
    }

    @Override
    public Map getVoorraadLijstBroodjes() {
        return broodjesDatabase.getVoorraadLijstBroodjes();
    }

    @Override
    public Map getVoorraadLijstBeleg() {
        return belegDatabase.getVoorraadLijstBeleg();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observersList) {
            EnumSet<BestellingEvents> bestellingEventsEnumSet = observer.getEvent();
            for (BestellingEvents event : bestellingEventsEnumSet) {
                if (event == BestellingEvents.TOEVOEGEN_BROODJE || event == BestellingEvents.TOEVOEGEN_BELEG) {
                    observer.update(bestelling.getLijstBestelLijnen());
                }
            }
        }
    }

    public void addObserver(Observer observer) {
        this.observersList.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observersList.remove(observer);
    }
}
