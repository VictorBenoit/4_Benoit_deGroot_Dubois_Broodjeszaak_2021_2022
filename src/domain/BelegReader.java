package domain;

public class BelegReader extends TekstLoadSaveTemplate {
    @Override
    protected Beleg maakObject(String[] tokens) {
        Beleg beleg= new Beleg(tokens[0],new Double(tokens[1]) ,Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return beleg;
    }



    protected String getKey(String[] tokens){
        return tokens[0];
    }
}
