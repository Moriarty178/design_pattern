package structural_pattern.decorator_pattern.decorator;

import structural_pattern.decorator_pattern.component.Notification;

public abstract class NotificationDecorator implements Notification { // Abstract Decorator
    protected Notification wrapped; // duy tri tham chieu của Component

    public NotificationDecorator(Notification wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
    }
}
