package domain.model.database.loadSaveStrategies;

import domain.model.Beleg;
import domain.model.database.loadSaveStrategies.utilities.ExcelLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BelegExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy<Beleg>{

    File file = new File("src/bestanden/beleg.xls");

    @Override
    public Map<String, Beleg> loadFile() throws IOException {
        Map<String, Beleg> beleg = this.load(file);
        return beleg;
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
