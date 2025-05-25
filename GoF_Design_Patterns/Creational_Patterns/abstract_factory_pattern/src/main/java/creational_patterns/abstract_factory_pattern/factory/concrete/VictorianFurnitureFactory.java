package creational_patterns.abstract_factory_pattern.factory.concrete;

import creational_patterns.abstract_factory_pattern.factory.FurnitureFactory;
import creational_patterns.abstract_factory_pattern.product.chair.Chair;
import creational_patterns.abstract_factory_pattern.product.chair.VictorianChair;
import creational_patterns.abstract_factory_pattern.product.sofa.Sofa;
import creational_patterns.abstract_factory_pattern.product.sofa.VictorianSofa;
import creational_patterns.abstract_factory_pattern.product.table.CoffeeTable;
import creational_patterns.abstract_factory_pattern.product.table.VictorianCoffeeTable;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}
