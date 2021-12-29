package domain.model.kortingStrategies;

public class GeenKorting implements KortingStrategy{
    //Roep totaal amount bestelling op

    public GeenKorting() {

    }

    @Override
    public double calculateTotalReduction(double amount) {
        return amount;
    }
}
