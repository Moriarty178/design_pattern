package behavioral_patterns.chain_of_responsibility_pattern.controller;

import behavioral_patterns.chain_of_responsibility_pattern.handler.OrderHandler;
import behavioral_patterns.chain_of_responsibility_pattern.model.OrderRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderHandler orderHandler;

    public OrderController(@Qualifier("orderProcessingChain") OrderHandler orderHandler) {
        this.orderHandler = orderHandler;
    }

    @PostMapping("/process")
    public String processOrder(@RequestBody OrderRequest request) {
        orderHandler.handle(request);
        return "Order processed: " + ((request.isConfirmed()) ? "CONFIRMED" : "FAILED");
    }
}
