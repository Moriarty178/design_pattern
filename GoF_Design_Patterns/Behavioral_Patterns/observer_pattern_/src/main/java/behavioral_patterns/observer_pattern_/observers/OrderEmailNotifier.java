package behavioral_patterns.observer_pattern_.observers;

import behavioral_patterns.observer_pattern_.event.OrderCreatedEvent;
import behavioral_patterns.observer_pattern_.observer.Observer;
import org.springframework.stereotype.Component;

@Component
public class OrderEmailNotifier implements Observer<OrderCreatedEvent> { // concrete observer: EmailNotifier của subject "OrderCreated"
    @Override
    public void update(OrderCreatedEvent event) {
        System.out.println("📧 Sending email to: " + event.getCustomerEmail());
    }
}
