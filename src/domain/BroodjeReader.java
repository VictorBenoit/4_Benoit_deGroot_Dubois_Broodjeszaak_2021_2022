package domain;

public class BroodjeReader extends TekstLoadSaveTemplate {
    @Override
    protected Broodje maakObject(String[] tokens) {
        Broodje broodje = new Broodje(tokens[0], new Double(tokens[1]),Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return broodje;
    }

    protected String getKey(String[] tokens){
        return tokens[0];
    }
}
