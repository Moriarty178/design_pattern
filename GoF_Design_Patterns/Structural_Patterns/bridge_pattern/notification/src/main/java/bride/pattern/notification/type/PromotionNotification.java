package bride.pattern.notification.type;

import bride.pattern.notification.sender.MessageSender;

public class PromotionNotification extends Notification{
    public PromotionNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String message) {
        sender.sendMessage(message);
    }
}
