package behavioral_patterns.chain_of_responsibility_pattern.handler;

import behavioral_patterns.chain_of_responsibility_pattern.model.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class InventoryCheckHandler extends OrderHandler{
    @Override
    public void process(OrderRequest request) {
        if (!request.isInventoryAvailable()) {
            throw new RuntimeException("Inventory not available!");
        }
        System.out.println("Inventory check passed.");
    }
}
