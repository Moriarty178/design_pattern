package structural_pattern.decorator_pattern.decorator;

import structural_pattern.decorator_pattern.component.Notification;

public class SMSDecorator extends NotificationDecorator { // concrete decorator: implement Decorator + them method

    public SMSDecorator(Notification wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message); //Gửi notification gốc: bọc lớp component concrete (gốc) bởi decorator, để cả cũ + mới"decorator" thì phải giữ super + thêm method decorator
        sendSMS(message); // Gửi thêm qua SMS
    }

    public void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}
