package domain.loadSaveStrategies.factory;

import domain.Broodje;
import domain.loadSaveStrategies.*;

import java.util.Locale;

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
