package domain.model.database;


import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.LoadSaveStrategy;
import domain.model.database.loadSaveStrategies.factory.LoadSaveStrategyFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BroodjesDatabase {
    private String strategy;
    Map<String, Broodje> broodjesMap;
    ArrayList<Broodje> broodjes = new ArrayList<Broodje>();
    LoadSaveStrategy myStrategy;
    Broodje broodje1;
    File file = new File("src/bestanden/broodjes.xls");

    public BroodjesDatabase(String strategy) {
        this.strategy = strategy;
        LoadSaveStrategyFactory factory = new LoadSaveStrategyFactory();

        try {
            myStrategy = factory.createLoadSaveClass(strategy);
            broodjesMap = myStrategy.loadFile();
            broodjes.addAll(broodjesMap.values());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Broodje> getBroodjesMap() {
        return broodjesMap;
    }

    public ArrayList<String> getKeyBroodjes() {
        Set<String> keySet = broodjesMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        return listOfKeys;
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

    public void updateDatabase(String naamBroodje, int amountBroodje) {

        Broodje broodje1 = getBroodje(naamBroodje);
        String name = broodje1.getName();
        Double price = broodje1.getPrice();
        int sales = broodje1.getSales();
        Broodje broodje2 = new Broodje(name, price, amountBroodje, sales);
        broodjesMap.put(naamBroodje, broodje2);

        /*Map<String, Broodje> updateMap = new HashMap<>();
        Set<String> keySet = broodjesMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<Broodje> values = broodjesMap.values();
        ArrayList<Broodje> listOfValues = new ArrayList<Broodje>(values);

        for (String key: keySet) {
            for (Broodje broodje: listOfValues) {
                String name = broodje.getName();
                Double price = broodje.getPrice();
                int amount = broodje.getAmount();
                int sales = broodje.getSales();
                broodje1 = new Broodje(name, price, amount, sales);
            }
            updateMap.put(key, broodje1);
            broodjesMap = updateMap;
        }*/
    }

    public void saveDatabase() {
        myStrategy.writeFile(file, broodjesMap);
    }
}
