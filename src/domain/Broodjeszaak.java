//Brinio 2-12: nieuwe class wat onze broodjeszaak is, hier wordt voor story 1 de broodjes uit het bestand gelezen en in de memory database gezet
//Brinio 15-12: klasse van PG (BroodjesZaakMainReader) hierin verwertk, alles werkt

package domain;

import domain.model.database.BelegDatabase;
import domain.model.database.BroodjesDatabase;
import domain.model.database.loadSaveStrategies.*;
import domain.model.database.loadSaveStrategies.factory.LoadSaveStrategyFactory;
import domain.model.Beleg;
import domain.model.Broodje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Broodjeszaak {
    //private List<Broodje> data1;
    //private List<Beleg> data2;

    /*Map<String, Broodje> broodjesMap;
    Map<String, Beleg> belegMap;

    Map<String, Broodje> broodjesMapE;
    Map<String, Beleg> belegMapE;*/

    ArrayList<Broodje> broodjes = new ArrayList<Broodje>();
    ArrayList<Beleg> beleggen = new ArrayList<Beleg>();

    String strategyBroodjesTekst = "BROODJETEKST";
    String strategyBelegExcel = "BELEGEXCEL";

    BroodjesDatabase broodjesDatabase = new BroodjesDatabase(strategyBroodjesTekst);
    BelegDatabase belegDatabase = new BelegDatabase(strategyBelegExcel);


    public Broodjeszaak() {

    }

    public ArrayList<Broodje> getBroodjes() { return broodjesDatabase.getBroodjesArrayList(); } //is verplaatst naar BroodjesDatabase, dus aanpassen in FX
    public ArrayList<Beleg> getBeleg() { return belegDatabase.getBeleggenArrayList(); } //idem naar BelegDatabase
}
