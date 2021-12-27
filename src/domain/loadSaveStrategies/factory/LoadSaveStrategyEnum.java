package domain.loadSaveStrategies.factory;

public enum LoadSaveStrategyEnum {

    BROODJETEKST("BroodjesTekstLoadSaveStrategy"),
    BROODJEEXCEL("BroodjesTekstLoadSaveStrategy"),
    BELEGTEKST("BelegTekstLoadSaveStrategy"),
    BELEGEXCEL("BelegExcelLoadSaveStrategy");


    private final String klasseNaam;

    LoadSaveStrategyEnum(String klasseNaam){
        this.klasseNaam = klasseNaam;
    }

    public String getKlasseNaam() {
        return "domain.loadSaveStrategies." + klasseNaam; }
}
