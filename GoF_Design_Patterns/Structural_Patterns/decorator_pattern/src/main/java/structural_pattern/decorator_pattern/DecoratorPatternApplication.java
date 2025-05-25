package structural_pattern.decorator_pattern;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import structural_pattern.decorator_pattern.component.EmailNotification;
import structural_pattern.decorator_pattern.component.Notification;
import structural_pattern.decorator_pattern.decorator.SMSDecorator;
import structural_pattern.decorator_pattern.decorator.SlackDecorator;

@SpringBootApplication
public class DecoratorPatternApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DecoratorPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Send Email + SMS(wrapper email)
		Notification notification1 = new SMSDecorator(new EmailNotification());
		notification1.send("🟥 Server down!");

		System.out.println("---");

		// Send Email + Slack + SMS
		Notification notification2 = new SMSDecorator(
										new SlackDecorator(
											new EmailNotification()));
		notification2.send("🔼 Server started!");
	}
}
