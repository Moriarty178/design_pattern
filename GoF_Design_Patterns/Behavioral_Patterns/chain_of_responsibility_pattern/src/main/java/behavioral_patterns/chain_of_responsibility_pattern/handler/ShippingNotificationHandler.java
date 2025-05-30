package behavioral_patterns.chain_of_responsibility_pattern.handler;

import behavioral_patterns.chain_of_responsibility_pattern.model.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class ShippingNotificationHandler extends OrderHandler{
    @Override
    protected void process(OrderRequest request) {
        if (!request.isConfirmed()) {
            throw new IllegalStateException("Order not confirmed. Cannot notify shipping.");
        }

        System.out.println("Shipping has been notified for order: " + request.getOrderId());
    }
}
