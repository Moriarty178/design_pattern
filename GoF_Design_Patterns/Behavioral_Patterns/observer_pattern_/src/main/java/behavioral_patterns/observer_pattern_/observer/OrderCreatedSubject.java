package behavioral_patterns.observer_pattern_.observer;

import behavioral_patterns.observer_pattern_.event.OrderCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderCreatedSubject implements Subject<OrderCreatedEvent> { // 1 concrete subject <=> publisher: "OrderCreated"

    private final List<Observer<OrderCreatedEvent>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<OrderCreatedEvent> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<OrderCreatedEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(OrderCreatedEvent event) {
        for (Observer<OrderCreatedEvent> obs : observers) {
            obs.update(event);// gửi thông báo cho toàn bộ observer đang listen subject "created" (trong list<observer>)
        }
    }
}
