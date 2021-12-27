package domain.model.database;


import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.LoadSaveStrategy;
import domain.model.database.loadSaveStrategies.factory.LoadSaveStrategyFactory;

import java.io.IOException;
import java.util.*;

public class BroodjesDatabase {
    private String strategy;
    Map<String, Broodje> broodjesMap;
    ArrayList<Broodje> broodjes = new ArrayList<Broodje>();

    public BroodjesDatabase(String strategy) {
        this.strategy = strategy;
        LoadSaveStrategyFactory factory = new LoadSaveStrategyFactory();

        try {
            LoadSaveStrategy myStrategy = factory.createLoadSaveClass(strategy);
            broodjesMap = myStrategy.loadFile();
            broodjes.addAll(broodjesMap.values());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Broodje> getBroodjesMap() {
        return broodjesMap;
    }

    public ArrayList<Broodje> getBroodjesArrayList() {
        return broodjes;
    }

    public Broodje getBroodje(String naamBroodje) {
        return broodjesMap.get(naamBroodje);
    }

    public Map getVoorraadLijstBroodjes() {

        Map<String,Integer> voorraadMap = new HashMap<String,Integer>();

        Set<String> keySet = broodjesMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<Broodje> values = broodjesMap.values();
        ArrayList<Broodje> listOfValues = new ArrayList<Broodje>(values);

        for (String key: keySet) {
            for (Broodje broodje: listOfValues) {
            voorraadMap.put(key, broodje.getAmount());
        }
    }
        return voorraadMap;
    }
}
