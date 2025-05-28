package behavioral_patterns.observer_pattern_.registry;

import behavioral_patterns.observer_pattern_.event.OrderCreatedEvent;
import behavioral_patterns.observer_pattern_.observer.Observer;
import behavioral_patterns.observer_pattern_.observer.OrderCreatedSubject;
import behavioral_patterns.observer_pattern_.observers.OrderDashboardUpdater;
import behavioral_patterns.observer_pattern_.observers.OrderEmailNotifier;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderCreatedObserverRegistry {

    private final OrderCreatedSubject subject;
    private List<Observer<OrderCreatedEvent>> observers;

    @Autowired

    public OrderCreatedObserverRegistry(
            OrderCreatedSubject subject,
            OrderEmailNotifier emailNotifier,
            OrderDashboardUpdater dashboardUpdater) {
        this.subject = subject;
        this.observers = List.of(emailNotifier, dashboardUpdater);
    }

    @PostConstruct
    public void register() {
        observers.forEach(subject::registerObserver);
    }
}
