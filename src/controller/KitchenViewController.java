package controller;

import domain.Observer;
import domain.model.BestelFacade;
import domain.model.BestelLijn;
import domain.model.BestellingEvents;

import java.util.ArrayList;
import java.util.EnumSet;

public class KitchenViewController implements Observer {
    BestelFacade bestelFacade = new BestelFacade();
    ArrayList<BestelLijn> bestelLijnArray = new ArrayList<>();
    private static EnumSet<BestellingEvents> bestellingEventsEnumSet = EnumSet.of(BestellingEvents.TOEVOEGEN_BROODJE, BestellingEvents.TOEVOEGEN_BELEG);

    public KitchenViewController() {
        this.bestelFacade = bestelFacade;
    }

    @Override
    public ArrayList<BestelLijn> update(ArrayList<BestelLijn> bestelLijn) {
        bestelLijnArray = bestelLijn;
        return bestelLijnArray;
    }

    @Override
    public EnumSet<BestellingEvents> getEvent() {
        return bestellingEventsEnumSet;
    }
}
