package domain.model.database.loadSaveStrategies;

import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.utilities.TekstLoadSaveTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BroodjesTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy<Broodje>{

    File file = new File("src/bestanden/broodjes.txt");

    public Map<String, Broodje> loadFile() throws IOException {
        Map<String,  Broodje> broodjes = this.load(file);
        return broodjes;
    }

    @Override
    public Map<String, Broodje> writeFile(File file, Map<String, Broodje> writeMap) {

        ArrayList<String> writeArrayList = new ArrayList<String>();

        Set<String> keySet = writeMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<Broodje> values = writeMap.values();
        ArrayList<Broodje> listOfValues = new ArrayList<Broodje>(values);

        for (String key: keySet) {
            for (Broodje broodje: listOfValues) {
                String name = broodje.getName();
                String price = String.valueOf(broodje.getPrice());
                String amount = String.valueOf(broodje.getAmount());
                String sales = String.valueOf(broodje.getSales());
                String str = name + "," + price + "," + amount + "," + sales;

                writeArrayList.add(str);
            }
        }
        this.write(file, writeArrayList);

        return null;
    }

    @Override
    public Broodje maakObject() {
        Broodje broodje = new Broodje(tokens[0], new Double(tokens[1]),Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return broodje;
    }

    public String getKey(){
        return tokens[0];
    }

}
