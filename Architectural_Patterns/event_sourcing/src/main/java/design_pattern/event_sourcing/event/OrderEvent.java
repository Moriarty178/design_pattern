package design_pattern.event_sourcing.event;

import java.time.LocalDateTime;

public interface OrderEvent {
    String getOrderId();
    String getEventId(); // bắt buộc phải có eventId để có thể rollback lại bất ký event cụ thể nào - bao gồm cả một phiên bản cụ thể của một event lặp lại nhiều lần như updateEvent
    LocalDateTime getTimestamp(); // sort list events
}
