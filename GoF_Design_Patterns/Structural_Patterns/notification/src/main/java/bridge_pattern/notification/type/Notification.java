package bridge_pattern.notification.type;

import bridge_pattern.notification.sender.MessageSender;

public abstract class Notification {
    protected MessageSender messageSender;

    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void sendMessage(String message);
}
