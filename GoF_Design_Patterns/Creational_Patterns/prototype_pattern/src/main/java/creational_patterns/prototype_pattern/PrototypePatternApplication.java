package creational_patterns.prototype_pattern;

import creational_patterns.prototype_pattern.model.Contract;
import creational_patterns.prototype_pattern.service.ContractService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypePatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypePatternApplication.class, args);

		ContractService service = new ContractService();
		Contract contract1 = service.createContractFor("Alice");
		Contract contract2 = service.createContractFor("Bob");
		Contract contract3 = service.createContractFor("Charlie");

		contract1.print();
		contract2.print();
		contract3.print();
	}

}
