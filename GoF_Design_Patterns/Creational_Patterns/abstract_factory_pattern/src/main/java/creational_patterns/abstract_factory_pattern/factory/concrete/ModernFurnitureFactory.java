package creational_patterns.abstract_factory_pattern.factory.concrete;

import creational_patterns.abstract_factory_pattern.factory.FurnitureFactory;
import creational_patterns.abstract_factory_pattern.product.chair.Chair;
import creational_patterns.abstract_factory_pattern.product.chair.ModernChair;
import creational_patterns.abstract_factory_pattern.product.sofa.ModernSofa;
import creational_patterns.abstract_factory_pattern.product.sofa.Sofa;
import creational_patterns.abstract_factory_pattern.product.table.CoffeeTable;
import creational_patterns.abstract_factory_pattern.product.table.ModernCoffeeTable;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}
