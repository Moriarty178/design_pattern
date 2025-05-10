package design_pattern.event_sourcing.command;

import design_pattern.event_sourcing.event.*;
import design_pattern.event_sourcing.model.Order;
import design_pattern.event_sourcing.query.OrderQueryHandler;
import design_pattern.event_sourcing.repository.OrderEventStore;

import java.util.UUID;

public class OrderCommandHandler {
    private OrderEventStore eventStore;
    private OrderQueryHandler queryHandler;

    public OrderCommandHandler(OrderEventStore eventStore, OrderQueryHandler queryHandler) {
        this.eventStore = eventStore;
        this.queryHandler = queryHandler;
    }

    public String handle(CreateOrderCommand command) {
        String orderId = UUID.randomUUID().toString();
        //String eventId = UUID.randomUUID().toString();
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, command.getProductName(), command.getQuantity(), generateEventId());
        eventStore.save(event);

        System.out.println("Event saved: CREATED with ID: " + orderId);
        return orderId;
    }

    public String handle(UpdateOrderCommand command) {
        // tao event
        //String eventId = UUID.randomUUID().toString();
        OrderUpdatedEvent event = new OrderUpdatedEvent(command.getOrderId(), command.getProductName(), command.getQuantity(), generateEventId());
        // luu event vao total_event
        eventStore.save(event);
        System.out.printf("Event saved: UPDATED with ID: %s, eventId: %s%n", command.getOrderId(), event.getEventId());

        return event.getEventId();
    }

    public void handle(CancelOrderCommand command) {
        // tao event
        //String eventId = UUID.randomUUID().toString();
        OrderCanceledEvent event = new OrderCanceledEvent(command.getOrderId(), command.getStatus(), generateEventId());

        // validation
        Order order = queryHandler.replay(eventStore.findByOrderId(command.getOrderId()));
        if ("DELETE".equals(order.getStatus())) {
            throw new IllegalStateException("Cannot cancel a deleted order.");
        }

        // luu event
        eventStore.save(event);
        System.out.println("Event saved: CANCELED with ID: " + command.getOrderId());
    }

    public void handle(DeleteOrderCommand command) {
        // tao event
        OrderDeletedEvent event = new OrderDeletedEvent(command.getOrderId(), command.getStatus(), generateEventId());
        // luu event
        eventStore.save(event);
        System.out.println("Event saved: DELETED with ID: " + command.getOrderId());
    }

    public String generateEventId() {
        return UUID.randomUUID().toString();
    }


}

