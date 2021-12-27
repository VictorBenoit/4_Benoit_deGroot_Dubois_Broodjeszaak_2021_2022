package domain.model.database;


import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.LoadSaveStrategy;
import domain.model.database.loadSaveStrategies.factory.LoadSaveStrategyFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
}
