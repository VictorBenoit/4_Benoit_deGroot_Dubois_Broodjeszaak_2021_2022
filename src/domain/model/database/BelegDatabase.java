package domain.model.database;

import domain.model.Beleg;
import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.LoadSaveStrategy;
import domain.model.database.loadSaveStrategies.factory.LoadSaveStrategyFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BelegDatabase {
    private String strategy;
    Map<String, Beleg> belegMap;
    ArrayList<Beleg> beleggen = new ArrayList<Beleg>();
    LoadSaveStrategy myStrategy;
    Beleg beleg1;
    File file = new File("src/bestanden/beleg.xls");

    public BelegDatabase(String strategy) {
        this.strategy = strategy;
        LoadSaveStrategyFactory factory = new LoadSaveStrategyFactory();

        try {
            myStrategy = factory.createLoadSaveClass(strategy);
            belegMap = myStrategy.loadFile();
            beleggen.addAll(belegMap.values());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Beleg> getBelegMap() {
        return belegMap;
    }

    public ArrayList<Beleg> getBeleggenArrayList() {
        return beleggen;
    }

    public ArrayList<String> getKeyBeleg() {
        Set<String> keySet = belegMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        return listOfKeys;
    }

    public Beleg getBeleg(String naamBeleg) { return belegMap.get(naamBeleg); }

    public Map getVoorraadLijstBeleg() {

        Map<String,Integer> voorraadMap = new HashMap<String,Integer>();

        Set<String> keySet = belegMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<Beleg> values = belegMap.values();
        ArrayList<Beleg> listOfValues = new ArrayList<Beleg>(values);

        for (String key: keySet) {
            for (Beleg beleg: listOfValues) {
                voorraadMap.put(key, beleg.getAmount());
            }
        }
        return voorraadMap;
    }

    public void updateDatabase(String naamBeleg, int amountBeleg, int salesBeleg) {

        Beleg beleg1 = getBeleg(naamBeleg);
        String name = beleg1.getName();
        Double price = beleg1.getPrice();
        Beleg beleg2 = new Beleg(name, price, amountBeleg, salesBeleg);
        belegMap.put(naamBeleg, beleg2);
    }

    public void saveDatabase() {
        myStrategy.writeFile(file, belegMap);
    }
}
