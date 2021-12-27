package domain.model.database.loadSaveStrategies;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface LoadSaveStrategy<Soort>{

    public Object maakObject();
    public Object getKey();
    public Map<String, Soort> loadFile() throws IOException;
    public Map<String, Soort> writeFile(File file, Map<String,Soort> writeMap);
}
