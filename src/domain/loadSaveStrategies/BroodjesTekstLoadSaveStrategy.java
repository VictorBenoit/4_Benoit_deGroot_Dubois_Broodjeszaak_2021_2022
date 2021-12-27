package domain.loadSaveStrategies;

import domain.Broodje;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BroodjesTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy<Broodje>{

    File file = new File("src/bestanden/broodjes.txt");

    public Map<String, Broodje> loadFile() throws IOException {
        Map<String,  Broodje> broodjes = this.load(file);
        return broodjes;
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
