package behavioral_patterns.chain_of_responsibility_pattern.config;

import behavioral_patterns.chain_of_responsibility_pattern.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HandlerChainConfig {

    //@Primary
    @Bean
    public OrderHandler orderProcessingChain(
            InventoryCheckHandler inventoryHandler,
            PaymentCheckHandler paymentHandler,
            OrderConfirmHandler confirmationHandler,
            ShippingNotificationHandler shippingNotificationHandler) {

        inventoryHandler
                .setNex(paymentHandler)
                .setNex(confirmationHandler)
                .setNex(shippingNotificationHandler);

        return inventoryHandler;
    }
}
