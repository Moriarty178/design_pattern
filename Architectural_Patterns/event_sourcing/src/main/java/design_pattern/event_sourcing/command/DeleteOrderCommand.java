package design_pattern.event_sourcing.command;

public class DeleteOrderCommand {
    private final String orderId;
    private final String status;

    public DeleteOrderCommand(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
