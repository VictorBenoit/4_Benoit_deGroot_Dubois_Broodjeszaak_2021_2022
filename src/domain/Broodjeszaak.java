//Brinio 2-12: nieuwe class wat onze broodjeszaak is, hier wordt voor story 1 de broodjes uit het bestand gelezen en in de memory database gezet
//Brinio 15-12: klasse van PG (BroodjesZaakMainReader) hierin verwertk, alles werkt

package domain;

import domain.loadSaveStrategies.*;
import domain.loadSaveStrategies.factory.LoadSaveStrategyFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Broodjeszaak {
    //private List<Broodje> data1;
    //private List<Beleg> data2;

    /*Map<String, Broodje> broodjesMap;
    Map<String, Broodje> broodjesMapA;
    Map<String, Beleg> belegMap;

    Map<String, Broodje> broodjesMapE;
    Map<String, Beleg> belegMapE;*/

    ArrayList<Broodje> broodjes = new ArrayList<Broodje>();
    ArrayList<Beleg> beleggen = new ArrayList<Beleg>();


    public Broodjeszaak() {
        /*File Mybroodjes = new File("src/bestanden/broodjes.txt");
        File MyBeleggen = new File("src/bestanden/beleg.txt");
        File MybroodjesE = new File("src/bestanden/broodjes.xls");
        File MyBeleggenE = new File("src/bestanden/beleg.xls");*/

        LoadSaveStrategyFactory factory = new LoadSaveStrategyFactory();
        String strategy = "BROODJETEKST";

        try {

            LoadSaveStrategy myStrategy = factory.createLoadSaveClass(strategy);
            if (myStrategy instanceof BroodjesExcelLoadSaveStrategy || myStrategy instanceof BroodjesTekstLoadSaveStrategy) {
                broodjes.addAll(myStrategy.loadFile().values());
            }
            if (myStrategy instanceof BelegExcelLoadSaveStrategy || myStrategy instanceof BelegTekstLoadSaveStrategy) {
                beleggen.addAll(myStrategy.loadFile().values());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Broodje> getBroodjes() { return broodjes; }
    public ArrayList<Beleg> getBeleg() { return beleggen; }
}
