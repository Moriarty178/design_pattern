package behavioral_patterns.observer_pattern_;

import behavioral_patterns.observer_pattern_.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObserverPatternApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObserverPatternApplication.class, args);
		OrderService service = context.getBean(OrderService.class);
		service.createOrder("john@gmail.com");
	}

}
