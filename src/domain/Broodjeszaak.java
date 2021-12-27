//Brinio 2-12: nieuwe class wat onze broodjeszaak is, hier wordt voor story 1 de broodjes uit het bestand gelezen en in de memory database gezet
//Brinio 15-12: klasse van PG (BroodjesZaakMainReader) hierin verwertk, alles werkt

package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Broodjeszaak {
    //private List<Broodje> data1;
    //private List<Beleg> data2;

    Map<String, Broodje> broodjesMap;
    Map<String, Beleg> belegMap;

    ArrayList<Broodje> broodjes = new ArrayList<Broodje>();
    ArrayList<Beleg> beleggen = new ArrayList<Beleg>();


    public Broodjeszaak() {
        File Mybroodjes = new File("src/bestanden/broodjes.txt");
        File MyBeleggen = new File("src/bestanden/beleg.txt");

        try {
            broodjesMap = new BroodjeReader().load(Mybroodjes);
            broodjes.addAll(broodjesMap.values());

            belegMap = new BelegReader().load(MyBeleggen);
            beleggen.addAll(belegMap.values());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Broodje> getBroodjes() { return broodjes; }
    public ArrayList<Beleg> getBeleg() { return beleggen; }


}
