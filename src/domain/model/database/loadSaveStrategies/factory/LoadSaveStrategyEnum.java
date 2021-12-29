package domain.model.database.loadSaveStrategies.factory;

public enum LoadSaveStrategyEnum {

    BROODJETEKST("BroodjesTekstLoadSaveStrategy"),
    BROODJEEXCEL("BroodjesExcelLoadSaveStrategy"),
    BELEGTEKST("BelegTekstLoadSaveStrategy"),
    BELEGEXCEL("BelegExcelLoadSaveStrategy");


    private final String klasseNaam;

    LoadSaveStrategyEnum(String klasseNaam){
        this.klasseNaam = klasseNaam;
    }

    public String getKlasseNaam() {
        return "domain.model.database.loadSaveStrategies." + klasseNaam; }
}
