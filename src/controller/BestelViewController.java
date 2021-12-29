package controller;

import domain.Observer;
import domain.model.BestelFacade;
import domain.model.BestelLijn;
import domain.model.BestellingEvents;
import view.panels.OrderViewPane;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;

public class BestelViewController extends CountController implements Observer {

    BestelFacade bestelFacade = new BestelFacade();
    ArrayList<BestelLijn> bestelLijnArray = new ArrayList<>();
    private static EnumSet<BestellingEvents> bestellingEventsEnumSet = EnumSet.of(BestellingEvents.TOEVOEGEN_BROODJE, BestellingEvents.TOEVOEGEN_BELEG);
    OrderViewPane view;
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
        return bestelFacade.getVoorraadLijstBroodjes(); }

    public Map getVoorraadLijstBeleg() {
        return bestelFacade.getVoorraadLijstBeleg();
    }

    public EnumSet<BestellingEvents> getEvent() {
        return bestellingEventsEnumSet;
    }

    public void getIdentiekeLijn(ArrayList<BestelLijn> identiekArrayList) {
        int grootte = identiekArrayList.size() -1;
        String naamIdentiekBroodje = identiekArrayList.get(grootte).getNaamBroodje();
        String naamIdentiekBeleg = identiekArrayList.get(grootte).getNaamBelegen();
        bestelFacade.voegBestelLijnToe(naamIdentiekBroodje, naamIdentiekBeleg);
    }

    public void verwijderen(ArrayList<BestelLijn> verwijderenArray) {
        int grootte = verwijderenArray.size() -1;
        verwijderenArray.remove(grootte);
        bestelLijnArray = verwijderenArray;
    }

    public void allesVerwijderen() {
        bestelLijnArray.clear();

    }

    public ArrayList<BestelLijn> update(ArrayList<BestelLijn> bestelLijn) {
        bestelLijnArray = bestelLijn;
        return bestelLijnArray;
    }

    public void handleEndOrderButtonClick() {
        // TODO: Price updates should be a part of order state
        view.getSelectedDiscount();


    }
}
