package creational_pattern.factory_method_pattern.creator;

import creational_pattern.factory_method_pattern.product.EmailNotification;
import creational_pattern.factory_method_pattern.product.Notification;
import creational_pattern.factory_method_pattern.product.PushNotification;
import creational_pattern.factory_method_pattern.product.SmsNotification;
import creational_pattern.factory_method_pattern.type.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactoryImpl implements NotificationFactory{
    @Override
    public Notification createNotification(NotificationType type) {
        return switch (type) {
            case SMS -> new SmsNotification();
            case EMAIL -> new EmailNotification();
            case PUSH -> new PushNotification();
        };
    }
}
