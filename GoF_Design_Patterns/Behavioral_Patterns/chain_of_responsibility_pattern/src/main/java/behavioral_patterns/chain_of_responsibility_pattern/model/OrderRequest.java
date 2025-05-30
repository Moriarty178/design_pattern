package behavioral_patterns.chain_of_responsibility_pattern.model;

public class OrderRequest {
    private String orderId;
    private boolean inventoryAvailable;
    private boolean paymentCompleted;
    private boolean confirmed;

    public OrderRequest(String orderId, boolean inventoryAvailable, boolean paymentCompleted, boolean confirmed) {
        this.orderId = orderId;
        this.inventoryAvailable = inventoryAvailable;
        this.paymentCompleted = paymentCompleted;
        this.confirmed = confirmed;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isInventoryAvailable() {
        return inventoryAvailable;
    }

    public void setInventoryAvailable(boolean inventoryAvailable) {
        this.inventoryAvailable = inventoryAvailable;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }

    public void setPaymentCompleted(boolean paymentCompleted) {
        this.paymentCompleted = paymentCompleted;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
