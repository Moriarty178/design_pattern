package behavioral_patterns.mediator_pattern.controller;

import behavioral_patterns.mediator_pattern.mediator.ChatRoomMediator;
import behavioral_patterns.mediator_pattern.mediator.ChatRoomMediatorImpl;
import behavioral_patterns.mediator_pattern.model.ConcreteUser;
import behavioral_patterns.mediator_pattern.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    @GetMapping("/chat-room")
    public String chatRoom() {
        ChatRoomMediator mediator = new ChatRoomMediatorImpl();

        User john = new ConcreteUser(mediator, "1", "John");
        User harry = new ConcreteUser(mediator, "2", "Harry");
        User hermione = new ConcreteUser(mediator, "3", "Hermione");

        mediator.addUser(john);
        mediator.addUser(harry);
        mediator.addUser(hermione);

        john.send("Hello everyone !!!");
        harry.send("Hi John!");
        return "ChatRoom test.";
    }
}
