package domain.model.database;

import domain.model.Beleg;
import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.LoadSaveStrategy;
import domain.model.database.loadSaveStrategies.factory.LoadSaveStrategyFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class BelegDatabase {
    private String strategy;
    Map<String, Beleg> belegMap;
    ArrayList<Beleg> beleggen = new ArrayList<Beleg>();

    public BelegDatabase(String strategy) {
        this.strategy = strategy;
        LoadSaveStrategyFactory factory = new LoadSaveStrategyFactory();

        try {
            LoadSaveStrategy myStrategy = factory.createLoadSaveClass(strategy);
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
}
