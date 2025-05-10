package design_pattern.event_sourcing.query;

public class GetOrderQuery {
    private final String orderId;

    public GetOrderQuery(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
