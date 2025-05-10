package saga.choreography.inventory_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import saga.choreography.common.dto.OrderRequest;
import saga.choreography.common.event.InventoryReservedEvent;
import saga.choreography.common.event.OrderCreatedEvent;
import saga.choreography.common.event.PaymentFailedEvent;

@Service
public class InventoryService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void reserveInventory(OrderRequest request) {
        // 1. Saga Orchestration
        System.out.println("Reserving inventory...");
        // Gọi DB giảm tồn kho (- quantity)
    }

    public void releaseInventory(OrderRequest request) {
        System.out.println("Releasing inventory...");
        // Rollback tăng quantity lại khi có lỗi
    }




    @KafkaListener(topics = "order-created-topic", groupId = "inventory-group", clientIdPrefix = "[INVENTORY-CONSUMER] ${client-id.prefix}")
    public void handleReserveInventory(OrderCreatedEvent event) {
        System.out.println("[inv-service]  🕛  Reserving inventory ...");

        // 1. handle
        boolean reserved = true; // logic check kho, vd này giả định thành công

        // 2. Event publishing -> payment-service
        if (reserved) {
            System.out.println("[inv-service]  ✔   Inventory reserved -> send event to payment-service.\n");
            kafkaTemplate.send("inventory-reserved-topic", new InventoryReservedEvent(event.getOrderId(), event.getProductId(), true));
        } else {
            // Gủi thông báo thất bại
            System.err.println("[inv-service]  ❌  Inventory failed -> send event to payment-service.\n");
            kafkaTemplate.send("inventory-reserved-topic", new InventoryReservedEvent(event.getOrderId(), event.getProductId(), false));
        }
    }

    @KafkaListener(topics = "payment-failed-topic", groupId = "inventory-group", clientIdPrefix = "[INVENTORY-CONSUMER] ${client-id.prefix}")
    public void handlePaymentFail(PaymentFailedEvent event) {
        System.err.println("[inv-service]  ❌  Payment failed: " + event.getReason() + " -> release inventory.\n");
        // tăng lại tồn kho
    }
}

