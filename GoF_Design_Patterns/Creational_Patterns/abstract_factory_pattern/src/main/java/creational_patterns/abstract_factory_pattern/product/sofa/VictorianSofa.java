package creational_patterns.abstract_factory_pattern.product.sofa;

public class VictorianSofa implements Sofa{
    @Override
    public void lieOn() {
        System.out.println("Lying on a victorian sofa.");
    }
}
