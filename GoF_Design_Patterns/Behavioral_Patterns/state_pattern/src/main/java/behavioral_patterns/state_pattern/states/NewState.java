package behavioral_patterns.state_pattern.states;

import behavioral_patterns.state_pattern.OrderContext;
import behavioral_patterns.state_pattern.OrderState;

public class NewState implements OrderState {

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new PaidState());
    }

    @Override
    public void prev(OrderContext ctx) {
        System.out.println("New Order. No previous state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order is NEW.");
    }

}
