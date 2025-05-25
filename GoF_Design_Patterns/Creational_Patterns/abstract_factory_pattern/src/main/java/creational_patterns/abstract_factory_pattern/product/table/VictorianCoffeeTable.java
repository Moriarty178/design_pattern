package creational_patterns.abstract_factory_pattern.product.table;

public class VictorianCoffeeTable implements CoffeeTable{
    @Override
    public void placeItem(String item) {
        System.out.println("Placed " + item + " on a victorian coffee table.");
    }
}
