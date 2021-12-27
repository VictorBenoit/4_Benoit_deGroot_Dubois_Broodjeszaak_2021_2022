package domain.loadSaveStrategies;

import domain.Beleg;
import domain.Broodje;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BelegTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy<Beleg>{

    File file = new File("src/bestanden/beleg.txt");

    @Override
    public Map<String, Beleg> loadFile() throws IOException {
        Map<String, Beleg> beleg = this.load(file);
        return beleg;
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
