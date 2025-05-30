package behavioral_patterns.state_pattern.states;

import behavioral_patterns.state_pattern.OrderContext;
import behavioral_patterns.state_pattern.OrderState;

public class ShippedState implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new DeliveredState());
    }

    @Override
    public void prev(OrderContext ctx) {
        ctx.setState(new PaidState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is SHIPPED.");
    }
}
