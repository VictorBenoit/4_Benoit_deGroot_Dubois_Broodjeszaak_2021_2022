package domain.model.kortingStrategies;

public class GoedkoopsteBroodjeGratisKorting implements KortingStrategy{
    //Voeg totaalbedrag bestelling toe

    public GoedkoopsteBroodjeGratisKorting() {
    }

    @Override
    public double calculateTotalReduction(int amount) {
        return 0;
    }
}
