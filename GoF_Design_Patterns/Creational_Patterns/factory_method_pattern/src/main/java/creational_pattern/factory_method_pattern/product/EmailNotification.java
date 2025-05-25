package creational_pattern.factory_method_pattern.product;

public class EmailNotification implements Notification{
    @Override
    public void send(String to, String message) {
        System.out.println("📧 Sending Email to " + to + ": " + message);
    }
}
