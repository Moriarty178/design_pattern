package creational_pattern.factory_method_pattern.creator;

import creational_pattern.factory_method_pattern.product.Notification;
import creational_pattern.factory_method_pattern.type.NotificationType;

public interface NotificationFactory {
    Notification createNotification(NotificationType type);
}
