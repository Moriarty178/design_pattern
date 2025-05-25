package creational_patterns.abstract_factory_pattern.client;

import creational_patterns.abstract_factory_pattern.factory.FurnitureFactory;
import creational_patterns.abstract_factory_pattern.product.chair.Chair;
import creational_patterns.abstract_factory_pattern.product.sofa.Sofa;
import creational_patterns.abstract_factory_pattern.product.table.CoffeeTable;

public class Client {
    private Chair chair;
    private Sofa sofa;
    private CoffeeTable coffeeTable;

    public Client(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.coffeeTable = factory.createCoffeeTable();
    }

    public void render() {
        chair.sitOn();
        sofa.lieOn();
        coffeeTable.placeItem("Book");
    }
}
