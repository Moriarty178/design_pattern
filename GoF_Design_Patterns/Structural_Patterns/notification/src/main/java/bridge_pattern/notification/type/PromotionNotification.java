package bridge_pattern.notification.type;

import bridge_pattern.notification.sender.MessageSender;

public class PromotionNotification extends Notification{

    public PromotionNotification(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void sendMessage(String message) {
        messageSender.sendMessage(message);
    }
}
