package behavioral_patterns.state_pattern;

public interface OrderState {
    void next(OrderContext ctx);
    void prev(OrderContext ctx);
    void printStatus();
}
