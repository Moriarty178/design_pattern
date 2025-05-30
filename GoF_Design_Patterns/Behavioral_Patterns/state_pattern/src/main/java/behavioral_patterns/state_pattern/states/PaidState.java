package behavioral_patterns.state_pattern.states;

import behavioral_patterns.state_pattern.OrderContext;
import behavioral_patterns.state_pattern.OrderState;

public class PaidState implements OrderState {

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void prev(OrderContext ctx) {
        ctx.setState(new NewState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order has been PAID.");
    }
}
