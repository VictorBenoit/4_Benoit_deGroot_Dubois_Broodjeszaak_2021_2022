//Brinio: nieuwe class wat onze broodjeszaak is, hier wordt voor story 1 de broodjes uit het bestand gelezen en in de memory database gezet


package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Broodjeszaak {
    private List<Broodje> data1;
    private List<Beleg> data2;

    public Broodjeszaak() {
        //Brinio: 2 arraylisten waar de broodjes en beleg dat je kan kopen wordt opgeslagen

        data1 = new ArrayList<Broodje>();
        data2 = new ArrayList<Beleg>();

        //Brinio: scanner voor het inlezen van het bestand broodjes.txt

        try {
            File Mybroodjes = new File("src/bestanden/broodjes.txt");
            Scanner broodjesReader = new Scanner(Mybroodjes);
            while (broodjesReader.hasNextLine()) {
                String line = broodjesReader.nextLine();
                String[] dataBroodjes = line.split(",");
                if(dataBroodjes.length == 4) {
                    String name = dataBroodjes[0];
                    Double price = Double.parseDouble(dataBroodjes[1]);
                    Integer amount = Integer.parseInt(dataBroodjes[2]);
                    Integer sales = Integer.parseInt(dataBroodjes[3]);
                    data1.add(new Broodje(name, price, amount, sales));
                }
            }
            broodjesReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }

        try {
            File MyBeleggen = new File("src/bestanden/beleg.txt");
            Scanner beleggenReader = new Scanner(MyBeleggen);
            while (beleggenReader.hasNextLine()) {
                String line = beleggenReader.nextLine();
                String[] dataBeleggen = line.split(",");
                if(dataBeleggen.length == 4) {
                    String name = dataBeleggen[0];
                    Double price = Double.parseDouble(dataBeleggen[1]);
                    Integer amount = Integer.parseInt(dataBeleggen[2]);
                    Integer sales = Integer.parseInt(dataBeleggen[3]);
                    data2.add(new Beleg(name, price, amount, sales));
                }
            }
            beleggenReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }

    public List<Broodje> getBroodjes() { return data1; }

    public List<Beleg> getBeleggen() { return data2; }
}
