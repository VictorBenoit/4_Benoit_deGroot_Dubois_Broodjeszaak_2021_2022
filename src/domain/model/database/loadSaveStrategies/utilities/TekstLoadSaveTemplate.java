package domain.model.database.loadSaveStrategies.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class TekstLoadSaveTemplate<K,V> {

    protected String[] tokens = new String[4];

    public Map<K,V> load(File file) throws IOException {
        Map<K,V> returnMap = new HashMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                tokens = line.split(",");
                V element = maakObject();
                K key = getKey();
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    public abstract V maakObject();

    public abstract K getKey();

    public void write(File file, ArrayList<String> writeArrayList) {
        try {
            FileWriter myWritter = new FileWriter(file);

            for (String str : writeArrayList) {
                myWritter.write(str);
            }
            myWritter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
