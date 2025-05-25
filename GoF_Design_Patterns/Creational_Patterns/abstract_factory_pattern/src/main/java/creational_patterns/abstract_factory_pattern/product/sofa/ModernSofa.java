package creational_patterns.abstract_factory_pattern.product.sofa;

public class ModernSofa implements Sofa{
    @Override
    public void lieOn() {
        System.out.println("Lying on a modern sofa.");
    }
}
