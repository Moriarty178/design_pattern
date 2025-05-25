package structural_pattern.decorator_pattern.decorator;

import structural_pattern.decorator_pattern.component.Notification;

public class SlackDecorator extends NotificationDecorator { // concrete decorator: implement + add

    public SlackDecorator(Notification wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
        sendSlack();
    }

    public void sendSlack(String message) {
        System.out.println("Sending Slack with message: " + message);
    }

    public void sendSlack() {
        System.out.println("Sending Slack message default.");
    }
}
