package domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BroodjesZaakReaderMain {
    public static void main (String [] args) {


        File Mybroodjes = new File("src/bestanden/broodjes.txt");
        File MyBeleggen = new File("src/bestanden/beleg.txt");

        Map<String, Broodje> broodjesMap;
        Map<String, Beleg> belegMap;

        try {
            broodjesMap = new BroodjeReader().load(Mybroodjes);
            System.out.println(broodjesMap);

            ArrayList<Broodje> broodjes = new ArrayList<Broodje>(broodjesMap.values());

            System.out.println(broodjes);
            System.out.println(broodjes.get(0).getName());
            System.out.println(broodjes.get(0).getAmount());


          belegMap = new BelegReader().load(MyBeleggen);
            System.out.println(belegMap);
            ArrayList<Beleg> beleg = new ArrayList<Beleg>(belegMap.values());
            System.out.println(beleg);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
