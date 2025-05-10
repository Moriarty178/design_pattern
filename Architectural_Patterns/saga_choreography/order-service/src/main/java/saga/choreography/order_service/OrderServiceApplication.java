package saga.choreography.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import saga.choreography.common.dto.OrderRequest;
import saga.choreography.order_service.service.OrderOrchestratorService;
import saga.choreography.order_service.service.OrderService;

@SpringBootApplication
@ComponentScan(basePackages = "saga.choreography")
public class OrderServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrderServiceApplication.class, args);
//		System.out.println("\n\n");
//		System.out.println("=============== Saga Orchestration =============");
		/**
		 * Dùng orchestrator thì: nó phải dependency payment, inventory, ... => đóng gói all vào order servie
		 * Khi chạy order-service thì mấy thằng kia cũng được chạy (nhưng vai trò chỉ như thư viện)
		 * Còn khi dùng Saga-Choreography - môi trường phân tán - microservice => cân:
		 * - bỏ dependency trong để all service ko depend nhau trong pom.xml của chúng
		 * - Thêm 'execution' trong pom.xml của all để nó nhận diện main class
		 * - tạo .jar : "mvn clean install -DskipTests"
		 */
//
//		OrderOrchestratorService orchestrator = context.getBean(OrderOrchestratorService.class);
//		OrderRequest orderRequest = new OrderRequest(27L, 29L, 799, 500.0);
//
//		orchestrator.createOrderSaga(orderRequest);
//
//		System.out.println("\n\n");
		System.out.println("============= Saga Choreography =============");
		OrderService orderService = context.getBean(OrderService.class);
		OrderRequest request = new OrderRequest(77L, 99L, 789, 1500.0);

		orderService.handleCreateOrder(request);
	}

}
