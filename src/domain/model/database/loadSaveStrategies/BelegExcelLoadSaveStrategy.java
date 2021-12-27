package domain.model.database.loadSaveStrategies;

import domain.model.Beleg;
import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.utilities.ExcelLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BelegExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy<Beleg>{

    File file = new File("src/bestanden/beleg.xls");

    @Override
    public Map<String, Beleg> loadFile() throws IOException {
        Map<String, Beleg> beleg = this.load(file);
        return beleg;
    }

    @Override
    public Map<String, Beleg> writeFile(File file, Map<String, Beleg> writeMap) {

        ArrayList<ArrayList<String>> writeArrayList = new ArrayList<ArrayList<String> >();

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

                ArrayList<String> belegToevoegen = new ArrayList<String>();
                belegToevoegen.add(name);
                belegToevoegen.add(price);
                belegToevoegen.add(amount);
                belegToevoegen.add(sales);

                writeArrayList.add(belegToevoegen);
            }
        }
        this.write(file, writeArrayList);

        return null;
    }

    @Override
    public Object maakObject() {
        Beleg beleg = new Beleg((String) infoExcel.get(0), new Double(String.valueOf(infoExcel.get(1))), Integer.parseInt(String.valueOf(infoExcel.get(2))), Integer.parseInt(String.valueOf(infoExcel.get(3))));
        return beleg;
    }

    @Override
    public Object getKey() {
        return infoExcel.get(0);
    }
}
