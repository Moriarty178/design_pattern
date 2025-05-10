package design_pattern.event_sourcing.command;
// Phan xu ly lien quan den Write
public class CreateOrderCommand {
    private final String productName;
    private final int quantity;

    public CreateOrderCommand(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
