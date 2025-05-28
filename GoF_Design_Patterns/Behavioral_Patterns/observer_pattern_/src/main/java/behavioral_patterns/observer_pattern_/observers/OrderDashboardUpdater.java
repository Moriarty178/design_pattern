package behavioral_patterns.observer_pattern_.observers;

import behavioral_patterns.observer_pattern_.event.OrderCreatedEvent;
import behavioral_patterns.observer_pattern_.observer.Observer;
import org.springframework.stereotype.Component;

@Component
public class OrderDashboardUpdater implements Observer<OrderCreatedEvent> { // 1 observer <=> subscriber "update dashboard": của subject "OrderCreated"

    @Override
    public void update(OrderCreatedEvent event) {
        System.out.println("📊 Updating dashboard with Order ID: " + event.getOrderId());
    }
}
