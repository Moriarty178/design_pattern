package behavioral_patterns.strategy_pattern;

public class SingaporeTaxStrategy implements TaxStrategy { // concrete strategy
    @Override
    public double calculateTax(double amount) {
        return Math.round(amount * 0.27 * 1000.0) / 1000.0;
    }
}
