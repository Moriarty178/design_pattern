package design_pattern.event_sourcing.event;

import java.time.LocalDateTime;

public class OrderCanceledEvent implements OrderEvent{
    private final String orderId;
    private final String status;
    private final String eventId;

    private final LocalDateTime timestamp = LocalDateTime.now();

    public OrderCanceledEvent(String orderId, String status, String eventId) {
        this.orderId = orderId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
