package bride.pattern.notification;

import bride.pattern.notification.sender.EmailSender;
import bride.pattern.notification.sender.SmsSender;
import bride.pattern.notification.type.AlertNotification;
import bride.pattern.notification.type.Notification;
import bride.pattern.notification.type.PromotionNotification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Notification alert = new AlertNotification(new EmailSender());
		alert.sendMessage("🛑 Alert notification!");

		Notification promo = new PromotionNotification(new SmsSender());
		promo.sendMessage("🎁 Promotion notification.");
	}
}
