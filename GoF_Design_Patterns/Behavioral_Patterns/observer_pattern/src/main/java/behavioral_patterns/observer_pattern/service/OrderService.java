package behavioral_patterns.observer_pattern.service;

import behavioral_patterns.observer_pattern.event.OrderCreatedEvent;
import behavioral_patterns.observer_pattern.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void createOrder(String email, String address) {
        Order order = new Order(UUID.randomUUID().toString(), email, address);
        System.out.println("✅ Đơn hàng đã được tạo: " + order.getId());

        // Gửi sự kện tới tất cả listeners (observers)
        publisher.publishEvent(new OrderCreatedEvent(this, order));
    }
}
