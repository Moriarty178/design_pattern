package behavioral_patterns.state_pattern;

import behavioral_patterns.state_pattern.states.NewState;
import org.springframework.stereotype.Component;

@Component
public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new NewState(); // default
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void previousState() {
        state.prev(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
