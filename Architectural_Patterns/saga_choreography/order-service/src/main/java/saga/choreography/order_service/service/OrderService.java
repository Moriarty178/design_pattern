package saga.choreography.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import saga.choreography.common.dto.OrderRequest;
import saga.choreography.common.event.OrderCreatedEvent;
import saga.choreography.common.event.PaymentFailedEvent;
import saga.choreography.common.event.PaymentProcessedEvent;

@Service
public class OrderService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void createOrder(OrderRequest request) {
        // Orchestration
        System.out.println("Creating order...");
        // Lưu đơn hàng vào DB
    }

    public void cancelOrder(Long orderId) {
        System.out.println("Cancelling order...");
        // logic rollback
    }

    public void markOrderCompleted(Long orderId) {
        System.out.println("Order completed.");
    }



    public void handleCreateOrder(OrderRequest request) {
        System.out.println("[ord-service]  🕛  Creating order ...");
        // 1. Handle

        // 2. Event publishing -> inventory-service
        OrderCreatedEvent event = new OrderCreatedEvent(request.getOrderId(), request.getProductId(), request.getQuantity());
        kafkaTemplate.send("order-created-topic", event);
    }

    @KafkaListener(topics = "payment-processed-topic", groupId = "order-group", clientIdPrefix = "[ORDER-CONSUMER] ${client-id.prefix}")
    public void handlePaymentSuccess(PaymentProcessedEvent processedEvent) {
        System.out.println("[ord-service] Payment  ✔   successfully -> marking order as completed.");
        // update trạng thái đơn hàng thành COMPLETED
    }
//
//    @KafkaListener(topics = "inventory-reversed-topic", groupId = "order-group")
//    public void handleInventoryReversedFail(InventoryReservedEvent event) {
//        System.out.println("Inventory reserved failed -> cancelling order.");
//        // hủy đơn hàng
//    }

    @KafkaListener(topics = "payment-failed-topic", groupId = "order-group", clientIdPrefix = "[ORDER-CONSUMER] ${client-id.prefix}") // thêm prefix để dễ nhận ra consumer nào đã xử lý partition của topic khi kiểm tra "kafka-consumer-groups --describe --group <group>"
    public void handlePaymentFailed(PaymentFailedEvent event) {
        System.err.println("[ord-service]  ❌  Payment failed: " + event.getReason() + " -> cancelling order.\n");
        // hủy đơn hàng
    }





}
