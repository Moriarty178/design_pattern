package saga.choreography.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import saga.choreography.common.dto.OrderRequest;
import saga.choreography.common.event.InventoryReservedEvent;
import saga.choreography.common.event.PaymentFailedEvent;
import saga.choreography.common.event.PaymentProcessedEvent;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void processPayment(OrderRequest request) {
        System.out.println("Processing payment...");
        // Gọi xử lý thanh toán
        //throw new RuntimeException("Payment failed."); // giả lập fail
    }

    public void cancelPayment(OrderRequest request) {
        System.out.println("Cancelling payment...");
        //logic rollback payment
    }

    @KafkaListener(topics = "inventory-reserved-topic", groupId = "saga-group", clientIdPrefix = "payment-service")
    public void handleProcessPayment(InventoryReservedEvent event) {
        if (!event.isSuccess()) {
            System.err.println("[pay-service]  ❌  Inventory failed -> cannot proceed to payment. Send events to all previous services implemented.\n");
            kafkaTemplate.send("payment-failed-topic", new PaymentFailedEvent(event.getOrderId(), "Inventory reservation failed."));

            return;
        }

        System.out.println("[pay-service]  🕛  Processing payment...");
        // 1. logic xử lý thanh toán, vd này giả sử thành công
        boolean paid = false;

        // 2. send event
        // - success -> order-service
        // - fail -> gửi đồng loạt cho all service đã thực hiện trước đó: inventory-service, order-service
        if (paid) {
            System.out.println("[pay-service]  ✔   Payment successfully -> send event to order-service.\n");
            kafkaTemplate.send("payment-processed-topic", new PaymentProcessedEvent(event.getOrderId(), true));
        } else {
            System.err.println("[pay-service]  ❌  Payment failed -> Send events to all previous services implemented.\n");
            for (int i = 0; i < 10; i++) { // thêm partition cho topic "payment-failed-topic" & sử dụng key phân vùng & inv, ord cùng group-id "saga-group": phù hợp với công việc lớn chia thành nhiều event -> các partition -> gán cho các consumer.
                kafkaTemplate.send("payment-failed-topic", String.valueOf(i), new PaymentFailedEvent(event.getOrderId(), "Insufficient funds No." + i));
            }
            //kafkaTemplate.send("payment-failed-topic", new PaymentFailedEvent(event.getOrderId(), "Insufficient funds ---."));
        }
    }
}
