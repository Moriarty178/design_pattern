package creational_patterns.abstract_factory_pattern;

import creational_patterns.abstract_factory_pattern.client.Client;
import creational_patterns.abstract_factory_pattern.factory.FurnitureFactory;
import creational_patterns.abstract_factory_pattern.factory.concrete.ModernFurnitureFactory;
import creational_patterns.abstract_factory_pattern.factory.concrete.VictorianFurnitureFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbstractFactoryPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbstractFactoryPatternApplication.class, args);

		FurnitureFactory factory = new VictorianFurnitureFactory();
		System.out.println("============");
		Client client = new Client(factory);
		client.render();
	}

}
