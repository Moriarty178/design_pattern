package behavioral_patterns.observer_pattern.event;

import behavioral_patterns.observer_pattern.model.Order;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @EventListener
    public void handleEmail(OrderCreatedEvent event) {
        Order order = event.getOrder();
        System.out.println("📧 Gửi email tới khách hàng: " + order.getCustomerEmail());
    }

    @EventListener
    public void handleShippingNotification(OrderCreatedEvent event) {
        Order order = event.getOrder();
        System.out.println("📦 Gửi thông báo cho bộ phận giao hàng: " + order.getAddress());
    }

    @EventListener
    public void handleLogging(OrderCreatedEvent event) {
        Order order = event.getOrder();
        System.out.println("📝 Ghi log đơn hàng: " + order.getId());
    }
}
