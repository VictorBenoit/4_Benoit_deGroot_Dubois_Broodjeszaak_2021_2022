package domain;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class ExcelLoadSaveTemplate extends ExcelPlugin {

    @Override
    public void write(File file, ArrayList<ArrayList<String>> args) throws BiffException, IOException, WriteException {
        super.write(file, args);
    }

    @Override
    public ArrayList<ArrayList<String>> read(File file) throws BiffException, IOException {
        return super.read(file);
    }
}
