package saga.choreography.common.event;

public class PaymentProcessedEvent {
    private Long orderId;
    private boolean success;

    public PaymentProcessedEvent() {
    }

    public PaymentProcessedEvent(Long orderId, boolean success) {
        this.orderId = orderId;
        this.success = success;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
