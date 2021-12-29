package domain.model.kortingStrategies.Factory;

import domain.model.kortingStrategies.GeenKorting;
import domain.model.kortingStrategies.GoedkoopsteBroodjeGratisKorting;
import domain.model.kortingStrategies.KortingStrategy;
import domain.model.kortingStrategies.KortingVan10;

public class KortingStrategyFactory {
    public static KortingStrategy createDiscount(String kortingtype) {
        KortingStrategyEnum kortingStrategyEnum;
        KortingStrategy korting;
        if (kortingtype == null) {
            return null;
        }
        if (kortingtype.equals("Gratis korting voor goedkoopste broodje")) {
            return new GoedkoopsteBroodjeGratisKorting();
        }
        if (kortingtype.equals("geen korting")) {
            return new GeenKorting();
        }
        if (kortingtype.equals("10% korting")) {
            return new KortingVan10();
        }
        return null;
    }
}
