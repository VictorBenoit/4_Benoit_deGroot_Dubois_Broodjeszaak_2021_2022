package domain.model.database.loadSaveStrategies;

import domain.model.Broodje;
import domain.model.database.loadSaveStrategies.utilities.ExcelLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BroodjesExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy<Broodje>{

    File file = new File("src/bestanden/broodjes.xls");

    @Override
    public Map<String, Broodje> loadFile() throws IOException {
        Map<String,  Broodje> broodjes = this.load(file);
        return broodjes;
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
