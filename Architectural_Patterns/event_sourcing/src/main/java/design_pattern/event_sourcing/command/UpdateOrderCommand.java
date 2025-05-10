package design_pattern.event_sourcing.command;

public class UpdateOrderCommand {
    private final String orderId; // muc dich: chi co the khoi tao = constructor
    private final String productName;
    private final int quantity;

    public UpdateOrderCommand(String orderId, String productName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
