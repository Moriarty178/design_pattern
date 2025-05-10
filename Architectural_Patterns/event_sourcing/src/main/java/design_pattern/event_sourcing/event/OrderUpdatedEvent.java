package design_pattern.event_sourcing.event;

import java.time.LocalDateTime;

public class OrderUpdatedEvent implements OrderEvent {
    private final String orderId;
    private final String productName;
    private final int quantity;
    private final String eventId;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public OrderUpdatedEvent(String orderId, String productName, int quantity, String eventId) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.eventId = eventId;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getEventId() {
        return eventId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
