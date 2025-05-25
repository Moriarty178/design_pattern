package structural_pattern.decorator_pattern.component;

public class EmailNotification implements Notification{ // concrete component
    @Override
    public void send(String message) {
        System.out.println("Sending Email with message: " + message);
    }
}
