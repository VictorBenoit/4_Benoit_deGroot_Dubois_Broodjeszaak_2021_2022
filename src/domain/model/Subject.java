package domain.model;

import domain.Observer;

import java.util.ArrayList;
import java.util.Map;

public interface Subject {

    public void voegBestelLijnToe(String naamBroodje, String naamBelegen);
    public ArrayList<BestelLijn> getLijstBestelLijnen();
    public Map getVoorraadLijstBroodjes();
    public Map getVoorraadLijstBeleg();
    public void notifyObservers();
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
}
