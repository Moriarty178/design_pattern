package behavioral_patterns.chain_of_responsibility_pattern.handler;

import behavioral_patterns.chain_of_responsibility_pattern.model.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderConfirmHandler extends OrderHandler{
    @Override
    public void process(OrderRequest request) {
        if (!request.isInventoryAvailable() || !request.isPaymentCompleted()) {
            throw new IllegalStateException("Order cannot be confirmed before inventory and payment are checked.");
        }

        request.setConfirmed(true);
        System.out.println("Order confirmed successfully.");
    }
}
