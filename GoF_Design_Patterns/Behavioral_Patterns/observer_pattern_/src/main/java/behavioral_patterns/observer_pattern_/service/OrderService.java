package behavioral_patterns.observer_pattern_.service;

import behavioral_patterns.observer_pattern_.event.OrderCreatedEvent;
import behavioral_patterns.observer_pattern_.observer.OrderCreatedSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderCreatedSubject orderCreatedSubject;

    public void createOrder(String email) {
        String orderId = UUID.randomUUID().toString();
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, email, "Ha Noi");
        System.out.println("🛒 Order created: " + orderId);

        // Notify all observers
        orderCreatedSubject.notifyObservers(event);
    }
}
