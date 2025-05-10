package bride.pattern.notification.sender;

import org.springframework.stereotype.Component;

@Component
public interface MessageSender {
    void sendMessage(String message);
}
