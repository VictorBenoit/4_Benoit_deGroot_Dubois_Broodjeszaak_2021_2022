package domain.model.kortingStrategies;

import domain.model.BestelLijn;

public class KortingVan10 implements KortingStrategy {
    //deze moet totaal prijs broodje zijn.





    @Override
    public double calculateTotalReduction(double amount) {
        return amount*0.1;
    }
}
