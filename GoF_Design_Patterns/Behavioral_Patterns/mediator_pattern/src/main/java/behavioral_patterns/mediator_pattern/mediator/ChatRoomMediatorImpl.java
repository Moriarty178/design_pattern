package behavioral_patterns.mediator_pattern.mediator;

import behavioral_patterns.mediator_pattern.model.User;

import java.util.HashMap;
import java.util.Map;

public class ChatRoomMediatorImpl implements ChatRoomMediator {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void sendMessage(String msg, String userId) {
        for (User user : users.values()) {
            // Gửi cho tất cả trừ người guửi
            if (!user.getId().equals(userId)) {
                user.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }
}
