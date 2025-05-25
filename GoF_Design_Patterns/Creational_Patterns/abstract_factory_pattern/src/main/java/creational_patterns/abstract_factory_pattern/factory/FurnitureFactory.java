package creational_patterns.abstract_factory_pattern.factory;

import creational_patterns.abstract_factory_pattern.product.chair.Chair;
import creational_patterns.abstract_factory_pattern.product.sofa.Sofa;
import creational_patterns.abstract_factory_pattern.product.table.CoffeeTable;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}
