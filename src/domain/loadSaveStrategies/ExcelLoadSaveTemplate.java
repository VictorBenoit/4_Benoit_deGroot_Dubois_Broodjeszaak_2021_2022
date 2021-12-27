package domain.loadSaveStrategies;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ExcelLoadSaveTemplate<K,V> {

    ExcelPlugin excel = new ExcelPlugin();
    ArrayList<ArrayList<String>> returnExcel = new ArrayList<ArrayList<String>>();
    ArrayList<String> infoExcel = new ArrayList<String>();

    public Map<K,V> load(File file) throws IOException{
        Map<K,V> returnExcelMap = new HashMap<K,V>();
        try {
            returnExcel = excel.read(file);
            for (int i = 0; i < returnExcel.size(); i++) {
                infoExcel = returnExcel.get(i);
                System.out.println(infoExcel);
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

}
