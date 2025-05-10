package bride.pattern.notification.sender;

public class SmsSender implements MessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.println("[SMS-SENDER]: " + message);
    }
}
