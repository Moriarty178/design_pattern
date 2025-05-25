package creational_pattern.factory_method_pattern.service;

import creational_pattern.factory_method_pattern.creator.NotificationFactory;
import creational_pattern.factory_method_pattern.product.Notification;
import creational_pattern.factory_method_pattern.type.NotificationType;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void notifyUser(NotificationType type, String to, String message) {
        Notification notification = notificationFactory.createNotification(type);
        notification.send(to, message);
    }
}
