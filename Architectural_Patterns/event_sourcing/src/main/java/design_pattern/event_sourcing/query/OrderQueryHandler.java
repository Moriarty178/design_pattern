package design_pattern.event_sourcing.query;

import design_pattern.event_sourcing.event.*;
import design_pattern.event_sourcing.model.Order;
import design_pattern.event_sourcing.model.OrderDto;
import design_pattern.event_sourcing.repository.OrderEventStore;

import java.util.Comparator;
import java.util.List;

public class OrderQueryHandler {
    private OrderEventStore eventStore;

    public OrderQueryHandler(OrderEventStore eventStore) {
        this.eventStore = eventStore;
    }

    public OrderDto handle(GetOrderQuery query) {
        List<OrderEvent> events = eventStore.findByOrderId(query.getOrderId());
        if (events.isEmpty()) {
            throw new RuntimeException("Order not found.");
        }

        events.sort(Comparator.comparing(OrderEvent::getTimestamp));

        // tai tao lai order dua vao events
        Order order = replay(events);
        return new OrderDto(order.getOrderId(), order.getProductName(), order.getQuantity(), order.getStatus());
    }

    public OrderDto rollback(GetOrderQuery query, Class<? extends OrderEvent> stopEvent, int until) {
        List<OrderEvent> events = eventStore.findByOrderId(query.getOrderId());

        if (events.isEmpty()) {
            throw new RuntimeException("Order not found to rollback.");
        }
        events.sort(Comparator.comparing(OrderEvent::getTimestamp));

        Order order = replayUntil(events, stopEvent, until);
        return new OrderDto(order.getOrderId(), order.getProductName(), order.getQuantity(), order.getStatus());
    }

    public OrderDto rollback(GetOrderQuery query, String eventId, int until) {
        List<OrderEvent> events = eventStore.findByOrderId(query.getOrderId());
        if (events.isEmpty()) {
            throw new RuntimeException("Order not found to rollback.");
        }

        events.sort(Comparator.comparing(OrderEvent::getTimestamp));

        Order order = replayUntil(events, until, eventId);

        return new OrderDto(order.getOrderId(), order.getProductName(), order.getQuantity(), order.getStatus());
    }

    public Order replay(List<OrderEvent> events) {
        Order order = new Order();

        for (OrderEvent event : events) {
            if (event instanceof OrderCreatedEvent) {
                order.setOrderId(event.getOrderId());
                order.setProductName(((OrderCreatedEvent) event).getProductName());
                order.setQuantity(((OrderCreatedEvent) event).getQuantity());
            } else if (event instanceof OrderUpdatedEvent) {
                order.setProductName(((OrderUpdatedEvent) event).getProductName());
                order.setQuantity(((OrderUpdatedEvent) event).getQuantity());
            } else if (event instanceof OrderCanceledEvent) {
                order.setStatus(((OrderCanceledEvent) event).getStatus());
            } else if (event instanceof OrderDeletedEvent) { // ko co gap event delete truoc set status = "delete" roi gap event cancel sau roi set status = "cancel". Boi theo logic khong the "cancel" sau khi "delete" hay noi cach khac delete luon xuat hien su
                order.setStatus(((OrderDeletedEvent) event).getStatus());
            }
        }

        return order;
    }

    // rollback ve mot state cu the: replay binh thuong, break khi gap stopEvent
    public Order replayUntil(List<OrderEvent> events, Class<? extends OrderEvent> stopAtEventType, int until) {
        Order order = new Order();
        for (OrderEvent event : events) {
            if (until == 0 && event.getClass().equals(stopAtEventType)) {
                break;
            }

            if (event instanceof OrderCreatedEvent) {
                order.setOrderId(event.getOrderId());
                order.setProductName(((OrderCreatedEvent) event).getProductName());
                order.setQuantity(((OrderCreatedEvent) event).getQuantity());
            } else if (event instanceof OrderUpdatedEvent) {
                order.setProductName(((OrderUpdatedEvent) event).getProductName());
                order.setQuantity(((OrderUpdatedEvent) event).getQuantity());
            } else if (event instanceof OrderCanceledEvent) {
                order.setStatus(((OrderCanceledEvent) event).getStatus());
            } else if (event instanceof OrderDeletedEvent) { // ko co gap event delete truoc set status = "delete" roi gap event cancel sau roi set status = "cancel". Boi theo logic khong the "cancel" sau khi "delete" hay noi cach khac delete luon xuat hien su
                order.setStatus(((OrderDeletedEvent) event).getStatus());
            }

            if ((event.getClass().equals(stopAtEventType)) & until == 1) { // ngay sau stopEvent
                break;
            }
        }

        return order;
    }

    public Order replayUntil(List<OrderEvent> events, int until, String eventId) {
        Order order =  new Order();
        for (OrderEvent event : events) {
            if (event.getEventId().equals(eventId) && until == 0) {
                break;
            }

            if (event instanceof OrderCreatedEvent) {
                order.setOrderId(event.getOrderId());
                order.setProductName(((OrderCreatedEvent) event).getProductName());
                order.setQuantity(((OrderCreatedEvent) event).getQuantity());
            } else if (event instanceof OrderUpdatedEvent) {
                order.setProductName(((OrderUpdatedEvent) event).getProductName());
                order.setQuantity(((OrderUpdatedEvent) event).getQuantity());
            } else if (event instanceof OrderCanceledEvent) {
                order.setStatus(((OrderCanceledEvent) event).getStatus());
            } else if (event instanceof OrderDeletedEvent) {
                order.setStatus(((OrderDeletedEvent) event).getStatus());
            }

            if (event.getEventId().equals(eventId) && until == 1) {
                break;
            }
        }

        return order;
    }
}


