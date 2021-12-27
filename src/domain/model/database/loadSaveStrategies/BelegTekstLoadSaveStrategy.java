package domain.model.database.loadSaveStrategies;

import domain.model.Beleg;
import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.utilities.TekstLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BelegTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy<Beleg>{

    File file = new File("src/bestanden/beleg.txt");

    @Override
    public Map<String, Beleg> loadFile() throws IOException {
        Map<String, Beleg> beleg = this.load(file);
        return beleg;
    }

    @Override
    public Map<String, Beleg> writeFile(File file, Map<String, Beleg> writeMap) {
        ArrayList<String> writeArrayList = new ArrayList<String>();

        Set<String> keySet = writeMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<Beleg> values = writeMap.values();
        ArrayList<Beleg> listOfValues = new ArrayList<Beleg>(values);

        for (String key: keySet) {
            for (Beleg beleg: listOfValues) {
                String name = beleg.getName();
                String price = String.valueOf(beleg.getPrice());
                String amount = String.valueOf(beleg.getAmount());
                String sales = String.valueOf(beleg.getSales());
                String str = name + "," + price + "," + amount + "," + sales;

                writeArrayList.add(str);
            }
        }
        this.write(file, writeArrayList);

        return null;
    }

    @Override
    public Object maakObject() {
        Beleg beleg = new Beleg(tokens[0], new Double(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return beleg;
    }

    @Override
    public Object getKey() {
        return tokens[0];
    }


}
