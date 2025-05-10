package bridge_pattern.notification.sender;

public class EmailSender implements MessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.printf("[EMAIL SEND]: %s.\n", message);
    }
}
