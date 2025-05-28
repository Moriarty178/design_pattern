package behavioral_patterns.observer_pattern_.event;

public class OrderCreatedEvent {
    private String orderId;
    private String customerEmail;
    private String shippingAddress;

    public OrderCreatedEvent(String orderId, String customerEmail, String shippingAddress) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
