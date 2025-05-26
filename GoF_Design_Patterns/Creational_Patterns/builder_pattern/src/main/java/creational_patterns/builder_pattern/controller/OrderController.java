package creational_patterns.builder_pattern.controller;

import creational_patterns.builder_pattern.model.Order;
import creational_patterns.builder_pattern.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @GetMapping("/sample")
    public String createSampleOrder() {
        List<Product> products = List.of(
                new Product("Macbook Pro", 1, 2400),
                new Product("Mouse Logitech", 2, 50)
        );

        Order order = new Order.Builder("Alice", products)
                .shippingAddress("123 Nguyen Trai, Thanh Xuan, Ha Noi")
                .paymentMethod("Credit Card")
                .note("Deliver in morning")
                .discountCode("MERR2025")
                .build();

        return order.toString();
    }
}
