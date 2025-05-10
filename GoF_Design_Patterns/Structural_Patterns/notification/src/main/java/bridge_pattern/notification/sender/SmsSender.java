package bridge_pattern.notification.sender;

public class SmsSender implements MessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.println("[SMS SEND]: " + message);
    }
}
