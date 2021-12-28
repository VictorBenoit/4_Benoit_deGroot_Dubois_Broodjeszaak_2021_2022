package domain.model.kortingStrategies.Factory;

import domain.model.kortingStrategies.KortingStrategy;

public class KortingStrategyFactory {
    public static KortingStrategy createKortingStrategyBehaviour (String type){
        KortingStrategyEnum kortingStrategyEnum = KortingStrategyEnum.valueOf(type);
        String classname = kortingStrategyEnum.getClassname();
        KortingStrategy kortingStrategy = null;
        try {
            Class behaviorClass = Class.forName(classname);
            Object kortingStrat = behaviorClass.newInstance();
            kortingStrategy = (KortingStrategy) kortingStrat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kortingStrategy;
    }
}
