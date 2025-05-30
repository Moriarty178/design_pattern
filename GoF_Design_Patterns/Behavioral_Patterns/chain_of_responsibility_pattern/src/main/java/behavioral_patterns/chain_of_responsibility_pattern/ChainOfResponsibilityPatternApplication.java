package behavioral_patterns.chain_of_responsibility_pattern;

import behavioral_patterns.chain_of_responsibility_pattern.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
public class ChainOfResponsibilityPatternApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChainOfResponsibilityPatternApplication.class, args);
	}

	@Autowired
	private ApplicationContext context;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------");
		Map<String, OrderHandler> beansAvailableToInject = context.getBeansOfType(OrderHandler.class);
		System.out.println("Total beans of OrderHandler available to inject: " + beansAvailableToInject.size());

		beansAvailableToInject.forEach((name, bean) -> {
			System.out.println("Bean name: " + name + ", Class: " + bean.getClass().getName().split("\\.")[bean.getClass().getName().split("\\.").length - 1]);
		});
	}
}
