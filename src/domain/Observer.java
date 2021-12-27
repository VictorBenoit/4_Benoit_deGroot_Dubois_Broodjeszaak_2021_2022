package domain;

import domain.model.BestelLijn;
import domain.model.BestellingEvents;

import java.util.ArrayList;

public interface Observer {
    public ArrayList<BestelLijn> update(ArrayList<BestelLijn> bestelLijn);
    public BestellingEvents getEvent();
}
