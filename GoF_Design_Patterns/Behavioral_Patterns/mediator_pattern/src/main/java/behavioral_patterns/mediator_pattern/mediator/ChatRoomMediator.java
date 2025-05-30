package behavioral_patterns.mediator_pattern.mediator;

import behavioral_patterns.mediator_pattern.model.User;

public interface ChatRoomMediator {
    void sendMessage(String msg, String userId);
    void addUser(User user);
}
