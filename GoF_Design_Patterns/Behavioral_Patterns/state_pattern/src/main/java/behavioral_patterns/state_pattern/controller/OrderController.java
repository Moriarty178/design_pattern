package behavioral_patterns.state_pattern.controller;

import behavioral_patterns.state_pattern.OrderContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderContext context;

    public OrderController(OrderContext context) {
        this.context = context;
    }

    @GetMapping("/status")
    public String status() {
        context.printStatus();
        return "Status printed to console.";
    }

    @PostMapping("/next")
    public String next() {
        context.nextState();
        return "Moved to next state.";
    }

    @PostMapping("/prev")
    public String prev() {
        context.previousState();
        return "Moved to previous state.";
    }
}
