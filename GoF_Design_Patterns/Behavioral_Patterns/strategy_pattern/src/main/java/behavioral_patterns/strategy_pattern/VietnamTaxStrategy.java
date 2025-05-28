package behavioral_patterns.strategy_pattern;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VietnamTaxStrategy implements TaxStrategy { // concrete strategy
    @Override
    public double calculateTax(double amount) {
        return new BigDecimal(amount * 0.1).setScale(2, RoundingMode.HALF_UP).doubleValue();//Math.round(amount * 0.10 * 1000.0) / 1000.0;
    }
}
