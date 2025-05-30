package behavioral_patterns.mediator_pattern.model;

import behavioral_patterns.mediator_pattern.mediator.ChatRoomMediator;

public abstract class User {
    protected ChatRoomMediator mediator;
    protected String id;
    protected String name;

    public User(ChatRoomMediator mediator, String id, String name) {
        this.mediator = mediator;
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}
