package domain;

import domain.model.BestelLijn;
import domain.model.BestellingEvents;

import java.util.ArrayList;
import java.util.EnumSet;

public interface Observer {
    public ArrayList<BestelLijn> update(ArrayList<BestelLijn> bestelLijn);
    public EnumSet<BestellingEvents> getEvent();
}
