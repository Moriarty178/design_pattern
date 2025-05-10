package bride.pattern.notification.sender;

public class EmailSender implements MessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.println("[EMAIL-SENDER]: " + message);
    }
}
