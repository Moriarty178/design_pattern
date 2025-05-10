package bride.pattern.notification.type;

import bride.pattern.notification.sender.MessageSender;

public class AlertNotification extends Notification{
    public AlertNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String message) {
        sender.sendMessage(message);
    }
}
