package behavioral_patterns.observer_pattern;

import behavioral_patterns.observer_pattern.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverPatternApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ObserverPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderService.createOrder("tomcruise@gmail.com", "123 Nguyen Trai, Thanh Xuan, Ha Noi");
	}
}
