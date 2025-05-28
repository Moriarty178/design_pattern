package behavioral_patterns.strategy_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrategyPatternApplication.class, args);
		Order order1 = new Order(127.0);
		order1.setTaxStrategy(new VietnamTaxStrategy());
		order1.checkout();

		System.out.println("------------------------");

		Order order2 = new Order(247.0);
		order2.setTaxStrategy(new SingaporeTaxStrategy());
		order2.checkout();

		System.out.println("------------------------");

		Order order3 = new Order(365.9);
		order3.setTaxStrategy(new USTaxStrategy());
		order3.checkout();
	}

}
