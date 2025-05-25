package creational_patterns.abstract_factory_pattern.product.chair;

public class VictorianChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Sitting on a victorian chair.");
    }
}
