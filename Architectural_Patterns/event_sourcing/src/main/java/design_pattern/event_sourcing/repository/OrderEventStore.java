package design_pattern.event_sourcing.repository;

import design_pattern.event_sourcing.event.OrderEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderEventStore {
    private List<OrderEvent> events = new ArrayList<>(); // sử dụng interface để chứa cả toàn bộ các event (implementation) của nó.

    public void save(OrderEvent event) { // tuong tu de OrderEvent de co the nhan vao tat ca Event: create, update, delete, v.v... (deu la implementation cua OrderEvent)
        events.add(event);
    }

    public List<OrderEvent> findByOrderId(String orderId) {
        return events.stream()
                .filter(e -> e.getOrderId().equals(orderId))
                .collect(Collectors.toList());
    }
}
