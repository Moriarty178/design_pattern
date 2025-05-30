package behavioral_patterns.mediator_pattern.model;

import behavioral_patterns.mediator_pattern.mediator.ChatRoomMediator;

public class ConcreteUser extends User {
    public ConcreteUser(ChatRoomMediator mediator, String id, String name) {
        super(mediator, id, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + " gửi: " + msg);
        mediator.sendMessage(msg, this.id);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " nhận: " + msg);
    }
}
