package domain.model.database.loadSaveStrategies.utilities;

import domain.model.Broodje;
import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public abstract class ExcelLoadSaveTemplate<K,V> {

    ExcelPlugin excel = new ExcelPlugin();
    ArrayList<ArrayList<String>> returnExcel = new ArrayList<ArrayList<String>>();
    protected ArrayList<String> infoExcel = new ArrayList<String>();

    public Map<K,V> load(File file) throws IOException{
        Map<K,V> returnExcelMap = new HashMap<K,V>();
        try {
            returnExcel = excel.read(file);
            for (int i = 0; i < returnExcel.size(); i++) {
                infoExcel = returnExcel.get(i);
                V element = maakObject();
                K key = getKey();
                returnExcelMap.put(key, element);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return returnExcelMap;
    }

    public abstract V maakObject();

    public abstract K getKey();

    public void write(File file, ArrayList<ArrayList<String> > writeArrayList) {

        try {
            excel.write(file, writeArrayList);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

}
