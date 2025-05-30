package behavioral_patterns.chain_of_responsibility_pattern.handler;

import behavioral_patterns.chain_of_responsibility_pattern.model.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentCheckHandler extends OrderHandler{
    @Override
    protected void process(OrderRequest request) {
        if (!request.isPaymentCompleted()) {
            throw new RuntimeException("Payment not completed.");
        }
        System.out.println("Payment check passed.");
    }
}
