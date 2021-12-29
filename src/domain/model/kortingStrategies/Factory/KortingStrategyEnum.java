package domain.model.kortingStrategies.Factory;

public enum KortingStrategyEnum {
    GEENKORTING("geen korting", "model.kortingStrategies.GeenKorting", 0),
    KORTINGVAN10("10% korting", "model.kortingStrategies.KortingVan10", 0.1),
    GOEDKOOPSTEBROODJEGRATISKORTING("Gratis korting voor goedkoopste broodje", "model.kortingStrategies.GoedkoopsteBroodjeGratisKorting", 1);

    private String description;
    private String classname;
    private double korting;

    KortingStrategyEnum(String description, String classname, double korting) {
        this.description = description;
        this.classname = classname;
        this.korting = korting;
    }

    public String getDescription() {
        return description;
    }

    public String getClassname() {
        return classname;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }


}
