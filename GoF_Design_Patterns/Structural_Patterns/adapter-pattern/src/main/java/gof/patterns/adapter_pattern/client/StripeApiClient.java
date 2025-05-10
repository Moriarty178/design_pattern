package gof.patterns.adapter_pattern.client;

import gof.patterns.adapter_pattern.model.StripeResponse;
import org.springframework.stereotype.Component;

@Component
public class StripeApiClient { // legacy

    public StripeResponse makeStripePayment(String userId, double amount, String currency) {
        // handle
        System.out.printf("Calling Stripe API: user=%s, value=%s, currency=%s.\n", userId, amount, currency);
        return new StripeResponse(userId, amount, currency, "SUCCESS", "MESS");
    }
}
