package domain.model.database.loadSaveStrategies;

import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.utilities.ExcelLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BroodjesExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy<Broodje>{

    File file = new File("src/bestanden/broodjes.xls");

    @Override
    public Map<String, Broodje> loadFile() throws IOException {
        Map<String,  Broodje> broodjes = this.load(file);
        return broodjes;
    }

    @Override
    public Map<String, Broodje> writeFile(File file, Map<String, Broodje> writeMap) {
        ArrayList<ArrayList<String>> writeArrayList = new ArrayList<ArrayList<String> >();

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

                ArrayList<String> broodjeToevoegen = new ArrayList<String>();
                broodjeToevoegen.add(name);
                broodjeToevoegen.add(price);
                broodjeToevoegen.add(amount);
                broodjeToevoegen.add(sales);

                writeArrayList.add(broodjeToevoegen);
            }
        }
        this.write(file, writeArrayList);

        return null;
    }

    @Override
    public Object maakObject() {
        Broodje broodje = new Broodje((String) infoExcel.get(0), new Double(String.valueOf(infoExcel.get(1))), Integer.parseInt(String.valueOf(infoExcel.get(2))), Integer.parseInt(String.valueOf(infoExcel.get(3))));
        return broodje;
    }

    @Override
    public Object getKey() {
        return infoExcel.get(0);
    }

}
