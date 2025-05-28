package behavioral_patterns.template_method_pattern;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateMethodPatternApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TemplateMethodPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ReportGenerator report1 = new SalesReportGenerator();
		report1.generateReport();

		System.out.println("------------------------");

		ReportGenerator report2 = new InventoryReportGenerator();
		report2.generateReport();

	}
}
