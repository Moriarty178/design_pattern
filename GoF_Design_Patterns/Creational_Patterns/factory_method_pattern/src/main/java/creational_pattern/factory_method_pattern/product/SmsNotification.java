package creational_pattern.factory_method_pattern.product;

public class SmsNotification implements Notification{
    @Override
    public void send(String to, String message) {
        System.out.println("📲 Sending SMS to " + to + ": " + message);
    }
}
