package behavioral_patterns.chain_of_responsibility_pattern.handler;

import behavioral_patterns.chain_of_responsibility_pattern.model.OrderRequest;

public abstract class OrderHandler {
    protected OrderHandler next;

    public OrderHandler setNex(OrderHandler next) {
        this.next = next;
        return next;
    }

    public void handle(OrderRequest request) {
        process(request);
        if (next != null) {
            next.handle(request);
        }
    }

    protected abstract void process(OrderRequest request);
}
