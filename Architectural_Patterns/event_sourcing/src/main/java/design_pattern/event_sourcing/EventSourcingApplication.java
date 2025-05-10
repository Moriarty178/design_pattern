package design_pattern.event_sourcing;

import design_pattern.event_sourcing.command.*;
import design_pattern.event_sourcing.event.OrderCanceledEvent;
import design_pattern.event_sourcing.event.OrderDeletedEvent;
import design_pattern.event_sourcing.model.OrderDto;
import design_pattern.event_sourcing.query.GetOrderQuery;
import design_pattern.event_sourcing.query.OrderQueryHandler;
import design_pattern.event_sourcing.repository.OrderEventStore;
import org.hibernate.sql.Update;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventSourcingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingApplication.class, args);

		// repo + command, query handler
		OrderEventStore eventStore = new OrderEventStore();
		OrderQueryHandler queryHandler = new OrderQueryHandler(eventStore);
		OrderCommandHandler commandHandler = new OrderCommandHandler(eventStore, queryHandler);

		// --- Command: tao event & handle(save) ---
		// create
		CreateOrderCommand createCommand = new CreateOrderCommand("Acer Nitro 5", 999);
		String orderId = commandHandler.handle(createCommand);

		// update
		UpdateOrderCommand updateCommand2 = new UpdateOrderCommand(orderId, "Acer Nitro 5 v2", 900);
		commandHandler.handle(updateCommand2);

		UpdateOrderCommand updateCommand3 = new UpdateOrderCommand(orderId, "Acer Nitro 5 v3", 850);
		String stopEventId = commandHandler.handle(updateCommand3);

		UpdateOrderCommand updateCommand4 = new UpdateOrderCommand(orderId, "Acer Nitro 5 v4", 799);
		commandHandler.handle(updateCommand4);

		// cancel
		CancelOrderCommand cancelCommand = new CancelOrderCommand(orderId, "3");
		commandHandler.handle(cancelCommand);

		// delete
		DeleteOrderCommand deleteCommand = new DeleteOrderCommand(orderId, "4");
		commandHandler.handle(deleteCommand);

		// --- Query: get order details ---
		// current state
		GetOrderQuery getOrderQuery = new GetOrderQuery(orderId);// sau này đối tượng truy vấn có thể phức tạp hơn là chỉ có orderId, nền cần để object làm input
		OrderDto orderDto = queryHandler.handle(getOrderQuery);

		System.out.println("Order details: ==========");
		System.out.println("ID: " + orderDto.getOrderId());
		System.out.println("Product name: " + orderDto.getProductName());
		System.out.println("Quantity: " + orderDto.getQuantity());
		System.out.println("Status: " + orderDto.getStatus() + "\n");

		// Rollback
		orderDto = queryHandler.rollback(getOrderQuery, OrderDeletedEvent.class, 1);
		System.out.println("Order after rollback v1: ========");
		System.out.println("ID: " + orderDto.getOrderId());
		System.out.println("Product name: " + orderDto.getProductName());
		System.out.println("Quantity: " + orderDto.getQuantity());
		System.out.println("Status: " + orderDto.getStatus() + "\n");

		orderDto = queryHandler.rollback(getOrderQuery, stopEventId, 1);
		System.out.println("Stop EventId: " + stopEventId);
		System.out.println("Order after rollback v2: ========");
		System.out.println("ID: " + orderDto.getOrderId());
		System.out.println("Product name: " + orderDto.getProductName());
		System.out.println("Quantity: " + orderDto.getQuantity());
		System.out.println("Status: " + orderDto.getStatus());
	}

}
