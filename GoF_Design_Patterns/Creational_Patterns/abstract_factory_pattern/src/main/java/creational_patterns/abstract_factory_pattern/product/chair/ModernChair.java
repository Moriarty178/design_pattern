package creational_patterns.abstract_factory_pattern.product.chair;

public class ModernChair implements  Chair{
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}
