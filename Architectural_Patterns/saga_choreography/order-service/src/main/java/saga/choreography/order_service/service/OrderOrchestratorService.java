package saga.choreography.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saga.choreography.common.dto.OrderRequest;
//import saga.choreography.inventory_service.service.InventoryService;
//import saga.choreography.payment_service.service.PaymentService;

@Service
public class OrderOrchestratorService {
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @Autowired
//    private PaymentService paymentService;
//
//    public void createOrderSaga(OrderRequest request) {
//        try { // quy trình nếu suôn sẻ, ngon, ko có lỗi
//            orderService.createOrder(request); // đặt hàng
//            inventoryService.reserveInventory(request); // - quantity
//            paymentService.processPayment(request); // thanh toán
//            orderService.markOrderCompleted(request.getOrderId()); // đánh dấu hoàn thành
//        } catch(Exception ex) { // nếu lỗi -> rollback (compensation transaction)
//            paymentService.cancelPayment(request); // hủy thanh toán
//            inventoryService.releaseInventory(request); // + quantity
//            orderService.cancelOrder(request.getOrderId()); // hủy đặt hàng
//        }
//    }
}