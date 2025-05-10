package bride.pattern.notification.type;

import bride.pattern.notification.sender.MessageSender;

public abstract class Notification {
    protected MessageSender sender;

    public Notification(MessageSender sender) {
        this.sender = sender;
    }

    public abstract void sendMessage(String message);
}
