package domain.model.database.loadSaveStrategies.factory;

import domain.model.database.loadSaveStrategies.*;

public class LoadSaveStrategyFactory {

    public static LoadSaveStrategy createLoadSaveClass(String type) {

        LoadSaveStrategyEnum strategyEnum = LoadSaveStrategyEnum.valueOf(type);
        String klassenaam = strategyEnum.getKlasseNaam();

        LoadSaveStrategy loadSave = null;
        try {
            Class<?> loadSaveKlasse = Class.forName(klassenaam);
            loadSave = (LoadSaveStrategy) loadSaveKlasse.newInstance();
        } catch (Exception e) {
        }
        return loadSave;
    }
}
