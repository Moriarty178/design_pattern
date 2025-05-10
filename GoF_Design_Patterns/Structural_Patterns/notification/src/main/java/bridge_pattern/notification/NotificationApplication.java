package bridge_pattern.notification;

import bridge_pattern.notification.sender.EmailSender;
import bridge_pattern.notification.sender.SmsSender;
import bridge_pattern.notification.type.AlertNotification;
import bridge_pattern.notification.type.Notification;
import bridge_pattern.notification.type.PromotionNotification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotificationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Notification alertNotification = new AlertNotification(new EmailSender());
		alertNotification.sendMessage("🟥 Alert notification ");

		Notification promoNotification = new PromotionNotification(new SmsSender());
		promoNotification.sendMessage("🎁 Hello, this is promotion message.");
	}
}
