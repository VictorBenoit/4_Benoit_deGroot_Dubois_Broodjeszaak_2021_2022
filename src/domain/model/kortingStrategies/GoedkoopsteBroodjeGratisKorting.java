package domain.model.kortingStrategies;

public class GoedkoopsteBroodjeGratisKorting implements KortingStrategy{

    @Override
    public double calculateTotalReduction(double amount) {
        return 0;
    }
}
