package behavioral_patterns.strategy_pattern;

public class Order {
    private double amount;
    private TaxStrategy taxStrategy;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public void checkout() {
        if (taxStrategy == null) {
            throw new IllegalStateException("No TaxStrategy set");
        }

        double tax = taxStrategy.calculateTax(amount);
        double total = amount + tax;

        System.out.println("Amount: $" + amount);
        System.out.println("Tax: $" + tax);
        System.out.println("Total: $" + total);
    }
}
