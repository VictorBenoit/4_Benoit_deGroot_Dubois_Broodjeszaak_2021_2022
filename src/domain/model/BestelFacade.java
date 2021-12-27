package domain.model;

import domain.Observer;
import domain.model.database.BroodjesDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BestelFacade implements Subject{

    String strategyBroodjesTekst = "BROODJETEKST";
    ArrayList<Bestelling> bestellings = new ArrayList<>();
    BroodjesDatabase broodjesDatabase = new BroodjesDatabase(strategyBroodjesTekst);
    Bestelling bestelling = new Bestelling();
    private List<Observer> observersList = new ArrayList<>();

    public BestelFacade() {
    }

    @Override
    public void voegBestelLijnToe(String naamBroodje) {
        Broodje broodje = broodjesDatabase.getBroodje(naamBroodje);
        bestelling.voegBestelLijnToe(broodje);
        bestellings.add(bestelling);
    }

    public ArrayList<BestelLijn> getLijstBestelLijnen() {
        notifyObservers();
        return bestelling.getLijstBestelLijnen();
    }

    @Override
    public Map getVoorraadLijstBroodjes() {
        return broodjesDatabase.getVoorraadLijstBroodjes();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observersList) {
            if (observer.getEvent() == BestellingEvents.TOEVOEGEN_BROODJE) {
                observer.update(bestelling.getLijstBestelLijnen());
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
