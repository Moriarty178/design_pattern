package saga.choreography.common.event;

public class InventoryReservedEvent {
    private Long orderId;
    private Long productId;
    private boolean success;

    public InventoryReservedEvent() {
    }

    public InventoryReservedEvent(Long orderId, Long productId, boolean success) {
        this.orderId = orderId;
        this.productId = productId;
        this.success = success;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
