package domain.model.kortingStrategies;

import domain.model.BestelLijn;

public class KortingVan10 implements KortingStrategy {
    //deze moet totaal prijs broodje zijn.
    private double bedrag = 0;
    private double korting = 0.1;

    public KortingVan10(int bedrag, int korting) {
        this.bedrag = bedrag;
        this.korting = korting;

    }


    @Override
    public double calculateTotalReduction(int amount) {
        return bedrag*korting;
    }
}
