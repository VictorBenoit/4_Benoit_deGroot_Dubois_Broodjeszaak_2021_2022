package domain.loadSaveStrategies;

import domain.Broodje;

import java.io.IOException;
import java.util.Map;

public interface LoadSaveStrategy<Soort>{

    public Object maakObject();
    public Object getKey();
    public Map<String, Soort> loadFile() throws IOException;
}
